package pixel;

public class TogglePixelCommand implements Command {
    private PixelGrid grid;

    public TogglePixelCommand(PixelGrid grid) {
        this.grid = grid;
    }

    public void execute() {
        grid.togglePixel();
    }
}