package at.fh.hagenberg.swt6.hue1.smartenergycontrol.noise.generator.impl;

import de.articdive.jnoise.generators.noise_parameters.fade_functions.FadeFunction;
import de.articdive.jnoise.generators.noise_parameters.interpolation.Interpolation;
import de.articdive.jnoise.pipeline.JNoise;

/**
 * Generates pseudo random values with JNoise
 * See https://github.com/Articdive/JNoise/tree/4.0.0#usage
 */
public class JNoiseGenerator extends NoiseGeneratorBase {


    // https://github.com/Articdive/JNoise/wiki/Basic-Examples#perlin-noise
    private final JNoise noiseGenerator;

    public JNoiseGenerator(double min, double max) {
        super(min, max);
        noiseGenerator = JNoise.newBuilder().
                perlin(1337, Interpolation.CUBIC, FadeFunction.IMPROVED_PERLIN_NOISE)
                .clamp(min, max)
                .build();
    }

    @Override
    public double get() {
        double noiseValue = noiseGenerator.evaluateNoise(Math.random());
        return scale(noiseValue);
    }

    double scale(double value) {
        return (max - min) * value + min;
    }
}
