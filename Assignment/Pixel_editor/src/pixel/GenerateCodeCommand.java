package pixel;

public class GenerateCodeCommand implements Command {
    private PixelGrid grid;

    public GenerateCodeCommand(PixelGrid grid) {
        this.grid = grid;
    }

    public void execute() {
        grid.printCode();
    }
}