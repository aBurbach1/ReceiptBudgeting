package com.budget.receipt.model.budget;

import com.budget.receipt.model.expense.Category;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CategoryBudgetTests {
    @Test
    void catBudgetTests()
    {
        Category a = new Category();
        assertNull(a.getCategoryName());

        a.setCategoryName("Vacation");
        assertTrue(a.getCategoryName().equals("Vacation"));

//        assertTrue(a.isValid("Vacation"));
//        assertTrue(a.isValid("Renovation"));
//        assertTrue(a.isValid("August"));
//        assertTrue(a.isValid("College"));
//        assertTrue(a.isValid("Monthly"));
//
//        assertFalse(a.isValid("Poptart"));
//        assertFalse(a.isValid("Orange"));
//        assertFalse(a.isValid("Town"));
    }
}