package at.fh.hagenberg.swt6.hue1.smartenergycontrol.timer.bean.impl;

import at.fh.hagenberg.swt6.hue1.smartenergycontrol.timer.bean.Timer;
import at.fh.hagenberg.swt6.hue1.smartenergycontrol.timer.bean.TimerProvider;

public class SimpleTimerProvider implements TimerProvider {
    @Override
    public Timer createTimer(int interval, int numTicks) {
        return new SimpleTimer(interval, numTicks);
    }

    @Override
    public double getResolution() {
        return 1 / 1000;
    }
}
