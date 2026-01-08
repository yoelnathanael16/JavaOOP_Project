package gui; import javafx.scene.*;import javafx.scene.control.*;import javafx.scene.layout.*;import javafx.stage.Stage;
import service.*;
public class ViewUsersView{
 Scene s; public ViewUsersView(Stage st){
 TableView<User>t=new TableView<>();
 TableColumn<User,String>c=new TableColumn<>("Name");
 c.setCellValueFactory(d->new javafx.beans.property.SimpleStringProperty(d.getValue().getName()));
 t.getColumns().add(c); t.getItems().addAll(UserService.all());
 Button back=new Button("Back"); back.setOnAction(e->st.setScene(new MainMenuView(st).getScene()));
 VBox box = new VBox(10, t, back); box.setStyle("-fx-padding:20; -fx-alignment:center;");
 s = new Scene(box, 600, 400);} public Scene getScene(){return s;}
}
