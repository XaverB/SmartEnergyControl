import at.fh.hagenberg.swt6.hue1.smartenergycontrol.timer.bean.TimerProvider;
import at.fh.hagenberg.swt6.hue1.smartenergycontrol.timer.bean.impl.SimpleTimerProvider;

module timer.bean {
    exports at.fh.hagenberg.swt6.hue1.smartenergycontrol.timer.bean;
    provides TimerProvider with SimpleTimerProvider;
}