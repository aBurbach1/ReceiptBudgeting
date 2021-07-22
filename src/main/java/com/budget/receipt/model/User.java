package com.budget.receipt.model;

/**
 * Class representing the current user of the program.
 */
public class User {
    /**
     * A unique identifying string.
     */
    private String username;
    /**
     * A unique identifying string.
     */
    private String password;

    /**
     * Constructor method for a new user.
     * @param username - the username
     * @param password - the user's password.
     */
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    /**
     * Getter method for the username.
     * @return String of the username.
     */
    public String getUsername() {
        return username;
    }

    /**
     * Setter method for the username.
     * @param username - the new username to set the User object to.
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Getter method for the password.
     * @return String of the password.
     */
    public String getPassword() {
        return password;
    }
    /**
     * Setter method for the password.
     * @param password - the new password to set the User object to.
     */
    public void setPassword(String password) {
        this.password = password;
    }

}
