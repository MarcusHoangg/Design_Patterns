package map;

import tile.ForestTile;
import tile.SwampTile;
import tile.Tile;
import tile.WaterTile;

public class WildernessMap extends Map {

    public WildernessMap(int rows, int cols) {
        super(rows, cols);
    }

    @Override
    protected Tile createTile() {
        int pick = random.nextInt(3);
        if (pick == 0) return new SwampTile();
        if (pick == 1) return new WaterTile();
        return new ForestTile();
    }
}
