package printer;

public class EncryptedPrinter extends PrinterDecorator {

    public EncryptedPrinter(Printer printer) {
        super(printer);
    }

    private String encrypt(String message) {
        StringBuilder sb = new StringBuilder();
        for (char c : message.toCharArray()) {
            sb.append((char) (c + 1)); // simple Caesar shift +1
        }
        return sb.toString();
    }

    @Override
    public void print(String message) {
        String encrypted = encrypt(message);
        printer.print(encrypted);
    }
}
