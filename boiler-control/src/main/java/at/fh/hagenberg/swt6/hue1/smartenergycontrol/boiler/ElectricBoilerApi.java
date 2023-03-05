package at.fh.hagenberg.swt6.hue1.smartenergycontrol.boiler;

public interface ElectricBoilerApi {
    // switches boiler on
    public void turnOn();
    // current boiler temperature in degrees Celsius (0.0 to +100.0)
    public double getBoilerTemperature();
}
