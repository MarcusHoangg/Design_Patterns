package pixel;

public class PixelGrid {
    private int[][] grid = new int[8][8];
    private int cursorX = 0;
    private int cursorY = 0;

    public int[][] getGrid() {
        return grid;
    }

    public int getCursorX() {
        return cursorX;
    }

    public int getCursorY() {
        return cursorY;
    }

    public void moveUp() {
        if (cursorY > 0) cursorY--;
    }

    public void moveDown() {
        if (cursorY < 7) cursorY++;
    }

    public void moveLeft() {
        if (cursorX > 0) cursorX--;
    }

    public void moveRight() {
        if (cursorX < 7) cursorX++;
    }

    public void togglePixel() {
        grid[cursorY][cursorX] = (grid[cursorY][cursorX] == 0) ? 1 : 0;
    }

    public void printCode() {
        System.out.println("int[][] pixelArt = {");
        for (int i = 0; i < 8; i++) {
            System.out.print(" {");
            for (int j = 0; j < 8; j++) {
                System.out.print(grid[i][j]);
                if (j < 7) System.out.print(", ");
            }
            System.out.println("},");
        }
        System.out.println("};");
    }
}