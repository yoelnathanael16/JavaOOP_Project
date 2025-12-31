package service;

import service.UserRole;

public abstract class User {
    protected String name;
    protected UserRole role;

    public User(String name, UserRole role) {
        this.name = name;
        this.role = role;
    }

    public String getName() { return name; }
    public UserRole getRole() { return role; }

    public abstract String getBorrowedBook();
}