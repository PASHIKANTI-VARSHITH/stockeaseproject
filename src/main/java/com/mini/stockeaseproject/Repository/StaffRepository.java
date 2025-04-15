package com.mini.stockeaseproject.Repository;

import com.mini.stockeaseproject.Model.User;
import com.mini.stockeaseproject.Model.staff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StaffRepository extends JpaRepository<staff,String> {
    List<staff> findByUser(User user);
}
