package com.budget.receipt.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BudgetController {
    @GetMapping(value="/home")
    public String home() {
        return "home";
    }
}
