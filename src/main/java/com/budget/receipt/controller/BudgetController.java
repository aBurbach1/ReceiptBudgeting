package com.budget.receipt.controller;

import com.budget.receipt.model.budget.Budget;
import com.budget.receipt.model.expense.Expense;
import com.budget.receipt.repository.BudgetRepository;
import com.budget.receipt.repository.ExpenseRepository;
import com.budget.receipt.service.ExpenseService;
import com.budget.receipt.service.OCRService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class BudgetController {
    private final ExpenseRepository expenseRepository;
    private final BudgetRepository budgetRepository;

    private OCRService ocrService = new OCRService();
    private ExpenseService expenseService;

    @Autowired
    public BudgetController(ExpenseRepository expenseRepository, BudgetRepository budgetRepository) {
        this.expenseRepository = expenseRepository;
        this.budgetRepository = budgetRepository;
        this.expenseService = new ExpenseService(expenseRepository);
    }

    @GetMapping(value="/home")
    public String home() {
        return "home";
    }

    @GetMapping(value="/budget-01")
    public String budgetDisplay() { return "budget-01"; }

//    @GetMapping(value="/new-expense")
//    public String newExpense() { return "new-expense"; }

    @GetMapping(value="/manual-expense")
    public String manualExpense() { return "manual-expense"; }

    @GetMapping(value = "/scan")
    public String scan() { return "scan";}

    @GetMapping(value="/scan-complete")
    public String scanComplete(Model model) {
        Expense expense = ocrService.runOCR("src/main/resources/receipt-images/walmart-receipt.jpg");
        System.out.println("Expense id: " + expense.getId());
        System.out.println("Expense Category: " + expense.getCategory());
        System.out.println("Expense cost: " + expense.getCost());
        model.addAttribute("expense", expense);
        expenseRepository.save(expense);
//        List<Expense> expenseList = expenseService.findByBudget("August 2021 Budget");
//        for(Expense e : expenseList) {
//            System.out.println(e.getBudgetName());
//            System.out.println(e.getCost());
//        }
        return "scan-complete"; }

//    @PostMapping(value="/scan-complete")
//    public String scan() {
//        Expense expense = ocrService.runOCR("src/main/resources/receipt-images/walmart-receipt.jpg");
//        expenseRepository.save(expense);
//        return "/validate-expense/"+expense.getId();
//    }

//    @GetMapping(value="/validate-expense/{id}")
//    public String validate(@PathVariable("id") long id) {
//        Expense expense = expenseRepository.getById(id);
//        return "/validate-expense/"+id;
//    }


//    @GetMapping(value="/scan-complete")
//    public String scanComplete(@ModelAttribute("expense") Expense expense) {
//        return "scan-complete"; }

    @GetMapping("/new-budget")
    public String newBudget(Model model) {
        model.addAttribute("budget", new Budget());
        return "new-budget";
    }

    @PostMapping("/new-budget")
    public String newBudgetSumbit(@ModelAttribute Budget budget, Model model) {
        model.addAttribute("budget", budget);
        budgetRepository.save(budget);
        return "redirect:/home";
    }
}

