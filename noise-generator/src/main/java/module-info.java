import at.fh.hagenberg.swt6.hue1.smartenergycontrol.noise.generator.NoiseGeneratorProvider;

module noise.generator {
    requires jnoise.generators;
    requires jnoise.pipeline;
    requires jnoise.core;

    exports at.fh.hagenberg.swt6.hue1.smartenergycontrol.noise.generator;

    provides NoiseGeneratorProvider with
            at.fh.hagenberg.swt6.hue1.smartenergycontrol.noise.generator.impl.JNoiseGeneratorProvider,
            at.fh.hagenberg.swt6.hue1.smartenergycontrol.noise.generator.impl.SimpleNoiseGeneratorProvider;
}