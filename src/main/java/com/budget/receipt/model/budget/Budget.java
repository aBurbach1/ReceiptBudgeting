package com.budget.receipt.model.budget;

import java.util.List;

public class Budget {

    private List<Budget> budgets;

    public void addBudget(Budget newBudget) {
        this.budgets.add(newBudget);
    }
}
