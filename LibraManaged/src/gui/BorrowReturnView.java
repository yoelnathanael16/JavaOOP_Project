package gui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import model.Book;
import model.BookStatus;
import service.BookService;
import service.LoanService;

public class BorrowReturnView {

    private final ObservableList<Book> books =
            FXCollections.observableArrayList(BookService.getAllBooks());

    public BorrowReturnView(Stage stage) {

        // ===== TABLE =====
        TableView<Book> table = new TableView<>();
        table.setItems(books);

        TableColumn<Book, String> titleCol = new TableColumn<>("Title");
        titleCol.setCellValueFactory(new PropertyValueFactory<>("title"));

        TableColumn<Book, String> authorCol = new TableColumn<>("Author");
        authorCol.setCellValueFactory(new PropertyValueFactory<>("author"));

        TableColumn<Book, String> statusCol = new TableColumn<>("Status");
        statusCol.setCellValueFactory(cell ->
                new javafx.beans.property.SimpleStringProperty(
                        cell.getValue().getStatus().name()
                )
        );

        table.getColumns().addAll(titleCol, authorCol, statusCol);
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        // ===== BUTTONS =====
        Button borrowBtn = new Button("Borrow");
        Button returnBtn = new Button("Return");

        borrowBtn.setOnAction(e -> {
            Book selected = table.getSelectionModel().getSelectedItem();
            if (selected == null) {
                showAlert("Please select a book.");
                return;
            }

            if (!LoanService.borrowBook(selected)) {
                showAlert("Book is already borrowed.");
            }
            table.refresh();
        });

        returnBtn.setOnAction(e -> {
            Book selected = table.getSelectionModel().getSelectedItem();
            if (selected == null) {
                showAlert("Please select a book.");
                return;
            }

            if (selected.getStatus() == BookStatus.AVAILABLE) {
                showAlert("Book is already available.");
                return;
            }

            LoanService.returnBook(selected);
            table.refresh();
        });

        HBox buttons = new HBox(10, borrowBtn, returnBtn);
        buttons.setPadding(new Insets(10));

        // ===== LAYOUT =====
        BorderPane root = new BorderPane();
        root.setCenter(table);
        root.setBottom(buttons);
        
     // ===== BACK BUTTON =====
        Button backBtn = new Button("Back");
        backBtn.setOnAction(e -> new MainMenuView(stage));

        HBox top = new HBox(backBtn);
        top.setPadding(new Insets(10));

        root.setTop(top);

        // ===== SCENE =====
        Scene scene = new Scene(root, 600, 400);
        stage.setTitle("Borrow / Return Books");
        stage.setScene(scene);
        stage.show();
    }

    private void showAlert(String msg) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setHeaderText(null);
        alert.setContentText(msg);
        alert.showAndWait();
    }
}
