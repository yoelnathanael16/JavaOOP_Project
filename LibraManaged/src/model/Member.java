package model;

import model.User;
import model.UserRole;

public class Member extends User {
    private String borrowedBook = "-";

    public Member(String id, String name) {
        super(id, name, UserRole.MEMBER);
    }

    public void borrowBook(String title) {
        borrowedBook = title;
    }

    public void returnBook() {
        borrowedBook = "-";
    }

    @Override
    public String getBorrowedBook() {
        return borrowedBook;
    }
}