package at.fh.hagenberg.swt6.hue1.smartenergycontrol.noise.generator;

public interface NoiseGeneratorProvider {

    /**
     * Creates a noise generator.
     * @param min The lower bound of generated values.
     * @param max The upper bound of generated values.
     * @return A noise generator with the desired properties.
     */
    NoiseGenerator createNoiseGenerator(double min, double max);
}
