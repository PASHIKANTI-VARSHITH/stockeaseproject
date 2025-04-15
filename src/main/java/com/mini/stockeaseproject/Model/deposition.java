package com.mini.stockeaseproject.Model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class deposition {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long depositionid;

    @ManyToOne
    @JoinColumn(name="userid",referencedColumnName = "userid")
    private User user;

    public Double depositionamount;
    public LocalDate depositiondate;

    public deposition() {
    }

    public deposition(User user, Double depositionamount, LocalDate depositiondate) {
        this.user = user;
        this.depositionamount = depositionamount;
        this.depositiondate = depositiondate;
    }

    public long getDepositionid() {
        return depositionid;
    }

    public void setDepositionid(long depositionid) {
        this.depositionid = depositionid;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Double getDepositionamount() {
        return depositionamount;
    }

    public void setDepositionamount(Double depositionamount) {
        this.depositionamount = depositionamount;
    }

    public LocalDate getDepositiondate() {
        return depositiondate;
    }

    public void setDepositiondate(LocalDate depositiondate) {
        this.depositiondate = depositiondate;
    }
}
