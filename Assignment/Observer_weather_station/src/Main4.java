import observer.*;

public class Main4 {
    public static void main(String[] args) throws InterruptedException {

        WeatherStation station = new WeatherStation(-10, 40);

        PhoneDisplay phone = new PhoneDisplay("Marcus");
        WindowDisplay window = new WindowDisplay("LivingRoom");
        LoggerDisplay logger = new LoggerDisplay();

        station.registerObserver(phone);
        station.registerObserver(window);
        station.registerObserver(logger);

        Thread t = new Thread(station);
        t.start();

        Thread.sleep(12000);

        System.out.println(" remove WindowDisplay");
        station.removeObserver(window);

        Thread.sleep(12000);

        System.out.println(" stop ");
        station.stop();
        t.interrupt();
    }
}
