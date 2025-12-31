package main;

import javafx.application.Application;
import javafx.stage.Stage;
import gui.MainMenuView;

public class MainApp extends Application {
    @Override
    public void start(Stage stage) {
        MainMenuView menu = new MainMenuView(stage);
        stage.setTitle("Library Management System");
        stage.setScene(menu.getScene());
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}