package com.mini.stockeaseproject.Controller;
import org.springframework.ui.Model;

import com.mini.stockeaseproject.Model.User;
import com.mini.stockeaseproject.Model.expenses;
import com.mini.stockeaseproject.Service.ExpenseService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Controller
public class ExpenseController {
    private final ExpenseService expser;

    public ExpenseController(ExpenseService expser) {
        this.expser = expser;
    }

    @GetMapping("/expenses")
    public String showExpenses(HttpSession session, Model model) {
        User user = (User) session.getAttribute("user");

        if (user == null) {
            return "redirect:/login";
        }

        List<expenses> userExpenses = expser.fetchExpenses(user);
        model.addAttribute("expenses", userExpenses);
        return "expenses"; // Renders expense.html
    }



    @PostMapping("/addExpense")
    public String addExpense(@RequestParam String expensesname,
                             @RequestParam double expenseamount,
                             @RequestParam String date,
                             HttpSession session) {

        User user = (User) session.getAttribute("user");

        if (user == null) {
            return "redirect:/login";
        }

        LocalDate createdAt = LocalDate.parse(date); // Convert date to LocalDate because, Expense model only takes Local date format, (from html , it comes in form of string)
        expenses expense = new expenses(expensesname, user, expenseamount, createdAt);
        expser.createExpense(expense);

        return "redirect:/landing";

    }
}
