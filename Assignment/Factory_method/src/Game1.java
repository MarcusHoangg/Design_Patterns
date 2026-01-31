import map.CityMap;
import map.Map;
import map.WildernessMap;

public class Game1 {

    public static void main(String[] args) {
        int rows = 8;
        int cols = 12;

        Map map = createMap("city", rows, cols);
        map.display();
    }

    public static Map createMap(String type, int rows, int cols) {
        if ("city".equalsIgnoreCase(type)) {
            return new CityMap(rows, cols);
        }
        if ("wilderness".equalsIgnoreCase(type)) {
            return new WildernessMap(rows, cols);
        }
        throw new IllegalArgumentException("Unknown map type: " + type);
    }
}
