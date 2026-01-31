package factory;

import ui.Button;
import ui.Checkbox;
import ui.TextField;

public abstract class UIFactory {
    public abstract Button createButton(String text);
    public abstract TextField createTextField(String text);
    public abstract Checkbox createCheckbox(String text);
}
