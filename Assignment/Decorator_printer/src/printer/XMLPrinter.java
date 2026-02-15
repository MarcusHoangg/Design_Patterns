package printer;

public class XMLPrinter extends PrinterDecorator {

    public XMLPrinter(Printer printer) {
        super(printer);
    }

    @Override
    public void print(String message) {
        String xml = "<message>" + message + "</message>";
        printer.print(xml);
    }
}
