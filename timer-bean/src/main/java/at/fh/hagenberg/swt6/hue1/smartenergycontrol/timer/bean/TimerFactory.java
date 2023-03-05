package at.fh.hagenberg.swt6.hue1.smartenergycontrol.timer.bean;

import at.fh.hagenberg.swt6.hue1.smartenergycontrol.timer.bean.impl.SimpleTimer;

public class TimerFactory {
    public static Timer createTimer(int interval, int numTicks) {
        return new SimpleTimer(interval, numTicks);
    }
}
