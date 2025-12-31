package service;

public class Loan {

    private String userName;
    private String bookTitle;
    private String action; // BORROW or RETURN

    public Loan(String userName, String bookTitle, String action) {
        this.userName = userName;
        this.bookTitle = bookTitle;
        this.action = action;
    }

    public String getUserName() {
        return userName;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public String getAction() {
        return action;
    }
}