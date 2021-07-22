package com.budget.receipt.model;

import com.budget.receipt.model.expense.Expense;

import java.util.List;

/**
 * Overall class for the tracking of expenses.
 * Used to link expense and budget methods.
 */
public class ExpenseTracker {
    /**
     * The user of the program.
     */
    private User user;
    /**
     * List of expenses entered so far.
     */
    private List<Expense> expenses;

    /**
     * Add a new expense to the list of expenses. Appends to the end of the list.
     * @param newExpense - The expense to add.
     */
    public void addExpense(Expense newExpense) {
        this.expenses.add(newExpense);
    }
}
