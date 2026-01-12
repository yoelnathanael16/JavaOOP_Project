package repository;

import config.DatabaseConfig;
import model.Book;
import model.BookStatus;
import util.CSVReader;

import java.util.ArrayList;
import java.util.List;

public class BookRepository {

    public static List<Book> getAllBooks() {

        List<String> lines = CSVReader.read(DatabaseConfig.BOOKS_CSV);
        List<Book> books = new ArrayList<>();

        // skip header
        for (int i = 1; i < lines.size(); i++) {
            String[] data = lines.get(i).split(",");

            books.add(new Book(
                    data[0],                    // title
                    data[1],                    // author
                    Integer.parseInt(data[2]),  // year
                    data[3],                    // genre
                    BookStatus.valueOf(data[4]) // status
            ));
        }

        return books;
    }
}
