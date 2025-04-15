package com.mini.stockeaseproject.Model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity

public class expenses {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long expenseId;

    private String expensesname;

    @ManyToOne
    @JoinColumn(name="userid", referencedColumnName = "userid")
    private User user;

    private Double expenseamount;

    private LocalDate createdAt;

//    @PrePersist
//    protected void onCreate() {
//        createdAt = LocalDateTime.now();  // Auto-set timestamp before saving
//    }

    public Long getExpenseId() {
        return expenseId;
    }

    public void setExpenseId(Long expenseId) {
        this.expenseId = expenseId;
    }

    public String getExpensesname() {
        return expensesname;
    }

    public void setExpensesname(String expensesname) {
        this.expensesname = expensesname;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Double getExpenseamount() {
        return expenseamount;
    }

    public void setExpenseamount(Double expenseamount) {
        this.expenseamount = expenseamount;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    public expenses() {
    }

    public expenses(String expensesname, User user, Double expenseamount, LocalDate createdAt) {
        this.expensesname = expensesname;
        this.user = user;
        this.expenseamount = expenseamount;
        this.createdAt = createdAt;
    }
}
