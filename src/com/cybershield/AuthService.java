package com.cybershield;

import com.cybershield.enums.Role;

import java.util.ArrayList;
import java.util.List;

public class AuthService {

    private final List<User> users;

    public AuthService() {
        users = new ArrayList<>();

        // Default users for testing
        users.add(new User(
                1,
                "admin",
                "admin123",
                Role.ADMIN,
                true
        ));

        users.add(new User(
                2,
                "analyst",
                "analyst123",
                Role.SECURITY_ANALYST,
                true
        ));

        users.add(new User(
                3,
                "manager",
                "manager123",
                Role.INCIDENT_MANAGER,
                true
        ));

        users.add(new User(
                4,
                "viewer",
                "viewer123",
                Role.VIEWER,
                true
        ));
    }

    public User login(String username, String password) {

        for (User user : users) {

            if (user.getUsername().equals(username)
                    && user.getPassword().equals(password)
                    && user.isActive()) {

                return user;
            }
        }

        return null;
    }

    public List<User> getUsers() {
        return users;
    }
}