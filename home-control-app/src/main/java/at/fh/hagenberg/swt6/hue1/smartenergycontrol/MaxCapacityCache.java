package at.fh.hagenberg.swt6.hue1.smartenergycontrol;

public class MaxCapacityCache {

    private final int capacity;
    private int count = 0;
    private final double[] cache;

    public MaxCapacityCache(int capacity) {
        this.capacity = capacity;
        cache = new double[capacity];
    }

    public void add(double value) {
        cache[count % 10] = value;
        // count will overflow after a long runtime
        // we could handle this case here
        count++;
    }

    public double getAverage() {
        double sum = 0.0;
        for (int i = 0; i < Math.min(count, 10); i++) {
            sum += cache[i];
        }
        double average = sum / Math.min(count, capacity);
        return average;
    }
}
