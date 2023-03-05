package at.fh.hagenberg.swt6.hue1.smartenergycontrol.ac.control.impl;

import at.fh.hagenberg.swt6.hue1.smartenergycontrol.ac.control.AirConditionApi;
import at.fh.hagenberg.swt6.hue1.smartenergycontrol.noise.generator.NoiseGenerator;

public class MockAirConditionApi implements AirConditionApi {
    private final NoiseGenerator noiseGenerator;
    private boolean isOn = false;

    public MockAirConditionApi(NoiseGenerator noiseGenerator) {
        this.noiseGenerator = noiseGenerator;
    }

    @Override
    public void turnOn() {
        isOn = true;
        printStatus();
    }

    @Override
    public void turnOff() {
        isOn = false;
        printStatus();
    }

    @Override
    public double getRoomTemperature() {
        double noise = noiseGenerator.get();
        return scale(noise);
    }

    /**
     * Scales a value in range 0.1 - 1.0 to 19 - 30
     *
     * @param value in range between 0.1 and 1.0
     * @return scaled value
     */
    private double scale(double value) {
        double scaled = ((value - 0.1) / 0.9) * 11 + 19.0;
        return scaled
                ;
    }

    /**
     * Prints the current power status to the standard output
     */
    private void printStatus() {
        System.out.printf("AirCondition power status is: %s%n", isOn ? "on" : "off");
    }
}
