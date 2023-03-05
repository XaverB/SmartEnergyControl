package at.fh.hagenberg.swt6.hue1.smartenergycontrol.noise.generator.impl;

import at.fh.hagenberg.swt6.hue1.smartenergycontrol.noise.generator.NoiseGenerator;

import java.util.Random;

/**
 * Generates pseudo random values with java.util.Random
 */
public class SimpleNoiseGenerator extends NoiseGeneratorBase {
    private static Random random = new Random();

    public SimpleNoiseGenerator(double min, double max) {
        super(min, max);
    }

    @Override
    public double get() {
        return random.nextDouble(min, max);
    }
}
