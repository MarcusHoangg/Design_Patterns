package observer;

public class LoggerDisplay implements WeatherObserver {

    @Override
    public void update(double temperature) {
        System.out.println("[Logger] received " + String.format("%.1f", temperature));
    }
}
