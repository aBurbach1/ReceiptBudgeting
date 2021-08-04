package com.budget.receipt.controller;

import com.budget.receipt.model.expense.Expense;
import com.budget.receipt.service.ExpenseService;
import com.budget.receipt.service.OCRService;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

@ExtendWith(SpringExtension.class)
@WebMvcTest(BudgetController.class)
public class BudgetControllerTests {
    @MockBean
    ExpenseService expenseService;
    @MockBean
    OCRService ocrService;
    @Autowired
    MockMvc mockMvc;

    @Test
    void BudgetControllerTests() throws Exception
    {
        Expense a = new Expense();
        List<Expense> expenses = Arrays.asList(a);

        //TODO
    }
}
