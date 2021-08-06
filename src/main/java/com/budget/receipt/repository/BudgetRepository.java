package com.budget.receipt.repository;

import com.budget.receipt.model.budget.Budget;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository for active budget object. Serves to connect the program to the database.
 */
@Repository
public interface BudgetRepository extends JpaRepository<Budget, Long> {
    //TODO: write getters here??
}

