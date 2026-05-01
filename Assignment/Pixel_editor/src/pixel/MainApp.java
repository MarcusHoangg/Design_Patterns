package pixel;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.VBox;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.paint.Color;

public class MainApp extends Application {

    private PixelGrid grid = new PixelGrid();
    private Canvas canvas = new Canvas(320, 320);

    private void draw() {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        int size = 40;

        for (int y = 0; y < 8; y++) {
            for (int x = 0; x < 8; x++) {

                if (grid.getGrid()[y][x] == 1) {
                    gc.setFill(Color.BLACK);
                } else {
                    gc.setFill(Color.WHITE);
                }

                gc.fillRect(x * size, y * size, size, size);

                gc.setStroke(Color.GRAY);
                gc.strokeRect(x * size, y * size, size, size);
            }
        }

        // draw cursor
        gc.setStroke(Color.RED);
        gc.setLineWidth(3);
        gc.strokeRect(
                grid.getCursorX() * size,
                grid.getCursorY() * size,
                size,
                size
        );
    }

    @Override
    public void start(Stage stage) {

        draw();

        Button generateBtn = new Button("Generate Code");

        generateBtn.setOnAction(e -> {
            new GenerateCodeCommand(grid).execute();
            canvas.requestFocus(); // giữ focus sau khi click
        });

        VBox root = new VBox(canvas, generateBtn);
        Scene scene = new Scene(root, 320, 360);

        // QUAN TRỌNG: để canvas nhận keyboard
        canvas.setFocusTraversable(true);

        canvas.setOnKeyPressed(e -> {

            Command cmd = null;

            if (e.getCode() == KeyCode.UP)
                cmd = new MoveUpCommand(grid);
            else if (e.getCode() == KeyCode.DOWN)
                cmd = new MoveDownCommand(grid);
            else if (e.getCode() == KeyCode.LEFT)
                cmd = new MoveLeftCommand(grid);
            else if (e.getCode() == KeyCode.RIGHT)
                cmd = new MoveRightCommand(grid);
            else if (e.getCode() == KeyCode.SPACE)
                cmd = new TogglePixelCommand(grid);

            if (cmd != null) {
                cmd.execute();
                draw();
            }
        });

        stage.setTitle("Pixel Art Editor");
        stage.setScene(scene);
        stage.show();

        canvas.requestFocus();
    }

    public static void main(String[] args) {
        launch();
    }
}