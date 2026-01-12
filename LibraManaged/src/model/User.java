package model;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;

public class User {

    private final SimpleStringProperty id;
    private final SimpleStringProperty name;
    private final ObjectProperty<UserRole> role; // ENUM

    public User(String id, String name, UserRole role) {
        this.id = new SimpleStringProperty(id);
        this.name = new SimpleStringProperty(name);
        this.role = new SimpleObjectProperty<>(role);
    }

    // ===== GETTERS =====
    public String getId() {
        return id.get();
    }

    public String getName() {
        return name.get();
    }

    public UserRole getRole() {
        return role.get();
    }

    // ===== SETTER (OPSIONAL) =====
    public void setRole(UserRole role) {
        this.role.set(role);
    }

    // ===== PROPERTIES (UNTUK TABLEVIEW) =====
    public SimpleStringProperty idProperty() {
        return id;
    }

    public SimpleStringProperty nameProperty() {
        return name;
    }

    public ObjectProperty<UserRole> roleProperty() {
        return role;
    }
    
    protected String borrowedBook = "-";
    
    public String getBorrowedBook() {
        return borrowedBook;
    }
}
