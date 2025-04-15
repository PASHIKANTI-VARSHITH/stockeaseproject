package com.mini.stockeaseproject.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customerId;

    private String customerName;
    private String customerMobileNumber;
    private Double customerTotalSales;
    private Double moneyInPending;

    @ManyToOne
    @JoinColumn(name="userid", referencedColumnName = "userid")
    private User user;

    // Constructors
    public Customer() {
    }

    public Customer(String customerName, String customerMobileNumber, User user) {
        this.customerName = customerName;
        this.customerMobileNumber = customerMobileNumber;
        this.customerTotalSales = 0.0;
        this.moneyInPending = 0.0;
        this.user = user;
    }

    // Getters and Setters
    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerMobileNumber() {
        return customerMobileNumber;
    }

    public void setCustomerMobileNumber(String customerMobileNumber) {
        this.customerMobileNumber = customerMobileNumber;
    }

    public Double getCustomerTotalSales() {
        return customerTotalSales;
    }

    public void setCustomerTotalSales(Double customerTotalSales) {
        this.customerTotalSales = customerTotalSales;
    }

    public Double getMoneyInPending() {
        return moneyInPending;
    }

    public void setMoneyInPending(Double moneyInPending) {
        this.moneyInPending = moneyInPending;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}