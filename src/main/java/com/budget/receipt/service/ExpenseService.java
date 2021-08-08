package com.budget.receipt.service;

import com.budget.receipt.model.expense.Expense;
import com.budget.receipt.repository.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

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
     * iterates through list of expenses. For each expense, creates a key value map
     * of the cost and percentage
     * @param budgetName
     * @param income
     * @param allExpenses
     * @return total of all expenses and percentages belonging to specified budget and category
     */
    public  Map<BigDecimal, BigDecimal> totalExpenseAndPercent(String budgetName, BigDecimal income, List<Expense> allExpenses) {

        Map<BigDecimal, BigDecimal> totalExpenseAndPercent = new HashMap<>();
        BigDecimal percent = new BigDecimal(100);

        BigDecimal total = new BigDecimal(0);
        for(Expense e : allExpenses) {
            if(e.getBudgetName().equals(budgetName)) {
                total = total.add(e.getCost());
            }
        }
        for(int i = 0; i < allExpenses.size(); i++) {
            if(allExpenses.get(i).getBudgetName().equals(budgetName)) {
                BigDecimal x = (total.divide(income, RoundingMode.FLOOR).multiply(percent));
                totalExpenseAndPercent.put(total, x);
            }
        }

        return totalExpenseAndPercent;
    }


    /**
     * iterates through list of expenses. For each expense, creates a key value map
     * of the category and percentage
     * @param budgetName
     * @param income
     * @param allExpenses
     * @return the category and percentage belonging to specified budget and category
     */
    public  Map<String, BigDecimal> getAllCategories(String budgetName, BigDecimal income, List<Expense> allExpenses) {

        Map<String, BigDecimal> allCategories = new HashMap<>();
        BigDecimal percent = new BigDecimal(100);

        List<BigDecimal> subTotals = new ArrayList<>();
        List<String> catNames = new ArrayList<>();

        for (Expense e: allExpenses)
        {
            if(e.getBudgetName().equals(budgetName)) {
                if (catNames.contains(e.getCategory())){
                    BigDecimal x = subTotals.get(catNames.indexOf(e.getCategory()));
                    BigDecimal y = x.add(e.getCost());
                    subTotals.set(catNames.indexOf(e.getCategory()), y);
                }
                else{
                    catNames.add(e.getCategory());
                    subTotals.add(e.getCost());
                }
            }
        }
        if (subTotals.size() != catNames.size()) return null;
        for (int i = 0; i < subTotals.size(); i++){
            BigDecimal x = subTotals.get(i).divide(income, RoundingMode.FLOOR).multiply(percent);
            allCategories.put(catNames.get(i), x);
        }
        /**for(int i = 0; i < allExpenses.size(); i++) {
            if(allExpenses.get(i).getBudgetName().equals(budgetName)) {
                BigDecimal x = (allExpenses.get(i).getCost()).divide(income, RoundingMode.UNNECESSARY).multiply(percent);
                //allCategories.put(allExpenses.get(i).getCategory(), x);
                BigDecimal a = allCategories.putIfAbsent(allExpenses.get(i).getCategory(), x);
                if (a != null){
                    x.add(a);
                    allCategories.put(allExpenses.get(i).getCategory(), x);
                }
            }
        }*/
        return allCategories;
    }
}
