package com.budget.receipt.model;

import com.budget.receipt.model.expense.Expense;

import java.util.List;

public class ExpenseTracker {
    private User user;
    private List<Expense> expenses;

    public void addExpense(Expense newExpense) {
        this.expenses.add(newExpense);
    }
}
