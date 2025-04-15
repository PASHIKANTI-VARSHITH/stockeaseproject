package com.mini.stockeaseproject.Model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "bills")
public class Bill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long billId;

    private LocalDateTime billDate;
    private Double totalAmount;
    private Double amountPaid;
    private Double amountPending;

    @ManyToOne
    @JoinColumn(name="userid", referencedColumnName = "userid")
    private User user;

    @ManyToOne
    @JoinColumn(name="customerId", referencedColumnName = "customerId")
    private Customer customer;

    @OneToMany(mappedBy = "bill", cascade = CascadeType.ALL)
    private List<BillItem> billItems = new ArrayList<>();

    // Constructors
    public Bill() {
        this.billDate = LocalDateTime.now();
    }

    public Bill(User user, Customer customer) {
        this.user = user;
        this.customer = customer;
        this.billDate = LocalDateTime.now();
        this.totalAmount = 0.0;
        this.amountPaid = 0.0;
        this.amountPending = 0.0;
    }

    // Getters and Setters
    public Long getBillId() {
        return billId;
    }

    public void setBillId(Long billId) {
        this.billId = billId;
    }

    public LocalDateTime getBillDate() {
        return billDate;
    }

    public void setBillDate(LocalDateTime billDate) {
        this.billDate = billDate;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Double getAmountPaid() {
        return amountPaid;
    }

    public void setAmountPaid(Double amountPaid) {
        this.amountPaid = amountPaid;
    }

    public Double getAmountPending() {
        return amountPending;
    }

    public void setAmountPending(Double amountPending) {
        this.amountPending = amountPending;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<BillItem> getBillItems() {
        return billItems;
    }

    public void setBillItems(List<BillItem> billItems) {
        this.billItems = billItems;
    }

    public void addBillItem(BillItem billItem) {
        billItems.add(billItem);
        billItem.setBill(this);
        this.totalAmount += billItem.getTotal();
    }
}