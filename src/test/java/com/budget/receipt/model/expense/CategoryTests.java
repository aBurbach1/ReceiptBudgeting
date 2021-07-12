package com.budget.receipt.model.expense;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CategoryTests {
    @Test
    void categoryTests()
    {
        Category a = new Category();
        assertNull(a.getCategoryName());

        a.setCategoryName("Groceries");
        assertTrue(a.getCategoryName().equals("Groceries"));

        assertTrue(a.isValid("Rent"));
        assertTrue(a.isValid("Groceries"));
        assertTrue(a.isValid("Mortgage"));
        assertTrue(a.isValid("Entertainment"));
        assertTrue(a.isValid("Transportation"));
        assertTrue(a.isValid("Laundry"));
        assertTrue(a.isValid("Utilities"));

        assertFalse(a.isValid("Food"));
        assertFalse(a.isValid("Cosplay"));
        assertFalse(a.isValid("Three"));
    }
}
