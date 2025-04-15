package com.mini.stockeaseproject.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "bill_items")
public class BillItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long billItemId;

    @ManyToOne
    @JoinColumn(name = "billId")
    private Bill bill;

    @ManyToOne
    @JoinColumn(name = "stockId")
    private stock stock;

    private Double salePrice;
    private Double quantity;
    private Double total;

    // Constructors
    public BillItem() {
    }

    public BillItem(stock stock, Double salePrice, Double quantity) {
        this.stock = stock;
        this.salePrice = salePrice;
        this.quantity = quantity;
        this.total = salePrice * quantity;
    }

    // Getters and Setters
    public Long getBillItemId() {
        return billItemId;
    }

    public void setBillItemId(Long billItemId) {
        this.billItemId = billItemId;
    }

    public Bill getBill() {
        return bill;
    }

    public void setBill(Bill bill) {
        this.bill = bill;
    }

    public stock getStock() {
        return stock;
    }

    public void setStock(stock stock) {
        this.stock = stock;
    }

    public Double getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(Double salePrice) {
        this.salePrice = salePrice;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public void calculateTotal() {
        this.total = this.salePrice * this.quantity;
    }
}