package at.fh.hagenberg.swt6.hue1.smartenergycontrol.ac.control.impl;


import at.fh.hagenberg.swt6.hue1.smartenergycontrol.ac.control.AirConditionApi;
import at.fh.hagenberg.swt6.hue1.smartenergycontrol.ac.control.AirConditionProvider;
import at.fh.hagenberg.swt6.hue1.smartenergycontrol.noise.generator.NoiseGenerator;
import at.fh.hagenberg.swt6.hue1.smartenergycontrol.noise.generator.NoiseGeneratorProvider;

import java.util.ServiceLoader;

public class MockAirConditionProvider implements AirConditionProvider {
    @Override
    public AirConditionApi createAirConditionApi() {
        return new MockAirConditionApi(createNoiseProvider());
    }

    private NoiseGenerator createNoiseProvider() {
        var noiseProviders = ServiceLoader.load(NoiseGeneratorProvider.class);
        // we could filter the providers by some criteria here
        return noiseProviders.findFirst().orElseThrow().createNoiseGenerator(0.1, 1.0);
    }
}
