package com.budget.receipt.model.expense;

import java.math.BigDecimal;

public class Cost {
    private BigDecimal amount;

    public Cost(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public boolean isValidAmount() {
        return (amount.scale() <= 2);
    }
}
