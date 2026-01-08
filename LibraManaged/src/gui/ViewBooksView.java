package gui;

import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.collections.*;

import javafx.beans.property.SimpleStringProperty;
import service.*;

public class ViewBooksView {

    private Scene scene;

    public ViewBooksView(Stage stage) {

        TableView<Book> table = new TableView<>();

        // === Columns ===
        TableColumn<Book, String> titleCol = new TableColumn<>("Title");
        titleCol.setCellValueFactory(d ->
            new SimpleStringProperty(d.getValue().getTitle())
        );

        TableColumn<Book, String> authorCol = new TableColumn<>("Author");
        authorCol.setCellValueFactory(d ->
            new SimpleStringProperty(d.getValue().getAuthor())
        );

        TableColumn<Book, String> yearCol = new TableColumn<>("Year");
        yearCol.setCellValueFactory(d ->
            new SimpleStringProperty(String.valueOf(d.getValue().getYear()))
        );

        TableColumn<Book, String> genreCol = new TableColumn<>("Genre");
        genreCol.setCellValueFactory(d ->
            new SimpleStringProperty(d.getValue().getGenre())
        );

        TableColumn<Book, String> statusCol = new TableColumn<>("Status");
        statusCol.setCellValueFactory(d ->
            new SimpleStringProperty(d.getValue().getStatus().name())
        );

        table.getColumns().addAll(
            titleCol, authorCol, yearCol, genreCol, statusCol
        );

        ObservableList<Book> books =
            FXCollections.observableArrayList(BookService.all());

        books.sort((a, b) ->
            a.getTitle().compareToIgnoreCase(b.getTitle())
        );

        table.setItems(books);

        // === Back button ===
        Button back = new Button("Back");
        back.setOnAction(e ->
            stage.setScene(new MainMenuView(stage).getScene())
        );

        VBox box = new VBox(15, table, back);
        box.setStyle("-fx-padding:20; -fx-alignment:center;");

        scene = new Scene(box, 600, 400);
    }

    public Scene getScene() {
        return scene;
    }
}
