package at.fh.hagenberg.swt6.hue1.smartenergycontrol.noise.generator.impl;

import at.fh.hagenberg.swt6.hue1.smartenergycontrol.noise.generator.NoiseGenerator;

public abstract class NoiseGeneratorBase implements NoiseGenerator {
    protected final double min;
    protected final double max;

    public NoiseGeneratorBase(double min, double max) {
        this.min = min;
        this.max = max;
    }

    @Override
    public double getMax() {
        return max;
    }

    @Override
    public double getMin() {
        return min;
    }

    @Override
    public abstract double get();
}
