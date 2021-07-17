package com.budget.receipt.model.budget;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TotalBudgetTests {
    @Test
    void totalBudgetTests()
    {
        TotalBudget a = new TotalBudget();
        TotalBudget b = new TotalBudget();

        a.setCategoryTotal(2.12);
        assertNotNull(a);

        b.setCategoryTotal(56.23);
        assertNotNull(b);

    }
}