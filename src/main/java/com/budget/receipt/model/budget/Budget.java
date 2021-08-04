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
    /**
     * A unique ID used for the budget on the database level.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    /**
     * The max amount of the budget.
     */
    private BigDecimal income;
    /**
     * The total amount of the budget spent so far.
     */
    private BigDecimal amountSpent;

    /**
     * Getter for name of budget.
     * @return Name of the budget (string)
     */
    public String getName() {
        return name;
    }

    /**
     * Setter for name of budget
     * @param name String name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter for income
     * @return max amount of budget.
     */
    public BigDecimal getIncome() {
        return income;
    }

    /**
     * Sets the income of the budget.
     * @param income BigDecimal of max amount of budget.
     */
    public void setIncome(BigDecimal income) {
        this.income = income;
    }

    /**
     * Returns the amount spent.
     * @return BigDecimal of the amount spent.
     */
    public BigDecimal getAmountSpent() {
        return amountSpent;
    }

    /**
     * Sets the amount spent on a budget.
     * @param amountSpent BigDecimal reperesenting amount spent.
     */
    public void setAmountSpent(BigDecimal amountSpent) {
        this.amountSpent = amountSpent;
    }

    /**
     * Returns the ID. Used only for testing.
     * @return long ID
     */
    public long getId() {return id;}
}
