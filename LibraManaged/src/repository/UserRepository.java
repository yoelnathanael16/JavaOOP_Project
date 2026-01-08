package repository;

import config.DatabaseConfig;
import util.CSVReader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UserRepository {

    public static List<String> getAllUsers() {
        return CSVReader.read(DatabaseConfig.USERS_CSV);
    }
}
