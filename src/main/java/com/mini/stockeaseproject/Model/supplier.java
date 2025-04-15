package com.mini.stockeaseproject.Model;

import jakarta.persistence.*;

@Entity
public class supplier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long supplierid;
    @ManyToOne
    @JoinColumn(name = "userid",referencedColumnName = "userid")
    private User user;
    private String suppliercompanyname;
    private String suppliercontactname;
    private String suppliermobilenumber;
    private String supplieraddress;
    private Double supplierpendingamount;
    private Double suppliertotalamountpaid;

    public supplier() {
    }

    public supplier(User user, String suppliercompanyname, String suppliercontactname, String suppliermobilenumber, String supplieraddress, Double supplierpendingamount, Double suppliertotalamountpaid) {
        this.user = user;
        this.suppliercompanyname = suppliercompanyname;
        this.suppliercontactname = suppliercontactname;
        this.suppliermobilenumber = suppliermobilenumber;
        this.supplieraddress = supplieraddress;
        this.supplierpendingamount = supplierpendingamount;
        this.suppliertotalamountpaid = suppliertotalamountpaid;
    }

    public Long getSupplierid() {
        return supplierid;
    }

    public void setSupplierid(Long supplierid) {
        this.supplierid = supplierid;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getSuppliercompanyname() {
        return suppliercompanyname;
    }

    public void setSuppliercompanyname(String suppliercompanyname) {
        this.suppliercompanyname = suppliercompanyname;
    }

    public String getSuppliercontactname() {
        return suppliercontactname;
    }

    public void setSuppliercontactname(String suppliercontactname) {
        this.suppliercontactname = suppliercontactname;
    }

    public String getSuppliermobilenumber() {
        return suppliermobilenumber;
    }

    public void setSuppliermobilenumber(String suppliermobilenumber) {
        this.suppliermobilenumber = suppliermobilenumber;
    }

    public Double getSupplierpendingamount() {
        return supplierpendingamount;
    }

    public void setSupplierpendingamount(Double supplierpendingamount) {
        this.supplierpendingamount = supplierpendingamount;
    }

    public String getSupplieraddress() {
        return supplieraddress;
    }

    public void setSupplieraddress(String supplieraddress) {
        this.supplieraddress = supplieraddress;
    }

    public Double getSuppliertotalamountpaid() {
        return suppliertotalamountpaid;
    }

    public void setSuppliertotalamountpaid(Double suppliertotalamountpaid) {
        this.suppliertotalamountpaid = suppliertotalamountpaid;
    }
}
