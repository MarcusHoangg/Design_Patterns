import logger.Logger;

public class Main5 {
    public static void main(String[] args) {
        Logger logger = Logger.getInstance();

        logger.write("Simulation started");

        logger.setFileName("new_log.txt");

        logger.write("Processing data...");
        logger.write("Simulation finished");

        logger.close();
    }
}
