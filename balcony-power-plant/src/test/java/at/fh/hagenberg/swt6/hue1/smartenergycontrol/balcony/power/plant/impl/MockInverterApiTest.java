package at.fh.hagenberg.swt6.hue1.smartenergycontrol.balcony.power.plant.impl;

import at.fh.hagenberg.swt6.hue1.smartenergycontrol.balcony.power.plant.InverterApi;
import at.fh.hagenberg.swt6.hue1.smartenergycontrol.noise.generator.NoiseGenerator;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.Queue;

class MockInverterApiTest {
    @Test
    public void testGetRoomTemperatureWithLowerBoundNoiseReturnsMinimalPower() {
        Queue<Double> values =  new ArrayDeque<Double>();
        values.add(0.0);
        NoiseGenerator noiseGenerator = new NoiseGeneratorStub(0.0, 1.0, values);


        InverterApi sut = new MockInverterApi(noiseGenerator);

        double actual = sut.getActualCurrent();

        Assert.assertEquals(0.0, actual, 0.01);
    }

    @Test
    public void testGetRoomTemperatureWithUpperBoundNoiseReturnsMaximalPower() {
        Queue<Double> values =  new ArrayDeque<Double>();
        values.add(1.0);
        NoiseGenerator noiseGenerator = new NoiseGeneratorStub(0.0, 1.0, values);


        InverterApi sut = new MockInverterApi(noiseGenerator);

        double actual = sut.getActualCurrent();

        Assert.assertEquals(0.8, actual, 0.01);
    }

    @Test
    public void testGetRoomTemperatureWitMiddleValueNoiseReturnsMiddlePower() {
        Queue<Double> values =  new ArrayDeque<Double>();
        values.add((0.0 + 1.0) / 2);
        NoiseGenerator noiseGenerator = new NoiseGeneratorStub(0.0, 1.0, values);


        InverterApi sut = new MockInverterApi(noiseGenerator);

        double actual = sut.getActualCurrent();

        Assert.assertEquals((0.8 / 2), actual, 0.01);
    }
}