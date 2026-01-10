package gui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import model.Book;
import service.BookService;

public class SearchBooksView {

    public SearchBooksView(Stage stage) {

        // ===== DATA =====
        ObservableList<Book> masterData =
                FXCollections.observableArrayList(BookService.getAllBooks());

        FilteredList<Book> filteredData =
                new FilteredList<>(masterData, b -> true);

        // ===== SEARCH FIELD =====
        TextField searchField = new TextField();
        searchField.setPromptText("Search by title, author, or genre");

        searchField.textProperty().addListener((obs, oldVal, newVal) -> {
            filteredData.setPredicate(book -> {
                if (newVal == null || newVal.isBlank()) return true;
                String q = newVal.toLowerCase();

                return book.getTitle().toLowerCase().contains(q)
                        || book.getAuthor().toLowerCase().contains(q)
                        || book.getGenre().toLowerCase().contains(q);
            });
        });

        // ===== TABLE =====
        TableView<Book> table = new TableView<>();
        table.setItems(filteredData);

        TableColumn<Book, String> titleCol = new TableColumn<>("Title");
        titleCol.setCellValueFactory(new PropertyValueFactory<>("title"));

        TableColumn<Book, String> authorCol = new TableColumn<>("Author");
        authorCol.setCellValueFactory(new PropertyValueFactory<>("author"));

        TableColumn<Book, Integer> yearCol = new TableColumn<>("Year");
        yearCol.setCellValueFactory(new PropertyValueFactory<>("year"));

        TableColumn<Book, String> genreCol = new TableColumn<>("Genre");
        genreCol.setCellValueFactory(new PropertyValueFactory<>("genre"));

        table.getColumns().addAll(titleCol, authorCol, yearCol, genreCol);
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        // ===== LAYOUT =====
        Button backBtn = new Button("Back");
        backBtn.setOnAction(e -> new MainMenuView(stage));
        
        HBox top = new HBox(10, searchField, backBtn);
        top.setPadding(new Insets(10));

        BorderPane root = new BorderPane();
        root.setTop(top);
        root.setCenter(table);

        // ===== SCENE =====
        Scene scene = new Scene(root, 600, 400);
        stage.setTitle("Search Books");
        stage.setScene(scene);
        stage.show();
    }
}
