package service; import java.util.*; import model.*;
public class LoanService {

    public static boolean borrowBook(Book book) {
        if (book.getStatus() != BookStatus.AVAILABLE) {
            return false;
        }

        book.setStatus(BookStatus.BORROWED);
        return true;
    }

    public static void returnBook(Book book) {
        book.setStatus(BookStatus.AVAILABLE);
    }
}
