package service;

import model.User;
import model.UserRole;
import repository.UserRepository;

import java.util.ArrayList;
import java.util.List;

public class UserService {

    public static List<User> getAllUsers() {
        List<String> lines = UserRepository.getAllUsers();
        List<User> users = new ArrayList<>();

        for (String line : lines) {
            String[] d = line.split(",");

            UserRole role = UserRole.valueOf(d[2].toUpperCase());

            users.add(new User(
                    d[0],
                    d[1],
                    role
            ));
        }
        return users;
    }
}
