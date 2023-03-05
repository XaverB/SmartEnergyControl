import at.fh.hagenberg.swt6.hue1.smartenergycontrol.balcony.power.plant.InverterApiProvider;
import at.fh.hagenberg.swt6.hue1.smartenergycontrol.balcony.power.plant.impl.MockInverterApiProvider;
import at.fh.hagenberg.swt6.hue1.smartenergycontrol.noise.generator.NoiseGeneratorProvider;

module balcony.power.plant {
    requires noise.generator;
    uses NoiseGeneratorProvider;

    exports at.fh.hagenberg.swt6.hue1.smartenergycontrol.balcony.power.plant;
    provides InverterApiProvider with MockInverterApiProvider;
}