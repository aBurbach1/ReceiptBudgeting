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
    private ExpenseService expenseService = new ExpenseService();

    @Autowired
    public BudgetController(ExpenseRepository expenseRepository, BudgetRepository budgetRepository) {
        this.expenseRepository = expenseRepository;
        this.budgetRepository = budgetRepository;
    }

    @GetMapping(value="/home")
    public String home(Model model) {
        model.addAttribute("budgets", budgetRepository.findAll());
        return "home";
    }

    @GetMapping(value="/budget/{id}")
    public String budgetDisplay(@PathVariable("id") long id, Model model) {
        Budget budget = budgetRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid Id:" + id));
        model.addAttribute("budgets", budget);
//        model.addAttribute("expenses", );
        model.addAttribute("totalExpenses", expenseService.totalExpensesByBudget(budget.getName(), expenseRepository.findAll()));
        return "budget-01";
    }

//    @GetMapping(value="/new-expense")
//    public String newExpense() { return "new-expense"; }


    @GetMapping("/manual-expense/{id}")
    public String manualExpense(@PathVariable("id") long id,Model model) {
        model.addAttribute("expense", new Expense());
        Budget budget = budgetRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid Id:" + id));
        model.addAttribute("budgets", budget);
        System.out.println("OPE");
        return "manual-expense";
    }

    @PostMapping("/manual-expense")
    public String manualExpenseSumbit(@RequestParam("id") Long id, @ModelAttribute Expense expense, Model model) {
        Budget budget = budgetRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid Id:" + id));
        model.addAttribute("budgets", budget);
        expense.setBudgetName(budget.getName());
        model.addAttribute("expense", expense);
        expenseRepository.save(expense);
        System.out.println("MADE IT TO SUBMIT");
        System.out.println("budget" + budget);
        return "redirect:/home";
    }

    @GetMapping(value = "/scan/{id}")
    public String scan(@PathVariable("id") long id, Model model) {
        Budget budget = budgetRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid Id:" + id));
        model.addAttribute("budgets", budget);
        return "scan";
    }

    @GetMapping(value="/scan-complete/{id}")
    public String scanComplete(@PathVariable("id") long id, Model model) {
        Budget budget = budgetRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid Id:" + id));
        model.addAttribute("budgets", budget);
        Expense expense = ocrService.runOCR("src/main/resources/receipt-images/walmart-receipt.jpg", budget.getName());
        System.out.println("Expense id: " + expense.getId());
        System.out.println("Expense Category: " + expense.getCategory());
        System.out.println("Expense cost: " + expense.getCost());
        model.addAttribute("expense", expense);
//        expenseRepository.save(expense);
//        List<Expense> expenseList = expenseService.findByBudget("August 2021 Budget");
//        for(Expense e : expenseList) {
//            System.out.println(e.getBudgetName());
//            System.out.println(e.getCost());
//        }
        return "scan-complete/{id}"; }

    @PostMapping(value="/scan-complete/{id}")
    public String submitExpense(@ModelAttribute Expense expense, Model model) {
        model.addAttribute("expense", expense);
        System.out.println("post mapping");
        expenseRepository.save(expense);
        return "redirect:/home";
    }

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

