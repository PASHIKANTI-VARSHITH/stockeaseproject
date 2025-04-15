package com.mini.stockeaseproject.Repository;

import com.mini.stockeaseproject.Model.Customer;
import com.mini.stockeaseproject.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Optional<Customer> findByCustomerMobileNumberAndUser(String mobileNumber, User user);
    List<Customer> findByUser(User user);
}