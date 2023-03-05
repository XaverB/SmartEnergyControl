package at.fh.hagenberg.swt6.hue1.smartenergycontrol.noise.generator;

public interface NoiseGenerator {

    /**
     * @return the upper bound of a generated value
     */
    double getMax();

    /**
     * @return the lower bound of a generated value
     */
    double getMin();

    /**
     * Generates a pseudo random value.
     * @return A pseudo random value.
     */
    double get();
}
