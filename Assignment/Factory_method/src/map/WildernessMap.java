package map;

import java.util.Random;
import tile.ForestTile;
import tile.SwampTile;
import tile.Tile;
import tile.WaterTile;

public class WildernessMap extends Map {
    private final Random random = new Random();

    public WildernessMap(int rows, int cols) {
        super(rows, cols);
        generateMap();
    }

    @Override
    protected Tile createTile() {
        int x = random.nextInt(3);

        if (x == 0) return new SwampTile();
        if (x == 1) return new WaterTile();
        return new ForestTile();
    }
}