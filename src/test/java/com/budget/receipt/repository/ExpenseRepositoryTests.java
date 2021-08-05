package com.budget.receipt.repository;

import com.budget.receipt.model.expense.Expense;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.math.BigDecimal;
import java.util.Date;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ExpenseRepositoryTests {
    @Autowired
    ExpenseRepository expenseRepository;

    @Test
    void expenseRepoTests()
    {
        Expense a = new Expense();
        a.setBudgetName("Budget A");
        a.setCost(new BigDecimal("5.43"));
        a.setCategory("Grocery");
        a.setDate(new Date(1922, 2, 4));

        expenseRepository.save(a);

        Iterable<Expense> expenses = expenseRepository.findAll();
        Assertions.assertThat(expenses).extracting(Expense::getCost).containsOnly(new BigDecimal("5.43"));

        Expense b = new Expense();
        expenseRepository.save(b);

        assertNotEquals(a.getId(), b.getId());

        expenseRepository.delete(b);

        expenses = expenseRepository.findAll();
        Assertions.assertThat(expenses).extracting(Expense::getCost).containsOnly(new BigDecimal("5.43"));

    }

    @Test
    void idStressTest(){
        Expense z = new Expense();
        expenseRepository.save(z);
        for (int i = 0; i < 1000; i++)
        {
            Expense a = new Expense();
            expenseRepository.save(a);
        }

        Iterable<Expense> expenses = expenseRepository.findAll();
        Assertions.assertThat(expenses).extracting(Expense::getId).containsOnlyOnce(z.getId());
    }
}
