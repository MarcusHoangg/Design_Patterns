package observer;

public class WindowDisplay implements WeatherObserver {
    private final String location;

    public WindowDisplay(String location) {
        this.location = location;
    }

    @Override
    public void update(double temperature) {
        System.out.println("[Window - " + location + "] now " + format(temperature));
    }

    private String format(double t) {
        return String.format("%.1f", t);
    }
}
