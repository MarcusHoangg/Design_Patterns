package map;

import java.util.Random;
import tile.BuildingTile;
import tile.ForestTile;
import tile.RoadTile;
import tile.Tile;

public class CityMap extends Map {
    private final Random random = new Random();

    public CityMap(int rows, int cols) {
        super(rows, cols);
        generateMap();
    }

    @Override
    protected Tile createTile() {
        int x = random.nextInt(3);

        if (x == 0) return new RoadTile();
        if (x == 1) return new ForestTile();
        return new BuildingTile();
    }
}