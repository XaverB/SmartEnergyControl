package at.fh.hagenberg.swt6.hue1.smartenergycontrol.ac.control.impl;

import at.fh.hagenberg.swt6.hue1.smartenergycontrol.noise.generator.NoiseGenerator;

import java.util.Queue;

/**
 * This class delivers the min, mid and max values for testing purpose.
 * I do not like to export this class via the module system,
 * but I could not find any good lecture about module and testing dependencies.
 * I also would like to avoid copying this class in every module.
 */
public class NoiseGeneratorStub implements NoiseGenerator {
    private final double min;
    private final double max;
    private final Queue<Double> values;

    public NoiseGeneratorStub(double min, double max, Queue<Double> values) {
        this.min = min;
        this.max = max;
        this.values = values;
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
    public double get() {
       return values.poll();
    }
}
