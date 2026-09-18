package com.cybershield;

import com.cybershield.enums.Role;

public class User {

    private int id;
    private String username;
    private String password;
    private Role role;
    private boolean active;

    public User(int id, String username, String password, Role role, boolean active) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.role = role;
        this.active = active;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public Role getRole() {
        return role;
    }

    public boolean isActive() {
        return active;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "ID: " + id +
                " | Username: " + username +
                " | Role: " + role +
                " | Active: " + active;
    }
}