package pixel;

public class MoveUpCommand implements Command {
    private PixelGrid grid;

    public MoveUpCommand(PixelGrid grid) {
        this.grid = grid;
    }

    public void execute() {
        grid.moveUp();
    }
}