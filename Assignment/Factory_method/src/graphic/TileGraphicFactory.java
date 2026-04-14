package graphic;

import java.util.HashMap;
import javafx.scene.paint.Color;

public class TileGraphicFactory {
    private static final HashMap<String, Color> sharedGraphics = new HashMap<>();

    public static Color getGraphic(String tileType) {
        if (!sharedGraphics.containsKey(tileType)) {
            System.out.println("Creating shared graphic for: " + tileType);

            switch (tileType) {
                case "road":
                    sharedGraphics.put(tileType, Color.LIGHTGRAY);
                    break;
                case "forest":
                    sharedGraphics.put(tileType, Color.FORESTGREEN);
                    break;
                case "building":
                    sharedGraphics.put(tileType, Color.DARKSLATEGRAY);
                    break;
                case "swamp":
                    sharedGraphics.put(tileType, Color.OLIVEDRAB);
                    break;
                case "water":
                    sharedGraphics.put(tileType, Color.DODGERBLUE);
                    break;
                default:
                    sharedGraphics.put(tileType, Color.BLACK);
                    break;
            }
        }

        return sharedGraphics.get(tileType);
    }

    public static int getCreatedGraphicCount() {
        return sharedGraphics.size();
    }
}