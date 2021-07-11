package com.budget.receipt.model.expense;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class DateTests {
    @Test
    void dateTests()
    {
        Date a = new Date (1, 1, 1991);
        Date b = new Date (30, 4, 2022);
        Date c = new Date (31, 4, 2022);
        Date d = new Date (2, 2, 1922);

        assertEquals(a.toString(), "January 1, 1991");
        assertEquals(b.toString(), "April 30, 2022");

        assertTrue(a.isValidDate());
        assertTrue(b.isValidDate());
        assertFalse(c.isValidDate());
        assertFalse(d.isValidDate());

        //Should this method be private?
        assertTrue(d.isValidDay());

    }
}
