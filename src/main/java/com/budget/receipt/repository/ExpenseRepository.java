package com.budget.receipt.repository;

import com.budget.receipt.model.expense.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository for active budget object. Serves to connect the program to the database.
 */
@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Long> {
//   List<Expense> getByBudget(String Budget);
}
