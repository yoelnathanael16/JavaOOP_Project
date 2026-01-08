package service; import java.util.*;
public class LoanService{
 static List<Loan>l=new ArrayList<>();
 public static void borrow(User u,Book b){b.setStatus(BookStatus.BORROWED);l.add(new Loan(u,b));BookService.save();}
 public static void returns(Book b){b.setStatus(BookStatus.AVAILABLE);l.removeIf(x->x.getBook()==b);BookService.save();}
}