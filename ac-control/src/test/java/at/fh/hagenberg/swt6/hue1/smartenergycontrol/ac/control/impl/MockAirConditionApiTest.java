package at.fh.hagenberg.swt6.hue1.smartenergycontrol.ac.control.impl;

import at.fh.hagenberg.swt6.hue1.smartenergycontrol.ac.control.AirConditionApi;
import at.fh.hagenberg.swt6.hue1.smartenergycontrol.noise.generator.NoiseGenerator;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.Queue;

class MockAirConditionApiTest {

    @Test
    public void testGetRoomTemperatureWithLowerBoundNoiseReturnsMinimalTemperature() {
        Queue<Double> values =  new ArrayDeque<Double>();
        values.add(0.1);
        NoiseGenerator noiseGenerator = new NoiseGeneratorStub(0.1, 1.0, values);


        AirConditionApi sut = new MockAirConditionApi(noiseGenerator);

        double actual = sut.getRoomTemperature();

        Assert.assertEquals(19.0, actual, 0.01);
    }

    @Test
    public void testGetRoomTemperatureWithUpperBoundNoiseReturnsMaximalTemperature() {
        Queue<Double> values =  new ArrayDeque<Double>();
        values.add(1.0);
        NoiseGenerator noiseGenerator = new NoiseGeneratorStub(0.1, 1.0, values);


        AirConditionApi sut = new MockAirConditionApi(noiseGenerator);

        double actual = sut.getRoomTemperature();

        Assert.assertEquals(30.0, actual, 0.01);
    }

    @Test
    public void testGetRoomTemperatureWithMedianNoiseReturnsMidTemperature() {
        Queue<Double> values =  new ArrayDeque<Double>();
        values.add((0.1 + 1.0)/2);
        NoiseGenerator noiseGenerator = new NoiseGeneratorStub(0.1, 1.0, values);


        AirConditionApi sut = new MockAirConditionApi(noiseGenerator);

        double actual = sut.getRoomTemperature();

        Assert.assertEquals((30.0 + 19.0)/2, actual, 0.01);
    }
}