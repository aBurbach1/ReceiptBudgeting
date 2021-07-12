package com.budget.receipt.model.expense;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.math.BigDecimal;

public class ExpenseTests {
    @Test
    void expenseTests()
    {
        Expense a = new Expense();
        assertNull(a.getCategory());
        assertNull(a.getCost());

        Category x = new Category();
        x.setCategoryName("Groceries");
        a.setCategory(x);
        Category x2 = new Category();
        x2.setCategoryName("Groceries");
        assertEquals(a.getCategory().getCategoryName(), x2.getCategoryName());

        Cost y = new Cost(new BigDecimal("2.31"));
        a.setCost(y);
        Cost y2 = new Cost(new BigDecimal("2.31"));
        Cost yN = new Cost(new BigDecimal("2.11"));
        assertEquals(a.getCost().getAmount(), y2.getAmount());
        assertNotEquals(a.getCost().getAmount(), yN.getAmount());

        Expense a2 = new Expense();
        Expense b = new Expense();
        Expense c = new Expense();

        a2.setCategory(x);
        b.setCategory(x);
        x.setCategoryName("Laundry");
        c.setCategory(x);

        a2.setCost(y);
        c.setCost(y);
        y.setAmount(new BigDecimal("23.3"));
        b.setCost(y);

        //Should pass; failing
        assertEquals(a, a2);
        assertNotEquals(a, b);
        assertNotEquals(a, c);



    }
}
