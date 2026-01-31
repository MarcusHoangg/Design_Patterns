import factory.AFactory;
import factory.BFactory;
import factory.UIFactory;
import ui.Button;
import ui.Checkbox;
import ui.TextField;

public class Game2 {

    public static void main(String[] args) {
        UIFactory factory = chooseFactory("A");

        Button button = factory.createButton("Play");
        TextField textField = factory.createTextField("Username");
        Checkbox checkbox = factory.createCheckbox("Remember me");

        button.display();
        textField.display();
        checkbox.display();

        button.setText("Start");
        textField.setText("Marcus");
        checkbox.setText("Auto-login");

        button.display();
        textField.display();
        checkbox.display();
    }

    private static UIFactory chooseFactory(String style) {
        if ("A".equalsIgnoreCase(style)) return new AFactory();
        if ("B".equalsIgnoreCase(style)) return new BFactory();
        throw new IllegalArgumentException("Unknown style: " + style);
    }
}
