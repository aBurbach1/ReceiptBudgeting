package com.budget.receipt.service;

import com.budget.receipt.model.expense.Expense;
import com.budget.receipt.repository.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpenseService {
    @Autowired private ExpenseRepository expenseRepository;

    public List<Expense> getAll() {
        return expenseRepository.findAll();
    }
    public Expense getById(long id) {
        return expenseRepository.getById(id);
    }
//    public List<Expense> getByBudget(String budget) {
//        return expenseRepository.getByBudget(budget);
//    }
//    public List<Expense> getByBudgetAndCategory() {}

}
