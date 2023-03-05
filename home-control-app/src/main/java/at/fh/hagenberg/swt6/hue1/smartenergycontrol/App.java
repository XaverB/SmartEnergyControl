package at.fh.hagenberg.swt6.hue1.smartenergycontrol;

import at.fh.hagenberg.swt6.hue1.smartenergycontrol.ac.control.AirConditionApi;
import at.fh.hagenberg.swt6.hue1.smartenergycontrol.ac.control.AirConditionProvider;
import at.fh.hagenberg.swt6.hue1.smartenergycontrol.balcony.power.plant.InverterApi;
import at.fh.hagenberg.swt6.hue1.smartenergycontrol.balcony.power.plant.InverterApiProvider;
import at.fh.hagenberg.swt6.hue1.smartenergycontrol.boiler.ElectricBoilerApi;
import at.fh.hagenberg.swt6.hue1.smartenergycontrol.boiler.ElectricBoilerApiProvider;
import at.fh.hagenberg.swt6.hue1.smartenergycontrol.timer.bean.Timer;
import at.fh.hagenberg.swt6.hue1.smartenergycontrol.timer.bean.TimerEvent;
import at.fh.hagenberg.swt6.hue1.smartenergycontrol.timer.bean.TimerListener;
import at.fh.hagenberg.swt6.hue1.smartenergycontrol.timer.bean.TimerProvider;

import java.util.ServiceLoader;

public class App implements TimerListener {
    private final InverterApi inverterApi;
    private final AirConditionApi airConditionApi;
    private final ElectricBoilerApi electricBoilerApi;
    private final Timer timer;

    private final MaxCapacityCache acTemperatureCache = new MaxCapacityCache(10);
    private final MaxCapacityCache inverterKwhCache = new MaxCapacityCache(10);

    private App(InverterApi inverterApi,
                AirConditionApi airConditionApi,
                ElectricBoilerApi electricBoilerApi,
                Timer timer) {

        this.inverterApi = inverterApi;
        this.airConditionApi = airConditionApi;
        this.electricBoilerApi = electricBoilerApi;
        this.timer = timer;
        initializeTimer();
    }

    private void initializeTimer() {
        this.timer.addTimerListener(this);
    }

    public static App build(int intervalSeconds, int numberOfTicks) {
        var inverterApi = ServiceLoader.load(InverterApiProvider.class).findFirst().orElseThrow();
        var airConditionApi = ServiceLoader.load(AirConditionProvider.class).findFirst().orElseThrow();
        var electricBoilerApi = ServiceLoader.load(ElectricBoilerApiProvider.class).findFirst().orElseThrow();
        var timer = ServiceLoader.load(TimerProvider.class).findFirst().orElseThrow();

        return new App(
                inverterApi.createInverterApi(),
                airConditionApi.createAirConditionApi(),
                electricBoilerApi.createElectricBoiler(),
                timer.createTimer(intervalSeconds * 1000, numberOfTicks)
        );
    }

    public void start() {
        this.timer.start();
    }

    @Override
    public void expired(TimerEvent event) {
        double kwh = inverterApi.getActualCurrent();
        double temperature = airConditionApi.getRoomTemperature();

        System.out.printf("Received ac temperature %.3f and power plant kWh %.3f%n", temperature, kwh);
        inverterKwhCache.add(kwh);
        acTemperatureCache.add(temperature);

        double averageKwh = inverterKwhCache.getAverage();
        double averageTemperature = acTemperatureCache.getAverage();
        System.out.printf("Average temperature %.3f and average kWh %.3f%n", averageTemperature, averageKwh);

        AdaptAcPowerStatus(averageKwh, averageTemperature);
        AdaptBoilerPowerStatus(averageKwh);

        System.out.println("---------------------------------------------");
    }

    private void AdaptBoilerPowerStatus(double averageKwh) {
        final double minBoilerTemperature = 40;
        final double minPowerPlantKwh = 400;

        double boilerTemperature = electricBoilerApi.getBoilerTemperature();
        final boolean shouldTurnOnBoiler = boilerTemperature < minBoilerTemperature && averageKwh >= minPowerPlantKwh;
        if(shouldTurnOnBoiler) {
            System.out.printf("Turning on boiler, because the temperature %.3f is below 40 and the power plant produces %.3f on average%n", boilerTemperature, averageKwh);
            electricBoilerApi.turnOn();
        }
    }

    private void AdaptAcPowerStatus(double averageKwh, double averageTemperature) {
        final double turnOffTemperature = 22;
        final double turnOnTemperature = 24;
        final double minPowerPlantKwh = 100;

        if(averageTemperature < turnOffTemperature) {
            System.out.printf("Turning off ac since the average temperature (%.3f) is below 22%n", averageTemperature);
            airConditionApi.turnOff();
        } else if (averageTemperature > turnOnTemperature && averageKwh > minPowerPlantKwh) {
            System.out.printf("Turning on ac since the average temperature (%.3f) is above 24 and the power plant produces %.3f on average%n", averageTemperature, averageKwh);
            airConditionApi.turnOn();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        final int runtime = 1000 * 5 * 10 + 1000;

        var app = App.build(5, 10);
        app.start();
        Thread.sleep(runtime);
    }
}
