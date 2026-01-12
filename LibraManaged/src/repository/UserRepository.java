package repository;

import config.DatabaseConfig;
import util.CSVReader;

import java.util.List;

public class UserRepository {

    public static List<String> getAllUsers() {
        return CSVReader.read(DatabaseConfig.USERS_CSV);
    }
}
