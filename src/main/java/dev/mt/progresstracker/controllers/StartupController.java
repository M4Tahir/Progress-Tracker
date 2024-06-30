package dev.mt.progresstracker.controllers;


import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;


import java.net.URL;
import java.util.ResourceBundle;

public class StartupController implements Initializable {
    public HBox startup_window_main_menu;
    public HBox startup_top_container;
    public VBox startup_window_logo;
    public ListView<StartupController> listview_courses_list;
    public BorderPane startup_window;
    public HBox button_container;
    public Button new_course_btn;
    public Button open_course_btn;
    public TextField search_box;
    public Label logo_label;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        loadLogo();
    }

    private void loadLogo() {
        ImageView logo = new ImageView("Logo/file.png");
        logo.setFitWidth(60);
        logo.setFitHeight(60);
        logo.setPreserveRatio(true);
        logo_label.setGraphic(logo);
    }
}
