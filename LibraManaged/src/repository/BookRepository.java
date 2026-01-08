package repository;

import config.DatabaseConfig;
import util.CSVReader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BookRepository {

    public static List<String> getAllBooks() {
        return CSVReader.read(DatabaseConfig.BOOKS_CSV);
    }
}
