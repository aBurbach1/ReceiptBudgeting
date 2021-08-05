package com.budget.receipt.model.expense;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.awt.datatransfer.SystemFlavorMap;
import java.math.BigDecimal;
import java.util.Date;

public class ExpenseTests {
    @Test
    void ExpenseTests()
    {
        Expense a = new Expense();
        a.setBudgetName("Marvin's Budget");
        a.setCategory("Rent");
        Date z = new Date(2003, 1, 4);
        a.setDate(z);
        BigDecimal x = new BigDecimal("23.35");
        a.setCost(x);

        Date z2 = new Date(2003, 1, 4);
        BigDecimal x2 = new BigDecimal("23.35");

        assertEquals(a.getCategory(), "Rent");
        assertEquals(a.getBudgetName(), "Marvin's Budget");
        assertEquals(a.getDate(),z2);
        assertEquals(a.getCost(),x2);

        Expense b = new Expense();

        //assertNotNull(a.getId());
        //assertNotEquals(a.getId(), b.getId());
    }
}
