package com.mini.stockeaseproject.Repository;

import com.mini.stockeaseproject.Model.User;
import com.mini.stockeaseproject.Model.withdraw;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WithdrawRepository extends JpaRepository<withdraw,Long> {

    List<withdraw> findByUser(User user);
}
