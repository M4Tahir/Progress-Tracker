package dev.mt.progresstracker;

import dev.mt.progresstracker.logging.Logger;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Application extends javafx.application.Application {

    private static final int SCREEN_WIDTH = 1035;
    private static final int SCREEN_HEIGHT = 630;
    public static Logger console;

    @Override
    public void init() throws Exception {
        super.init();
//         Initialize logger on the JavaFX Application Thread
        Platform.runLater(() -> {
            console = new Logger();
            console.info("Yeah baby the program has been initialized successful.");
            console.error("Yeah baby the program has been initialized successful.");
//            console.debug("Yeah baby the program has been initialized successful.");
            console.warn("Yeah baby the program has been initialized successful.");
        });
    }

    @Override
    public void start(Stage stage) {
        try {
            FXMLLoader loader = new FXMLLoader(Application.class.getResource("fxml/StartupView.fxml"));
            Scene scene = new Scene(loader.load(), SCREEN_WIDTH, SCREEN_HEIGHT);

            stage.setMinWidth(SCREEN_WIDTH);
            stage.setMinHeight(SCREEN_HEIGHT);
            stage.setScene(scene);
            stage.setTitle("Progress Tracker");
            stage.show();


            stage.setOnCloseRequest(e -> {
                if (console != null) {
                    console.getStage().close();
                }
                Platform.exit();
            });

        } catch (IOException e) {
            console.info(e.getMessage());
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
