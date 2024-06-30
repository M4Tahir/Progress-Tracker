package dev.mt.progresstracker.logging;

import javafx.scene.text.Font;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;
import javafx.scene.text.Text;
import org.apache.logging.log4j.LogManager;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Logger {

    private final Stage stage;
    private final TextFlow console;
    private static final String INFO_COLOR = "-fx-fill: white;";
    private static final String WARN_COLOR = "-fx-fill: yellow;";
    private static final String ERROR_COLOR = "-fx-fill: red;";
    org.apache.logging.log4j.Logger LOG;  // serialize the logs to file.

    public Logger() {
        stage = new Stage();
        LogWindow logWindow = new LogWindow();
        logWindow.start(stage);
        console = logWindow.getTextFlow();
        LOG = LogManager.getLogger();
    }

    public void info(String message) {
        log(message, INFO_COLOR, "[INFO]");
        LOG.info(message);
    }

    public void warn(String message) {
        log(message, WARN_COLOR, "[WARN]");
        LOG.warn(message);

    }

    public void error(String message) {
        log(message, ERROR_COLOR, "[ERROR]");
        LOG.error(message);
    }

    public Stage getStage() {
        return stage;
    }

    private void log(String message, String color, String logLevel) {
        Text text = new Text(logLevel + " --> " + getFormattedDateTime() + "  " + message + '\n');
        text.setFont(new Font("Jetbrains Mono", 16));
        text.setStyle(color);
        console.getChildren().add(text);
    }

    private String getFormattedDateTime() {
        LocalDateTime dateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return formatter.format(dateTime);
    }
}
