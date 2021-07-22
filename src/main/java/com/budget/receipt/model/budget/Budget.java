package com.budget.receipt.model.budget;

import java.util.List;

/**
 * This class refers to the basic budget list for the class. Category and Total Budgets extend this calass.
 */
public class Budget {

    /**
     * The list of budget objects that the model will operate on.
     */
    private List<Budget> budgets;

    /**
     * Add a new budget to the program's database.
     * @param newBudget - New budget to be added.
     */
    public void addBudget(Budget newBudget) {
        this.budgets.add(newBudget);
    }
}
