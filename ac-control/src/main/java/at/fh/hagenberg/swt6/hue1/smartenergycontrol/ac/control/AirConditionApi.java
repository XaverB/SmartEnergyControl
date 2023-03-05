package at.fh.hagenberg.swt6.hue1.smartenergycontrol.ac.control;

public interface AirConditionApi {
    // switches AC ON or OFF
    void turnOn();

    void turnOff();

    // current room temperature in Celsius (19 and 30)
    double getRoomTemperature();

}
