package com.mini.stockeaseproject.Repository;

import com.mini.stockeaseproject.Model.User;
import com.mini.stockeaseproject.Model.deposition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepositionRepository extends JpaRepository<deposition,Long> {

    List<deposition> findByUser(User user);
}
