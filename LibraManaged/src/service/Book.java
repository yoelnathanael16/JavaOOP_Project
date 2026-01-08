package service;

import service.BookStatus;

public class Book {
    private String title, author, genre;
    private int year;
    private BookStatus status;

    public Book(String title, String author, String genre, int year, BookStatus status) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.year = year;
        this.status = status;
    }

    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public String getGenre() { return genre; }
    public int getYear() { return year; }
    public BookStatus getStatus() { return status; }
    public void setStatus(BookStatus status) { this.status = status; }
}