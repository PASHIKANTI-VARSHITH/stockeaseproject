package com.mini.stockeaseproject.Repository;

import com.mini.stockeaseproject.Model.Bill;
import com.mini.stockeaseproject.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BillRepository extends JpaRepository<Bill, Long> {
    List<Bill> findByUser(User user);

}