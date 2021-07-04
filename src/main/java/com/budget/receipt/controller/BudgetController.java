package com.budget.receipt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BudgetController {
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

    @GetMapping(value="/scan")
    public String scan() { return "scan"; }

    @GetMapping(value="/scan-complete")
    public String scanComplete() { return "scan-complete"; }

    @GetMapping(value="/new-budget")
    public String newBudget() { return "new-budget"; }
}
