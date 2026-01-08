package gui; import javafx.scene.*;import javafx.scene.control.*;import javafx.scene.layout.*;import javafx.stage.Stage;
import service.*;
public class SearchBooksView{
 Scene s; public SearchBooksView(Stage st){
 TextField f=new TextField(); TableView<Book>t=new TableView<>();
 TableColumn<Book,String>c=new TableColumn<>("Title");
 c.setCellValueFactory(d->new javafx.beans.property.SimpleStringProperty(d.getValue().getTitle()));
 t.getColumns().add(c);
 f.textProperty().addListener((a,b,v)->t.getItems().setAll(BookService.all()));
 Button back=new Button("Back"); back.setOnAction(e->st.setScene(new MainMenuView(st).getScene()));
 VBox box = new VBox(10, f, t, back); box.setStyle("-fx-padding:20; -fx-alignment:center;");
 s = new Scene(box, 600, 400);} public Scene getScene(){return s;}
}
