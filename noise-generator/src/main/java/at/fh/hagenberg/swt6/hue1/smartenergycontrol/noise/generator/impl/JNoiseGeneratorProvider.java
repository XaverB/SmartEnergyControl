package at.fh.hagenberg.swt6.hue1.smartenergycontrol.noise.generator.impl;

import at.fh.hagenberg.swt6.hue1.smartenergycontrol.noise.generator.NoiseGenerator;
import at.fh.hagenberg.swt6.hue1.smartenergycontrol.noise.generator.NoiseGeneratorProvider;

public class JNoiseGeneratorProvider implements NoiseGeneratorProvider {
    public NoiseGenerator createNoiseGenerator(double min, double max) {
        return new JNoiseGenerator(min, max);
    }
}
