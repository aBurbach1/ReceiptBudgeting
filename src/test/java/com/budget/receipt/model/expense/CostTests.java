package com.budget.receipt.model.expense;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.math.BigDecimal;

public class CostTests {
    @Test
    void costTests()
    {
        BigDecimal x = new BigDecimal("23.45");
        BigDecimal y = new BigDecimal("2.11");
        BigDecimal z = new BigDecimal("7");

        Cost a = new Cost(x);
        Cost b = new Cost(y);
        Cost c = new Cost(new BigDecimal("0"));

        assertTrue(a.getAmount().equals(x));
        assertTrue(b.getAmount().equals(new BigDecimal("2.11")));

        c.setAmount(z);
        assertTrue(c.getAmount().equals(new BigDecimal("7")));

        assertTrue(c.isValidAmount());
        c.setAmount(new BigDecimal("7.8"));
        assertTrue(c.isValidAmount());
        c.setAmount(new BigDecimal("7.88"));
        assertTrue(c.isValidAmount());
        c.setAmount(new BigDecimal("7.888"));
        assertFalse(c.isValidAmount());

        //assertNotEquals(a, b);
        assertFalse(a.equals(b));
        b.setAmount(x);
        //assertEquals(a, b);
        assertTrue(a.equals(b));


    }
}
