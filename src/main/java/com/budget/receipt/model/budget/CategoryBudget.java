package com.budget.receipt.model.budget;

import java.util.Arrays;
import java.util.List;

/**
 * Budget data sorted by individual categories. Used to display what parts of the overall spending are
 * shown.
 */
public class CategoryBudget {

    /**
     * The name of the category the budget applies to.
     */
    private String categoryName;
    /**
     * List of valid categories.
     */
    private String[] validCategories = {"Vacation", "Renovation", "August", "College", "Monthly" };

    /**
     * Getter method for the category name
     * @return the name of the category
     */
    public String getCategoryName() {
        return categoryName;
    }

    /**
     * Setter method for the category name.
     * @param categoryName the category to set the program to.
     */
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    /**
     * Checks whether a category name is valid
     * @param name The name to check against the list of categories.
     * @return True if valid, false if not
     */
    public boolean isValid(String name) {
        List<String> list = Arrays.asList(validCategories);
        return list.contains(name);
    }

}

