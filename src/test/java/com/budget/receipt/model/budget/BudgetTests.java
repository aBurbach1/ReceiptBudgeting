package com.budget.receipt.model.budget;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

public class BudgetTests {
    @Test
    void BudgetTests()
    {
        Budget a = new Budget();
        assertNull(a.getAmountSpent());
        assertNotNull(a);

        BigDecimal x = new BigDecimal("7.77");
        BigDecimal x2 = new BigDecimal("7.77");
        a.setAmountSpent(x);

        BigDecimal y = new BigDecimal("6000.01");
        BigDecimal y2 = new BigDecimal("6000.01");
        a.setIncome(y);

        a.setName("Test Name");

        assertEquals(a.getAmountSpent(), x2);
        assertEquals(a.getIncome(), y2);
        assertEquals(a.getName(), "Test Name");

    }
}
