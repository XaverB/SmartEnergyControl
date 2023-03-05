package at.fh.hagenberg.swt6.hue1.smartenergycontrol.balcony.power.plant.impl;

import at.fh.hagenberg.swt6.hue1.smartenergycontrol.balcony.power.plant.InverterApi;
import at.fh.hagenberg.swt6.hue1.smartenergycontrol.noise.generator.NoiseGenerator;

public class MockInverterApi implements InverterApi {
    private final NoiseGenerator noiseGenerator;

    public MockInverterApi(NoiseGenerator noiseGenerator) {
        if(noiseGenerator.getMin() != 0.0) throw new IllegalArgumentException("NoiseGenerator: min value must bei 0.0");
        if(noiseGenerator.getMax() != 1.0) throw new IllegalArgumentException("NoiseGenerator: max value must bei 1.0");

        this.noiseGenerator = noiseGenerator;
    }

    /**
     * Scales a value in the range 0.0 - 1.0 to 0.000 - 0,800
     * @param value in range 0.0 to 1.0
     * @return scaled value
     */
    private double scale(double value) {
        return value * 0.8;
    }

    @Override
    public double getActualCurrent() {
        double noise = noiseGenerator.get();
        return scale(noise);
    }
}
