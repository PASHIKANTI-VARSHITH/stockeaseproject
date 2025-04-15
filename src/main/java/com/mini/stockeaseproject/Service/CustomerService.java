package com.mini.stockeaseproject.Service;
import com.mini.stockeaseproject.Model.Customer;

import com.mini.stockeaseproject.Model.User;
import com.mini.stockeaseproject.Model.deposition;
import com.mini.stockeaseproject.Repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    private final CustomerRepository cusrep;

    public CustomerService(CustomerRepository cusrep) {
        this.cusrep = cusrep;
    }

    public List<Customer> fetchcustomers(User user) {
        return cusrep.findByUser(user);
    }
}
