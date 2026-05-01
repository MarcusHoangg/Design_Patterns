package pixel;

public class MoveDownCommand implements Command {
    private PixelGrid grid;

    public MoveDownCommand(PixelGrid grid) {
        this.grid = grid;
    }

    public void execute() {
        grid.moveDown();
    }
}