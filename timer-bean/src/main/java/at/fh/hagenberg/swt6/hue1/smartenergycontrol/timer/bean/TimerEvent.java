package at.fh.hagenberg.swt6.hue1.smartenergycontrol.timer.bean;

import java.util.EventObject;

public class TimerEvent extends EventObject {

    private final int numTicks;
    private final int tickCount;

    /**
     * Constructs a timer Event.
     *
     * @param timer the object on which the Event initially occurred
     * @param tickCount count of ticks
     * @param numTicks number of ticks
     * @throws IllegalArgumentException if source is null
     */
    public TimerEvent(Timer timer, int tickCount, int numTicks) {
        super(timer);
        this.tickCount = tickCount;
        this.numTicks = numTicks;
    }

    public int getTickCount() {
        return tickCount;
    }

    public int getNumTicks() {
        return numTicks;
    }

    @Override
    public Timer getSource()
    {
        return (Timer) source;
    }
}
