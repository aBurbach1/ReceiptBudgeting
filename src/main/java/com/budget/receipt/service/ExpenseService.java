package com.budget.receipt.service;

import com.budget.receipt.model.expense.Expense;
import com.budget.receipt.repository.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ExpenseService {
    /**
     * iterates through list of expenses. For each expense, adds the associated
     * cost if it belongs to the specified budget
     * @param budgetName, allExpenses
     * @return total of expense costs in the budget
     */
    public int totalExpensesByBudget(String budgetName, List<Expense> allExpenses) {
        int total = 0;
        for(Expense e : allExpenses) {
            if(e.getBudgetName().equals(budgetName)) {
                total += e.getCost().intValue();
            }
        }
        return total;
    }

    /**
    * iterates through list of expenses. For each expense, adds the associated
     * cost if it belongs to the specified budget
     * @param budget
     * @param category
     * @param allExpenses
     * @return total of all expenses belonging to specified budget and category
     */
    public int totalExpensesByBudgetAndCategory(String budget, String category, List<Expense> allExpenses) {
        int total = 0;
        for(Expense e : allExpenses) {
            if(e.getBudgetName().equals(budget) && e.getCategory().equals(category)) {
                total += e.getCost().intValue();
            }
        }
        return total;
    }

//    public String[] getAllCategories(String budgetName, List<Expense> allExpenses) {
//        String[] allCategories = new String[50];
//        for(Expense e : allExpenses) {
//            if(e.getBudgetName().equals(budgetName)) {
//                allCategories
//            }
//        }
//
//    }
}
