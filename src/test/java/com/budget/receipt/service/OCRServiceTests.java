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

public class OCRServiceTests {
    @InjectMocks
    OCRService ocrService = new OCRService();

//    @Test
//    void OCRServiceTests()
//    {
//        String filePath = "src/main/resources/receipt-images/testImg.jpeg";
//
////        Expense a = ocrService.runOCR(filePath);
//
//        assertNotNull(a);
//
//        //TODO: REQUEST ASSISTANCE
//    }
}
