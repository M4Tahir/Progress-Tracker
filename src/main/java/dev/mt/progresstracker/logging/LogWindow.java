package dev.mt.progresstracker.logging;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;

public class LogWindow extends Application {

    private TextFlow textFlow;

    @Override
    public void start(Stage stage) {
        textFlow = new TextFlow();
        textFlow.setMaxHeight(Double.MAX_VALUE);
        textFlow.setMaxWidth(Double.MAX_VALUE);
        textFlow.setPrefHeight(600.0);
        textFlow.setPrefWidth(1100.0);
        textFlow.setPadding(new Insets(0, 0, 0, 10));
        textFlow.getChildren().add(new Text("Debug Console 1.0\n"));
        textFlow.setStyle(
                "-fx-background-color: rgb(0, 0, 0); " +
                        "-fx-control-inner-background: #000000; " +
                        "-fx-text-fill: white;"
        );

        Scene scene = new Scene(textFlow);
        stage.setTitle("Log Window");
        stage.setScene(scene);
        stage.show();
//        stage.setOnCloseRequest(Event::consume);
    }

    public TextFlow getTextFlow() {
        return textFlow;
    }
}
