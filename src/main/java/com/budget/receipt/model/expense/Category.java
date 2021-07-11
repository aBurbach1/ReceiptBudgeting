package com.budget.receipt.model.expense;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Category {
    private String categoryName;
    private String[] validCategories = {"Groceries", "Rent", "Mortgage", "Entertainment", "Transportation",
            "Laundry", "Utilities"};

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
