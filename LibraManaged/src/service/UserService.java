package service;

import java.util.*;

public class UserService {
    private List<User> users;

    public UserService(List<User> users) {
        this.users = users;
    }

    public List<User> getSortedUsers() {
        users.sort(Comparator.comparing(User::getName));
        return users;
    }
}