package com.budget.receipt.model.budget;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

/**
 * This class refers to the basic budget list for the class. Category and Total Budgets extend this calass.
 */
@Entity
@Table(name="budgets")
public class Budget {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private BigDecimal income;
    private BigDecimal amountSpent;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getIncome() {
        return income;
    }

    public void setIncome(BigDecimal income) {
        this.income = income;
    }

    public BigDecimal getAmountSpent() {
        return amountSpent;
    }

    public void setAmountSpent(BigDecimal amountSpent) {
        this.amountSpent = amountSpent;
    }
}
