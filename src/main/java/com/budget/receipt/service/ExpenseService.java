package com.budget.receipt.service;

import com.budget.receipt.model.expense.Expense;
import com.budget.receipt.repository.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.persistence.*;
import java.util.List;

@Repository
public class ExpenseService {
    @Autowired private ExpenseRepository expenseRepository;

//    EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpa-h2-criteria");
//    private EntityManager em = factory.createEntityManager();

    public List<Expense> getAll() {
        return expenseRepository.findAll();
    }
    public Expense getById(long id) {
        return expenseRepository.getById(id);
    }

//    public List<Expense> findByBudget(String budget){
//        TypedQuery<Expense> query = em.createQuery("select e from expenses e where e.budgetName:=budget", Expense.class);
//        query.setParameter("budget", budget);
//
//        return query.getResultList();
//    }
//    public List<Expense> getByBudget(String budget) {
//        return expenseRepository.getByBudget(budget);
//    }
//    public List<Expense> getByBudgetAndCategory() {}

}
