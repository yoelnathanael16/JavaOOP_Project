package service;

import service.User;
import service.UserRole;

public class Admin extends User {
    public Admin(String name) {
        super(name, UserRole.ADMIN);
    }

    @Override
    public String getBorrowedBook() {
        return "-";
    }
}