package at.fh.hagenberg.swt6.hue1.smartenergycontrol.boiler.impl;

import at.fh.hagenberg.swt6.hue1.smartenergycontrol.boiler.ElectricBoilerApi;
import at.fh.hagenberg.swt6.hue1.smartenergycontrol.boiler.ElectricBoilerApiProvider;
import at.fh.hagenberg.swt6.hue1.smartenergycontrol.noise.generator.NoiseGenerator;
import at.fh.hagenberg.swt6.hue1.smartenergycontrol.noise.generator.NoiseGeneratorProvider;

import java.util.ServiceLoader;

public class MockElectricBoilerApiProvider implements ElectricBoilerApiProvider {
    @Override
    public ElectricBoilerApi createElectricBoiler() {
        return new MockElectricBoilerApi(createNoiseProvider());
    }

    private NoiseGenerator createNoiseProvider() {
        var noiseProviders = ServiceLoader.load(NoiseGeneratorProvider.class);
        // we could filter the providers by some criteria here
        return noiseProviders.findFirst().orElseThrow().createNoiseGenerator(0.0, 1.0);
    }
}
