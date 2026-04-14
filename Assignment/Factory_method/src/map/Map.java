package map;

import tile.Tile;

public abstract class Map {
    protected Tile[][] grid;
    protected int rows;
    protected int cols;

    public Map(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.grid = new Tile[rows][cols];
    }

    protected void generateMap() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                grid[i][j] = createTile();
            }
        }
    }

    protected abstract Tile createTile();

    public Tile[][] getGrid() {
        return grid;
    }

    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }
}