package com.budget.receipt.model.expense;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * A budget category
 */
public class Category {
    private String categoryName;
    private String[] validCategories = {"Groceries", "Rent", "Mortgage", "Entertainment", "Transportation",
            "Laundry", "Utilities"};

    /**
     * gets name of category
     * @return name of category
     */
    public String getCategoryName() {
        return categoryName;
    }

    /**
     * sets name of Category
     * @param categoryName
     */
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    /**
     * checks if category name is in list of valid categories
     * @param name
     * @return boolean indicating if category is valid
     */
    public boolean isValid(String name) {
        List<String> list = Arrays.asList(validCategories);
        return list.contains(name);
    }
}
