package gui; import javafx.scene.*;import javafx.scene.control.*;import javafx.scene.layout.*;import javafx.stage.Stage;
import service.*;
public class BorrowReturnView{
 Scene s; public BorrowReturnView(Stage st){
 ComboBox<String>m=new ComboBox<>(); m.getItems().addAll("Borrow","Return");
 ListView<Book>l=new ListView<>();
 m.setOnAction(e->{ if("Borrow".equals(m.getValue())) l.getItems().setAll(BookService.byStatus(BookStatus.AVAILABLE));
 else l.getItems().setAll(BookService.byStatus(BookStatus.BORROWED));});
 l.setOnMouseClicked(e->{Book b=l.getSelectionModel().getSelectedItem();
 if(b!=null){ if("Borrow".equals(m.getValue())) LoanService.borrow(UserService.all().get(0),b);
 else LoanService.returns(b); m.fireEvent(new javafx.event.ActionEvent());}});
 Button back=new Button("Back"); back.setOnAction(e->st.setScene(new MainMenuView(st).getScene()));
 VBox box = new VBox(10, m, l, back); box.setStyle("-fx-padding:20; -fx-alignment:center;");
 s = new Scene(box, 600, 400);} public Scene getScene(){return s;}
}