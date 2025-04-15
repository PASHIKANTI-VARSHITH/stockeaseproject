package com.mini.stockeaseproject.Service;

import com.mini.stockeaseproject.Model.User;
import com.mini.stockeaseproject.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository urepo;

    public void save(User user){
        urepo.save(user);
    }

    public User validateUser(String mobileNumber, String password) {
        Optional<User> userOptional = urepo.findByUsermobilenumber(mobileNumber);

        if (userOptional.isPresent()) {
            User user = userOptional.get();
            if (user.getPassword().equals(password)) { // Password check
                return user; // Return the authenticated User object
            }
        }
        return null; // Return null if authentication fails
    }

}
