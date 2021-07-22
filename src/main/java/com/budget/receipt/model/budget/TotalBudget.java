package com.budget.receipt.model.budget;


import com.budget.receipt.model.expense.Category;
import com.budget.receipt.model.expense.Cost;

/**
 * The total amount of a budget.
 */
public class TotalBudget {

    /**
     * The total amount of a category.
     */
    private double categoryTotal;
    /**
     * The total amount of the budget.
     */
    private double budgetTotal;
    /**
     * List of valid categories.
     */
    private String[] categories = {"Groceries", "Rent", "Mortgage", "Entertainment", "Transportation",
            "Laundry", "Utilities"};

    /**
     * Setter for the total amount of a category.
     * @param x the double value to set the categoryTotal to.
     */
    public void setCategoryTotal(double x) {
        this.categoryTotal = x;
    }

    /**
     * Sums the category totals to find the overall total budget.
     * @param categories - array of valid categories
     * @param categoryTotal - the total of the category.
     * @param budgetTotal - the overall total of the budget.
     */
    public void sumTotal(String[] categories, double categoryTotal, double budgetTotal) {
        for(int i = 0; i < categories.length; i++) {
            budgetTotal += categoryTotal;
        }
    }

    /**
     * Getter method for the total budget.
     * @return the total budget (double)
     */
    public double getBudgetTotal() {
        return budgetTotal;
    }

    /**
     * Getter method for the category budget.
     * @return the category budget (double)
     */
    public double getCategoryTotal() {
        return categoryTotal;
    }
}
