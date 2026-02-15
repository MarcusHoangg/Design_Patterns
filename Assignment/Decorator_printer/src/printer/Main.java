package printer;

public class Main {
    public static void main(String[] args) {

        System.out.println("=== Basic ===");
        Printer p1 = new BasicPrinter();
        p1.print("Hello World!");

        System.out.println("\n=== Decorated ===");
        Printer p2 = new EncryptedPrinter(new XMLPrinter(new BasicPrinter()));
        p2.print("Hello World!");
    }
}
