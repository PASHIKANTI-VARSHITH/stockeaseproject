package com.mini.stockeaseproject.Model;

import jakarta.persistence.*;
import org.springframework.boot.autoconfigure.web.WebProperties;

import java.time.LocalDate;

@Entity
public class stock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long stockid;

    @ManyToOne
    @JoinColumn(name="userid", referencedColumnName = "userid")
    private User user;

    public String productname ;

    public Double costprice;

    public Double stockquantity;

    public Double totalvalue;

    public stock() {
    }

    public stock(User user, String productname, Double costprice, Double stockquantity, Double totalvalue) {
        this.user = user;
        this.productname = productname;
        this.costprice = costprice;
        this.stockquantity = stockquantity;
        this.totalvalue = totalvalue;
    }

    public stock(User user, String productname) {
        this.user = user;
        this.productname = productname;
    }


    public Long getStockid() {
        return stockid;
    }

    public void setStockid(Long stockid) {
        this.stockid = stockid;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public Double getCostprice() {
        return costprice;
    }

    public void setCostprice(Double costprice) {
        this.costprice = costprice;
    }

    public Double getStockquantity() {
        return stockquantity;
    }

    public void setStockquantity(Double stockquantity) {
        this.stockquantity = stockquantity;
    }

    public Double getTotalvalue() {
        return totalvalue;
    }

    public void setTotalvalue(Double totalvalue) {
        this.totalvalue = totalvalue;
    }
}
