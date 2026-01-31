package ui;

public abstract class UIElement {
    private String text;

    protected UIElement(String text) {
        this.text = text;
    }

    public void setText(String newText) {
        this.text = newText;
    }

    protected String getText() {
        return text;
    }

    public abstract void display();
}
