package service;

import model.Book;
import repository.BookRepository;

import java.util.List;

public class BookService {

    public static List<Book> getAllBooks() {
        return BookRepository.getAllBooks();
    }
}

