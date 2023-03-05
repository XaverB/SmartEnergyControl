package at.fh.hagenberg.swt6.hue1.smartenergycontrol.balcony.power.plant.impl;

import at.fh.hagenberg.swt6.hue1.smartenergycontrol.balcony.power.plant.InverterApi;
import at.fh.hagenberg.swt6.hue1.smartenergycontrol.balcony.power.plant.InverterApiProvider;
import at.fh.hagenberg.swt6.hue1.smartenergycontrol.noise.generator.NoiseGenerator;
import at.fh.hagenberg.swt6.hue1.smartenergycontrol.noise.generator.NoiseGeneratorProvider;

import java.util.ServiceLoader;

public class MockInverterApiProvider implements InverterApiProvider {

    @Override
    public InverterApi createInverterApi() {
        return new MockInverterApi(createNoiseProvider());
    }

    private NoiseGenerator createNoiseProvider() {
        var noiseProviders = ServiceLoader.load(NoiseGeneratorProvider.class);
        // we could filter the providers by some criteria here
        return noiseProviders.findFirst().orElseThrow().createNoiseGenerator(0.0, 1.0);
    }
}
