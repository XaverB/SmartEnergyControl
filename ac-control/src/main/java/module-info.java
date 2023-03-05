import at.fh.hagenberg.swt6.hue1.smartenergycontrol.ac.control.AirConditionProvider;
import at.fh.hagenberg.swt6.hue1.smartenergycontrol.ac.control.impl.MockAirConditionProvider;
import at.fh.hagenberg.swt6.hue1.smartenergycontrol.noise.generator.NoiseGeneratorProvider;

module ac.control {
    requires noise.generator;
    uses NoiseGeneratorProvider;

    exports at.fh.hagenberg.swt6.hue1.smartenergycontrol.ac.control;
    provides AirConditionProvider with MockAirConditionProvider;
}