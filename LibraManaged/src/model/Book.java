package model;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;

public class Book {

    private final SimpleStringProperty title;
    private final SimpleStringProperty author;
    private final SimpleIntegerProperty year;
    private final SimpleStringProperty genre;
    private final ObjectProperty<BookStatus> status;

    public Book(String title,
                String author,
                int year,
                String genre,
                BookStatus status) {

        this.title = new SimpleStringProperty(title);
        this.author = new SimpleStringProperty(author);
        this.year = new SimpleIntegerProperty(year);
        this.genre = new SimpleStringProperty(genre);
        this.status = new SimpleObjectProperty<>(status);
    }

    // ===== GETTERS (UNTUK GUI & SERVICE) =====
    public String getTitle() {
        return title.get();
    }

    public String getAuthor() {
        return author.get();
    }

    public int getYear() {
        return year.get();
    }

    public String getGenre() {
        return genre.get();
    }

    public BookStatus getStatus() {
        return status.get();
    }

    // ===== SETTER (UNTUK LOAN SERVICE) =====
    public void setStatus(BookStatus status) {
        this.status.set(status);
    }

    // ===== PROPERTY (OPSIONAL, TAPI DISARANKAN) =====
    public SimpleStringProperty titleProperty() {
        return title;
    }

    public SimpleStringProperty authorProperty() {
        return author;
    }

    public SimpleIntegerProperty yearProperty() {
        return year;
    }

    public SimpleStringProperty genreProperty() {
        return genre;
    }

    public ObjectProperty<BookStatus> statusProperty() {
        return status;
    }
}
