package logger;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Logger {
    // single instance
    private static Logger instance;
    private PrintWriter writer;
    private String fileName;
    // private constructor
    private Logger() {
        this.fileName = "app.log";
        openFile(fileName);
    }
    // global access point
    public static Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }
    // write a log message
    public void write(String message) {
        if (writer != null) {
            writer.println(message);
            writer.flush();
        }
    }
    // change log file at runtime
    public void setFileName(String newFileName) {
        close();
        this.fileName = newFileName;
        openFile(newFileName);
    }
    private void openFile(String name) {
        try {
            writer = new PrintWriter(new FileWriter(name, true));
        } catch (IOException e) {
            System.out.println("Cannot open log file: " + name);
        }
    }
    public void close() {
        if (writer != null) {
            writer.close();
            writer = null;
        }
    }
}
