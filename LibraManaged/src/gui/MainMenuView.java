package gui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainMenuView {

    public MainMenuView(Stage stage) {

        Button viewBooksBtn = new Button("View Books");
        Button searchBooksBtn = new Button("Search Books");
        Button borrowReturnBtn = new Button("Borrow / Return");
        Button viewUsersBtn = new Button("View Users");
        Button exitBtn = new Button("Exit");

        viewBooksBtn.setMaxWidth(Double.MAX_VALUE);
        searchBooksBtn.setMaxWidth(Double.MAX_VALUE);
        borrowReturnBtn.setMaxWidth(Double.MAX_VALUE);
        viewUsersBtn.setMaxWidth(Double.MAX_VALUE);
        exitBtn.setMaxWidth(Double.MAX_VALUE);

        viewBooksBtn.setOnAction(e -> new ViewBooksView(stage));
        searchBooksBtn.setOnAction(e -> new SearchBooksView(stage));
        borrowReturnBtn.setOnAction(e -> new BorrowReturnView(stage));
        viewUsersBtn.setOnAction(e -> new ViewUsersView(stage));
        exitBtn.setOnAction(e -> stage.close());

        VBox root = new VBox(10,
                viewBooksBtn,
                searchBooksBtn,
                borrowReturnBtn,
                viewUsersBtn,
                exitBtn
        );
        root.setPadding(new Insets(20));
        root.setAlignment(Pos.CENTER);

        // ===== SCENE =====
        Scene scene = new Scene(root, 600, 400);
        stage.setTitle("Library Management System");
        stage.setScene(scene);
        stage.show();
    }
}
