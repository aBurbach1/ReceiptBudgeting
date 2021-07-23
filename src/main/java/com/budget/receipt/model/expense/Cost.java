package com.budget.receipt.model.expense;

import java.math.BigDecimal;

/**
 * cost associated with an expense
 */
public class Cost {
    private BigDecimal amount;

    /**
     * constructor
     * @param amount
     */
    public Cost(BigDecimal amount) {
        this.amount = amount;
    }

    /**
     * gets amount
     * @return amount
     */
    public BigDecimal getAmount() {
        return amount;
    }

    /**
     * sets amount
     * @param amount
     */
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    /**
     * checks if amount is a valid USD amount
     * @return boolean indicating if amount is valid
     */
    public boolean isValidAmount() {
        return (amount.scale() <= 2);
    }

    /**
     * checks if two costs are equal
     * @param otherCost
     * @return boolean
     */
    public boolean equals(Cost otherCost) {return amount.compareTo(otherCost.getAmount()) == 0;}
}
