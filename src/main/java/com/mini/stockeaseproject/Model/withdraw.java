package com.mini.stockeaseproject.Model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class withdraw {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long withdrawId;

    @ManyToOne
    @JoinColumn(name="userid",referencedColumnName = "userid")
    private User user;

    public Double withdrawamount;
    public LocalDate withdrawdate;

    public withdraw() {
    }

    public withdraw(User user, Double withdrawamount, LocalDate withdrawdate) {
        this.user = user;
        this.withdrawamount = withdrawamount;
        this.withdrawdate = withdrawdate;
    }

    public Long getWithdrawId() {
        return withdrawId;
    }

    public void setWithdrawId(Long withdrawId) {
        this.withdrawId = withdrawId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Double getWithdrawamount() {
        return withdrawamount;
    }

    public void setWithdrawamount(Double withdrawamount) {
        this.withdrawamount = withdrawamount;
    }

    public LocalDate getWithdrawdate() {
        return withdrawdate;
    }

    public void setWithdrawdate(LocalDate withdrawdate) {
        this.withdrawdate = withdrawdate;
    }
}
