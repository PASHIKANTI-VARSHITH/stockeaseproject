package com.mini.stockeaseproject.Service;

import com.mini.stockeaseproject.Model.User;
import com.mini.stockeaseproject.Model.expenses;
import com.mini.stockeaseproject.Repository.ExpenseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpenseService {

    private final ExpenseRepository exprep;

    public ExpenseService(ExpenseRepository expenseRepo) {
        this.exprep = expenseRepo;
    }
    public List<expenses> fetchExpenses(User user) {
        return exprep.findByUser(user);
    }
    public void createExpense(expenses expense) {
        exprep.save(expense);
    }
//    public void removeExpense(Long id) {
//        exprep.deleteById(id);
//    }
}
