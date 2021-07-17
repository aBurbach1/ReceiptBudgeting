package com.budget.receipt.model.budget;

import java.util.Arrays;
import java.util.List;

public class CategoryBudget {

    private String categoryName;
    private String[] validCategories = {"Vacation", "Renovation", "August", "College", "Monthly" };

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public boolean isValid(String name) {
        List<String> list = Arrays.asList(validCategories);
        return list.contains(name);
    }

}

