package at.fh.hagenberg.swt6.hue1.smartenergycontrol.timer.bean;

public interface Timer {
    void start();

    void stop();

    boolean isRunning();

    int getInterval();

    int getNumTicks();

    void addTimerListener(TimerListener listener);

    void removeTimerListener(TimerListener listener);
}
