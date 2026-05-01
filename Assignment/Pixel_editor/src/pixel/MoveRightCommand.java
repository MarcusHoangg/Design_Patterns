package pixel;

public class MoveRightCommand implements Command {
    private PixelGrid grid;

    public MoveRightCommand(PixelGrid grid) {
        this.grid = grid;
    }

    public void execute() {
        grid.moveRight();
    }
}