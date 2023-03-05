package at.fh.hagenberg.swt6.hue1.smartenergycontrol.timer.bean;

public interface TimerProvider {
    Timer createTimer(int interval, int numTicks);
    double getResolution();
}
