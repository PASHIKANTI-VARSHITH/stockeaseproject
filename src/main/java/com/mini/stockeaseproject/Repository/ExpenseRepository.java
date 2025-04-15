package com.mini.stockeaseproject.Repository;

import com.mini.stockeaseproject.Model.User;
import com.mini.stockeaseproject.Model.expenses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExpenseRepository extends JpaRepository<expenses,Long> {
    List<expenses> findByUser(User user);

}
