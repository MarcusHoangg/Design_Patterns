package pixel;

public class MoveLeftCommand implements Command {
    private PixelGrid grid;

    public MoveLeftCommand(PixelGrid grid) {
        this.grid = grid;
    }

    public void execute() {
        grid.moveLeft();
    }
}