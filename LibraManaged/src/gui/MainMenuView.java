package gui; import javafx.scene.*;import javafx.scene.control.*;import javafx.scene.layout.*;import javafx.stage.Stage;
public class MainMenuView{
 Scene s; public MainMenuView(Stage st){
 Button a=new Button("View Books"),b=new Button("View Members & Admin"),
 c=new Button("Search For Books"),d=new Button("Borrow / Return");
 a.setOnAction(e->st.setScene(new ViewBooksView(st).getScene()));
 b.setOnAction(e->st.setScene(new ViewUsersView(st).getScene()));
 c.setOnAction(e->st.setScene(new SearchBooksView(st).getScene()));
 d.setOnAction(e->st.setScene(new BorrowReturnView(st).getScene()));
 VBox box = new VBox(25, a, b, c, d); box.setStyle("-fx-padding:20; -fx-alignment:center;");
 s = new Scene(box, 600, 400);}
 public Scene getScene(){return s;}
}
