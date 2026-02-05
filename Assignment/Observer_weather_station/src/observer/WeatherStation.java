package observer;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class WeatherStation implements Runnable {
    private final List<WeatherObserver> observers = new ArrayList<>();
    private final Random random = new Random();

    private final double minTemp;
    private final double maxTemp;

    private double temperature;
    private boolean running;

    public WeatherStation(double minTemp, double maxTemp) {
        this.minTemp = minTemp;
        this.maxTemp = maxTemp;

        this.temperature = minTemp + (maxTemp - minTemp) * random.nextDouble();
        this.running = false;
    }

    public synchronized void registerObserver(WeatherObserver o) {
        observers.add(o);
    }

    public synchronized void removeObserver(WeatherObserver o) {
        observers.remove(o);
    }

    private synchronized void notifyObservers() {
        for (WeatherObserver o : observers) {
            o.update(temperature);
        }
    }

    private void updateTemperature() {
        int delta = random.nextBoolean() ? 1 : -1;
        temperature += delta;

        if (temperature < minTemp) temperature = minTemp;
        if (temperature > maxTemp) temperature = maxTemp;
    }

    public void stop() {
        running = false;
    }

    @Override
    public void run() {
        running = true;

        while (running) {
            try {
                int sleepSeconds = 1 + random.nextInt(5); // 1..5
                Thread.sleep(sleepSeconds * 1000L);
            } catch (InterruptedException e) {
                break;
            }

            updateTemperature();
            notifyObservers();
        }
    }
}
