package gui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.beans.property.SimpleStringProperty;
import model.Book;
import service.BookService;

public class ViewBooksView {

    public ViewBooksView(Stage stage) {

        ObservableList<Book> books =
                FXCollections.observableArrayList(
                        BookService.getAllBooks()
                );

        TableView<Book> table = new TableView<>();
        table.setItems(books);

        TableColumn<Book, String> titleCol =
                new TableColumn<>("Title");
        titleCol.setCellValueFactory(
                new PropertyValueFactory<>("title")
        );

        TableColumn<Book, String> authorCol =
                new TableColumn<>("Author");
        authorCol.setCellValueFactory(
                new PropertyValueFactory<>("author")
        );

        TableColumn<Book, Integer> yearCol =
                new TableColumn<>("Year");
        yearCol.setCellValueFactory(
                new PropertyValueFactory<>("year")
        );

        TableColumn<Book, String> genreCol =
                new TableColumn<>("Genre");
        genreCol.setCellValueFactory(
                new PropertyValueFactory<>("genre")
        );

        TableColumn<Book, String> statusCol =
                new TableColumn<>("Status");
        statusCol.setCellValueFactory(cell ->
                new SimpleStringProperty(
                        cell.getValue().getStatus().name()
                )
        );

        table.getColumns().addAll(
                titleCol, authorCol, yearCol, genreCol, statusCol
        );

        table.setColumnResizePolicy(
                TableView.CONSTRAINED_RESIZE_POLICY
        );

        // Sorting alphabetical ASC
        titleCol.setSortType(TableColumn.SortType.ASCENDING);
        table.getSortOrder().add(titleCol);

        BorderPane root = new BorderPane(table);
        root.setPadding(new Insets(10));
        
     // ===== BACK BUTTON =====
        Button backBtn = new Button("Back");
        backBtn.setOnAction(e -> new MainMenuView(stage));

        HBox top = new HBox(backBtn);
        top.setPadding(new Insets(10));

        root.setTop(top);

        Scene scene = new Scene(root, 600, 400);
        stage.setTitle("View Books");
        stage.setScene(scene);
        stage.show();
    }
}
