package model;

import model.User;
import model.UserRole;

public class Admin extends User {
	public Admin(String id, String name) {
        super(id, name, UserRole.ADMIN);
    }

    @Override
    public String getBorrowedBook() {
        return "-";
    }
}