package map;

import tile.Tile;

import java.util.Random;

public abstract class Map {

    protected int rows;
    protected int cols;
    protected Random random;
    public Map(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.random = new Random();
    }
    protected abstract Tile createTile();
    public void display() {
        for (int r = 0; r < rows; r++) {
            StringBuilder line = new StringBuilder();
            for (int c = 0; c < cols; c++) {
                Tile tile = createTile();
                line.append(tile.getCharacter()).append(' ');
            }
            System.out.println(line.toString().trim());
        }
    }
}
