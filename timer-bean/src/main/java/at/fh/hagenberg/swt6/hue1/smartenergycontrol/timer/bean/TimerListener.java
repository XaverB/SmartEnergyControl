package at.fh.hagenberg.swt6.hue1.smartenergycontrol.timer.bean;

@FunctionalInterface
public interface TimerListener {
    public void expired(TimerEvent event);
}
