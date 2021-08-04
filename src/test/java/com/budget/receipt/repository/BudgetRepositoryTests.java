package com.budget.receipt.repository;

import com.budget.receipt.model.budget.Budget;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import java.math.BigDecimal;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class BudgetRepositoryTests {
    @Autowired
    BudgetRepository budgetRepository;

    @Test
    void budgetRepoTests()
    {
        Budget a = new Budget();
        a.setName("Budget A");
        a.setIncome(new BigDecimal("744"));
        a.setAmountSpent(new BigDecimal("1"));

        budgetRepository.save(a);

        Iterable<Budget> budgets = budgetRepository.findAll();
        Assertions.assertThat(budgets).extracting(Budget::getName).containsOnly("Budget A");

        Budget b = new Budget();
        budgetRepository.save(b);

        assertNotEquals(a.getId(), b.getId());

        budgetRepository.delete(b);

        budgets = budgetRepository.findAll();
        Assertions.assertThat(budgets).extracting(Budget::getName).containsOnly("Budget A");
    }

    @Test
    void idStressTest(){
        Budget z = new Budget();
        budgetRepository.save(z);
        for (int i = 0; i < 1000; i++)
        {
            Budget a = new Budget();
            budgetRepository.save(a);
        }

        Iterable<Budget> budgets = budgetRepository.findAll();
        Assertions.assertThat(budgets).extracting(Budget::getId).containsOnlyOnce(z.getId());
    }
}