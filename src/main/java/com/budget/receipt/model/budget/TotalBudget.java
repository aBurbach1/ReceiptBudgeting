package com.budget.receipt.model.budget;


import com.budget.receipt.model.expense.Category;
import com.budget.receipt.model.expense.Cost;

public class TotalBudget {

    private double categoryTotal;
    private double budgetTotal;
    private String[] categories = {"Groceries", "Rent", "Mortgage", "Entertainment", "Transportation",
            "Laundry", "Utilities"};

    public void setCategoryTotal(double x) {
        this.categoryTotal = x;
    }

    public void sumTotal(String[] categories, double categoryTotal, double budgetTotal) {
        for(int i = 0; i < categories.length; i++) {
            budgetTotal += categoryTotal;
        }
    }

    public double getBudgetTotal() {
        return budgetTotal;
    }

    public double getCategoryTotal() {
        return categoryTotal;
    }
}
