package com.mini.stockeaseproject.Service;

import com.mini.stockeaseproject.Model.Bill;
import com.mini.stockeaseproject.Model.Customer;
import com.mini.stockeaseproject.Model.User;
import com.mini.stockeaseproject.Repository.BillRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalesService {
    private final BillRepository bilrep;

    public SalesService(BillRepository bilrep) {
        this.bilrep = bilrep;
    }

    public List<Bill> fetchsales(User user) {
        return bilrep.findByUser(user);
    }
}
