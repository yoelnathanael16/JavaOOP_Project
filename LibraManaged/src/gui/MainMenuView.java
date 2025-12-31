package gui;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainMenuView {
    private Scene scene;

    public MainMenuView(Stage stage) {
        Button b1 = new Button("View Books");
        Button b2 = new Button("View Members & Admin");
        Button b3 = new Button("Search For Books");
        Button b4 = new Button("Borrow / Return");

        VBox box = new VBox(15, b1, b2, b3, b4);
        box.setStyle("-fx-padding:20; -fx-alignment:center;");
        scene = new Scene(box, 400, 300);
    }

    public Scene getScene() {
        return scene;
    }
}