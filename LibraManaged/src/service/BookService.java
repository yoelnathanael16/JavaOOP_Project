package service;

import model.*;
import repository.BookRepository;

import java.util.ArrayList;
import java.util.List;

public class BookService {

    public static List<Book> getAllBooks() {
        List<String> lines = BookRepository.getAllBooks();
        List<Book> books = new ArrayList<>();

        for (String line : lines) {
            String[] data = line.split(",");

            BookStatus status = BookStatus.valueOf(data[4].toUpperCase());

            books.add(new Book(
                data[0],
                data[1],
                Integer.parseInt(data[2]),
                data[3],
                status
            ));
        }

        return books;
    }
}
