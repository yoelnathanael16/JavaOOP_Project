package service;

import service.User;
import service.UserRole;

public class Member extends User {
    private String borrowedBook = "-";

    public Member(String name) {
        super(name, UserRole.MEMBER);
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