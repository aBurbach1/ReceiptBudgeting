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
//    private ExpenseRepository expenseRepository;

//    public List<Expense> getAll() {
//        return expenseRepository.findAll();
//    }
//    public Expense getById(long id) {
//        return expenseRepository.getById(id);
//    }

    /**
     *
     * @param budgetName
     * @return total of expense costs in the
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

    public int totalExpensesByBudgetAndCategory(String budget, String category, List<Expense> allExpenses) {
        int total = 0;
        for(Expense e : allExpenses) {
            if(e.getBudgetName().equals(budget) && e.getCategory().equals(category)) {
                total += e.getCost().intValue();
            }
        }
        return total;
    }

//    public List<Expense> findByBudget(String budget){
//        List<Expense> allExpenses = this.getAll();
//        List<Expense> selectedExpenses = new ArrayList<Expense>();
//        for (Expense e: allExpenses) {
//            if(e.getBudgetName().equals(budget)) {
//                selectedExpenses.add(e);
//            }
//        }
//        return selectedExpenses;
//    }

//    public List<Expense> getByBudgetAndCategory(String budget, String category) {
//        List<Expense> allExpenses = this.getAll();
//        List<Expense> selectedExpenses = new ArrayList<Expense>();
//        for (Expense e: allExpenses) {
//            if(e.getBudgetName().equals(budget) && e.getCategory().equals(category)) {
//                selectedExpenses.add(e);
//            }
//        }
//        return selectedExpenses;
//    }
}
