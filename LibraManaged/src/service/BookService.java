package service;

import java.util.*;
import java.util.stream.Collectors;

public class BookService {
    private List<Book> books;

    public BookService(List<Book> books) {
        this.books = books;
    }

    public List<Book> getAllSorted() {
        return books.stream()
                .sorted(Comparator.comparing(Book::getTitle))
                .collect(Collectors.toList());
    }

    public List<Book> search(String key) {
        return books.stream()
                .filter(b -> b.getTitle().toLowerCase().contains(key.toLowerCase())
                        || b.getAuthor().toLowerCase().contains(key.toLowerCase())
                        || b.getGenre().toLowerCase().contains(key.toLowerCase())
                        || String.valueOf(b.getYear()).equals(key)
                        || b.getStatus().name().equalsIgnoreCase(key))
                .sorted(Comparator.comparing(Book::getTitle))
                .collect(Collectors.toList());
    }

    public List<Book> available() {
        return books.stream().filter(b -> b.getStatus() == BookStatus.AVAILABLE).toList();
    }

    public List<Book> borrowed() {
        return books.stream().filter(b -> b.getStatus() == BookStatus.BORROWED).toList();
    }
}