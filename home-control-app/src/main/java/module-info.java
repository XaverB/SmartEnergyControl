import at.fh.hagenberg.swt6.hue1.smartenergycontrol.ac.control.AirConditionProvider;
import at.fh.hagenberg.swt6.hue1.smartenergycontrol.balcony.power.plant.InverterApiProvider;
import at.fh.hagenberg.swt6.hue1.smartenergycontrol.boiler.ElectricBoilerApiProvider;
import at.fh.hagenberg.swt6.hue1.smartenergycontrol.timer.bean.TimerProvider;

module home.control.app {
    requires boiler.control;
    uses ElectricBoilerApiProvider;

    requires ac.control;
    uses AirConditionProvider;

    requires balcony.power.plant;
    uses InverterApiProvider;

    requires timer.bean;
    uses TimerProvider;
}