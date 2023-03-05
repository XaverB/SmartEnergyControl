package at.fh.hagenberg.swt6.hue1.smartenergycontrol.boiler.impl;

import at.fh.hagenberg.swt6.hue1.smartenergycontrol.boiler.ElectricBoilerApi;
import at.fh.hagenberg.swt6.hue1.smartenergycontrol.noise.generator.NoiseGenerator;

public class MockElectricBoilerApi implements ElectricBoilerApi {
    private final NoiseGenerator noiseGenerator;

    public MockElectricBoilerApi(NoiseGenerator noiseGenerator) {
        if (noiseGenerator.getMin() != 0.0)
            throw new IllegalArgumentException("NoiseGenerator: min value must bei 0.1");
        if (noiseGenerator.getMax() != 1.0)
            throw new IllegalArgumentException("NoiseGenerator: max value must bei 1.0");

        this.noiseGenerator = noiseGenerator;
    }

    @Override
    public void turnOn() {
        System.out.println("ElectricBoiler received power on.");
    }

    @Override
    public double getBoilerTemperature() {
        return scale(noiseGenerator.get());
    }

    /**
     * Scales a value in range 0.1 - 1.0 to 1 - 100 without losing decimals
     *
     * @param value in range 0.1 - 1.0
     * @return scaled value
     */
    public double scale(double value) {
        // scaling in two steps
        // 1. subtract the lower bound (0.1), so we get a value from 0 to 0.9
        // 2. scale the value by multiplying with ration 1 to 100 and subtracting 1 to shift it to the desired value range
        double scaled = (value - 0.1) * (100 - 1) / (1.0 - 0.1) + 1;
        return Math.round(scaled);
    }
}
