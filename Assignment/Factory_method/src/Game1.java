import graphic.TileGraphicFactory;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.stage.Stage;
import map.CityMap;
import map.WildernessMap;
import view.MapRenderer;

public class Game1 extends Application {

    @Override
    public void start(Stage stage) {
        int rows = 10;
        int cols = 10;

        Canvas canvas = new Canvas(700, 380);
        GraphicsContext gc = canvas.getGraphicsContext2D();

        CityMap cityMap = new CityMap(rows, cols);
        WildernessMap wildernessMap = new WildernessMap(rows, cols);

        MapRenderer.render(cityMap, gc, 40, 40);
        MapRenderer.render(wildernessMap, gc, 380, 40);

        System.out.println("Total shared tile graphics created: "
                + TileGraphicFactory.getCreatedGraphicCount());

        Group root = new Group(canvas);
        Scene scene = new Scene(root);

        stage.setTitle("Factory Method + Flyweight RPG Map");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}