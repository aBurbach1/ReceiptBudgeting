package com.budget.receipt.model.expense;

import com.budget.receipt.model.budget.Budget;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

/**
 * A class representing an expense object.
 */
@Entity
@Table(name="expenses")
public class Expense {
    /**
     * A unique ID for the expense. Is generated upon addition to the table.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    /**
     * The dollar amount of the expense.
     */
    private BigDecimal cost;
    /**
     * The category of the expense.
     */
    private String category;
    /**
     * The budget this expense belongs to.
     */
    private String budgetName;
    /**
     * The date the transaction occured.
     */
    private Date date;

    /**
     * Getter for the budget name
     * @return the String name of the budget this expense belongs to.
     */
    public String getBudgetName() {
        return budgetName;
    }

    /**
     * Setter for the budget name
     * @param budgetName String representing the budget name.
     */
    public void setBudgetName(String budgetName) {
        this.budgetName = budgetName;
    }

    /**
     * Getter method for the date.
     * @return a Date object with the Date.
     */
    public Date getDate() {
        return date;
    }

    /**
     * Setter for the date.
     * @param date the date the expense occured.
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * Getter for the expense ID
     * @return a Long ID
     */
    public long getId() { return id; }

    /**
     * Getter for the cost
     * @return a BigDecimal of the amount
     */
    public BigDecimal getCost() {
        return cost;
    }

    /**
     * Setter for the cost.
     * @param cost the dollar amount of the expense.
     */
    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    /**
     * Getter for the category name.
     * @return String category name.
     */
    public String getCategory() {
        return category;
    }

    /**
     * Setter for the category name.
     * @param category a String category name.
     */
    public void setCategory(String category) {
        this.category = category;
    }

}
