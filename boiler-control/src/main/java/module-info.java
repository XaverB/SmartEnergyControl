import at.fh.hagenberg.swt6.hue1.smartenergycontrol.boiler.ElectricBoilerApiProvider;
import at.fh.hagenberg.swt6.hue1.smartenergycontrol.boiler.impl.MockElectricBoilerApiProvider;
import at.fh.hagenberg.swt6.hue1.smartenergycontrol.noise.generator.NoiseGeneratorProvider;

module boiler.control {
    requires noise.generator;
    uses NoiseGeneratorProvider;

    exports at.fh.hagenberg.swt6.hue1.smartenergycontrol.boiler;
    provides ElectricBoilerApiProvider with MockElectricBoilerApiProvider;
}