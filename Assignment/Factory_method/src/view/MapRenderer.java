package view;

import graphic.TileGraphicFactory;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import map.Map;
import tile.Tile;

public class MapRenderer {
    private static final int TILE_SIZE = 30;

    public static void render(Map map, GraphicsContext gc, int offsetX, int offsetY) {
        Tile[][] grid = map.getGrid();

        for (int row = 0; row < map.getRows(); row++) {
            for (int col = 0; col < map.getCols(); col++) {
                Tile tile = grid[row][col];

                Color color = TileGraphicFactory.getGraphic(tile.getType());

                gc.setFill(color);
                gc.fillRect(offsetX + col * TILE_SIZE, offsetY + row * TILE_SIZE, TILE_SIZE, TILE_SIZE);

                gc.setStroke(Color.BLACK);
                gc.strokeRect(offsetX + col * TILE_SIZE, offsetY + row * TILE_SIZE, TILE_SIZE, TILE_SIZE);
            }
        }
    }
}