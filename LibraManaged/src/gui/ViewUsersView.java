package gui;

import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.beans.property.SimpleStringProperty;
import model.User;
import service.UserService;

public class ViewUsersView {

    public ViewUsersView(Stage stage) {

        // ===== TABLE =====
        TableView<User> table = new TableView<>();
        table.setItems(
                FXCollections.observableArrayList(
                        UserService.getAllUsers()
                )
        );

        TableColumn<User, String> idCol =
                new TableColumn<>("ID");
        idCol.setCellValueFactory(
                cell -> new SimpleStringProperty(
                        cell.getValue().getId()
                )
        );

        TableColumn<User, String> nameCol =
                new TableColumn<>("Name");
        nameCol.setCellValueFactory(
                cell -> new SimpleStringProperty(
                        cell.getValue().getName()
                )
        );

        TableColumn<User, String> roleCol =
                new TableColumn<>("Role");
        roleCol.setCellValueFactory(
                cell -> new SimpleStringProperty(
                        cell.getValue().getRole().name()
                )
        );

        table.getColumns().addAll(idCol, nameCol, roleCol);
        table.setColumnResizePolicy(
                TableView.CONSTRAINED_RESIZE_POLICY
        );

        // ===== LAYOUT =====
        BorderPane root = new BorderPane();
        root.setPadding(new Insets(10));
        root.setCenter(table);
        
     // ===== BACK BUTTON =====
        Button backBtn = new Button("Back");
        backBtn.setOnAction(e -> new MainMenuView(stage));

        HBox top = new HBox(backBtn);
        top.setPadding(new Insets(10));

        root.setTop(top);

        // ===== SCENE (WAJIB 600x400) =====
        Scene scene = new Scene(root, 600, 400);
        stage.setTitle("View Users");
        stage.setScene(scene);
        stage.show();
    }
}
