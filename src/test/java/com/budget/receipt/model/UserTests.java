package com.budget.receipt.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UserTests {

    @Test
    void userTests()
    {
        User a = new User("Adam", "password");
        User b = new User("123", "123");

        assertTrue(a.getUsername().equals("Adam"));
        assertTrue(b.getUsername().equals("123"));
        assertTrue(b.getUsername().equals(b.getPassword()));
        assertTrue(a.getPassword().equals("password"));

        b.setUsername("Betty");
        b.setPassword("temp");

        assertTrue(b.getUsername().equals("Betty"));
        assertTrue(b.getPassword().equals("temp"));

    }
}