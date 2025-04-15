package com.mini.stockeaseproject.Repository;

import com.mini.stockeaseproject.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsermobilenumber(String mobileNumber);
}
