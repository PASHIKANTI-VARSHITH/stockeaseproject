package com.mini.stockeaseproject.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.time.LocalDate;

@Entity
public class staff {
    @Id
    private String staffid;

    @ManyToOne
    @JoinColumn(name = "userid", referencedColumnName = "userid")
    private User user;

    private String employeename;
    private String employeemobilenumber;
    private String employeerole;
    private Double employeesalary;
    private LocalDate employeejoiningdate;

    public staff() {
    }

    public staff(String staffid, User user, String employeename, String employeemobilenumber, String employeerole, Double employeesalary, LocalDate employeejoiningdate) {
        this.staffid = staffid;
        this.user = user;
        this.employeename = employeename;
        this.employeemobilenumber = employeemobilenumber;
        this.employeerole = employeerole;
        this.employeesalary = employeesalary;
        this.employeejoiningdate = employeejoiningdate;
    }

    public String getStaffid() {
        return staffid;
    }

    public void setStaffid(String staffid) {
        this.staffid = staffid;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getEmployeename() {
        return employeename;
    }

    public void setEmployeename(String employeename) {
        this.employeename = employeename;
    }

    public String getEmployeemobilenumber() {
        return employeemobilenumber;
    }

    public void setEmployeemobilenumber(String employeemobilenumber) {
        this.employeemobilenumber = employeemobilenumber;
    }

    public String getEmployeerole() {
        return employeerole;
    }

    public void setEmployeerole(String employeerole) {
        this.employeerole = employeerole;
    }

    public Double getEmployeesalary() {
        return employeesalary;
    }

    public void setEmployeesalary(Double employeesalary) {
        this.employeesalary = employeesalary;
    }

    public LocalDate getEmployeejoiningdate() {
        return employeejoiningdate;
    }

    public void setEmployeejoiningdate(LocalDate employeejoiningdate) {
        this.employeejoiningdate = employeejoiningdate;
    }
}
