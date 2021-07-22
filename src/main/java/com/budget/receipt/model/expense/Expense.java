package com.budget.receipt.model.expense;

public class Expense {
    private Cost cost;
    private Category category;

    public Cost getCost() {
        return cost;
    }

    public void setCost(Cost cost) {
        this.cost = cost;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public boolean equals(Expense otherExpense) {
        if(this.category.getCategoryName().equals(otherExpense.category.getCategoryName()) && this.cost.equals(otherExpense.cost)) {
            return true;
        }
        else return false;
    }
}
