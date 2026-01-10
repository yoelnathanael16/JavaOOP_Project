package repository;

import config.DatabaseConfig;
import util.CSVReader;

import java.util.List;

public class BookRepository {

    public static List<String> getAllBooks() {
        return CSVReader.read(DatabaseConfig.BOOKS_CSV);
    }
}
