package service;

public class LoanService {
    public void borrow(Book b, Member m) {
        if (b.getStatus() == BookStatus.AVAILABLE) {
            b.setStatus(BookStatus.BORROWED);
            m.borrowBook(b.getTitle());
        }
    }

    public void giveBack(Book b, Member m) {
        if (b.getStatus() == BookStatus.BORROWED) {
            b.setStatus(BookStatus.AVAILABLE);
            m.returnBook();
        }
    }
}