package com.mini.stockeaseproject.Repository;

import com.mini.stockeaseproject.Model.User;
import com.mini.stockeaseproject.Model.supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SupplierRepository extends JpaRepository<supplier,Long> {
    List<supplier> findByUser(User user);

}
