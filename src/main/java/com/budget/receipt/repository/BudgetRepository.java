package com.budget.receipt.repository;

import com.budget.receipt.model.budget.Budget;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BudgetRepository extends JpaRepository<Budget, Long> {
    //TODO: write getters here??
}

