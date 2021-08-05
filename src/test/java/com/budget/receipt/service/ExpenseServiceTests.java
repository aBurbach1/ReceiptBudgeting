package com.budget.receipt.service;

import com.budget.receipt.model.expense.Expense;
import com.budget.receipt.repository.ExpenseRepository;
import org.apache.tomcat.util.digester.ArrayStack;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

//https://developer.okta.com/blog/2019/03/28/test-java-spring-boot-junit5
//https://www.baeldung.com/spring-boot-testing
//https://howtodoinjava.com/spring-boot2/testing/spring-boot-2-junit-5/

@ExtendWith(MockitoExtension.class)
public class ExpenseServiceTests {

    @InjectMocks
    ExpenseService expenseService;

    @Mock
    ExpenseRepository h2sam;

    @Test
    void ExpenseServiceStartupTests()
    {
        List<Expense> list = new ArrayList<Expense>();

        Expense a = new Expense();
        a.setDate(new Date(1999, 1, 1));
        a.setCategory("Grocery");
        a.setBudgetName("Budget A");
        a.setCost(new BigDecimal("19.22"));

        Expense b = new Expense();
        b.setDate(new Date(1999, 1, 3));
        b.setCategory("Grocery");
        b.setBudgetName("Budget A");
        b.setCost(new BigDecimal("8.12"));

        Expense c = new Expense();
        c.setDate(new Date(2004, 3, 1));
        a.setCategory("Rent");
        a.setBudgetName("Budget B");
        a.setCost(new BigDecimal("194.22"));

        //long x = a.getId();

        list.add(a);
        list.add(b);
        list.add(c);

        when(h2sam.findAll()).thenReturn(list);

        assertEquals(expenseService.getAll().size(), 3);
    }

    @Test
    void findByBudgetTests(){
        List<Expense> list = new ArrayList<Expense>();

        Expense a = new Expense();
        a.setDate(new Date(1999, 1, 1));
        a.setCategory("Grocery");
        a.setBudgetName("Budget A");
        a.setCost(new BigDecimal("19.22"));

        Expense b = new Expense();
        b.setDate(new Date(1999, 1, 3));
        b.setCategory("Grocery");
        b.setBudgetName("Budget A");
        b.setCost(new BigDecimal("8.12"));

        Expense c = new Expense();
        c.setDate(new Date(2004, 3, 1));
        c.setCategory("Rent");
        c.setBudgetName("Budget B");
        c.setCost(new BigDecimal("194.22"));

        Expense d = new Expense();
        d.setDate(new Date(2004, 3, 11));
        d.setCategory("Rent");
        d.setBudgetName("Budget A");
        d.setCost(new BigDecimal("194.22"));

        list.add(a);
        list.add(b);
        list.add(c);
        list.add(d);

        when(h2sam.findAll()).thenReturn(list);

        assertEquals(expenseService.getAll().size(), 4);
        assertEquals(expenseService.findByBudget("Budget A").size(), 3);
        assertEquals(expenseService.getByBudgetAndCategory("Budget A", "Grocery").size(), 2);
    }

    /**private Expense findByID(Collection<Expense> listS, long id) {
        return listS.stream().filter(expense -> id == expense.getId()).findFirst().orElse(null);
    }

    @Test
    void GetByIDTests(){
        List<Expense> list = new ArrayList<Expense>();

        Expense a = new Expense();
        long x = a.getId();
        list.add(a);

        Expense b = new Expense();
        list.add(b);


        *when(h2sam.getById(x)).thenReturn(list.get(list.indexOf(list.stream()
                .filter(f -> Objects.equals(f.getId(), x))
                .collect(Collectors.toList()))));
        when(h2sam.getById(x)).thenReturn(findByID(list, x));

        Expense z = expenseService.getById(x);

        assertEquals(a.getId(), z.getId());
        assertNotEquals(b.getId(), z.getId());
    }*/
}
