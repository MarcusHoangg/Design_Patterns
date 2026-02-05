package observer;

public class PhoneDisplay implements WeatherObserver {
    private final String owner;

    public PhoneDisplay(String owner) {
        this.owner = owner;
    }

    @Override
    public void update(double temperature) {
        System.out.println("[Phone - " + owner + "] temp = " + format(temperature));
    }

    private String format(double t) {
        return String.format("%.1f", t);
    }
}
