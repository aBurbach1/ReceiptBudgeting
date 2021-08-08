package com.budget.receipt.service;

import com.budget.receipt.model.expense.Expense;
import com.budget.receipt.repository.ExpenseRepository;
import org.apache.tomcat.util.digester.ArrayStack;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

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
        c.setCategory("Rent");
        c.setBudgetName("Budget A");
        c.setCost(new BigDecimal("194.22"));

        Expense d = new Expense();
        d.setDate(new Date(2004, 3, 1));
        d.setCategory("Rent");
        d.setBudgetName("Budget 7");
        d.setCost(new BigDecimal("194.22"));

        //long x = a.getId();

        list.add(a);
        list.add(b);
        list.add(c);
        list.add(d);

        //when(h2sam.findAll()).thenReturn(list);

        assertEquals(expenseService.totalExpensesByBudget("Budget A", list), 221);

        //assertEquals(expenseService.totalExpensesByBudgetAndCategory("Budget A", "Grocery", list), 27);
    }

    @Test
    void percentTests()
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
        b.setCost(new BigDecimal("10.12"));

        Expense c = new Expense();
        c.setDate(new Date(2004, 3, 1));
        c.setCategory("Rent");
        c.setBudgetName("Budget A");
        c.setCost(new BigDecimal("194.22"));

        Expense d = new Expense();
        d.setDate(new Date(2004, 3, 1));
        d.setCategory("Rent");
        d.setBudgetName("Budget A");
        d.setCost(new BigDecimal("5.22"));

        //long x = a.getId();

        list.add(a);
        list.add(b);
        list.add(c);
        list.add(d);

        assertEquals(expenseService.totalExpensesByBudget("Budget A", list), 228);

        Map <BigDecimal, BigDecimal> z;
        z = expenseService.totalExpenseAndPercent("Budget A", new BigDecimal("2260"), list);

        //System.out.println(z.toString());
        assertTrue(z.containsValue(new BigDecimal("10.00")));

        Map <String, BigDecimal> k;
        k = expenseService.getAllCategories("Budget A", new BigDecimal("2260"), list);

        //System.out.println(k.toString());

        assertEquals(k.get("Rent"), new BigDecimal("8.00"));
        assertEquals(k.get("Grocery"), new BigDecimal("1.00"));

        Expense e = new Expense();
        e.setDate(new Date(2004, 1, 1));
        e.setCategory("Grocery");
        e.setBudgetName("Budget A");
        e.setCost(new BigDecimal("300.00"));

        Map <String, BigDecimal> s;

        list.add(e);
        z = expenseService.totalExpenseAndPercent("Budget A", new BigDecimal("2260"), list);
        s = expenseService.getAllCategories("Budget A", new BigDecimal("2260"), list);

        //System.out.println(s.toString());
        assertTrue(z.containsValue(new BigDecimal("23.00")));

        assertEquals(s.get("Rent"), new BigDecimal("8.00"));
        assertEquals(s.get("Grocery"), new BigDecimal("14.00"));

        Expense f = new Expense();
        f.setDate(new Date(2004, 1, 1));
        f.setCategory("Car");
        f.setBudgetName("Budget A");
        f.setCost(new BigDecimal("222.90"));

        list.add(f);
        z = expenseService.totalExpenseAndPercent("Budget A", new BigDecimal("2260"), list);
        s = expenseService.getAllCategories("Budget A", new BigDecimal("2260"), list);

        //System.out.println(z.toString());

        assertTrue(z.containsValue(new BigDecimal("33.00")));

        assertEquals(s.get("Rent"), new BigDecimal("8.00"));
        assertEquals(s.get("Grocery"), new BigDecimal("14.00"));
        assertEquals(s.get("Car"), new BigDecimal("9.00"));
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
