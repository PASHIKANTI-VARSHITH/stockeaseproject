package com.mini.stockeaseproject.Service;

import com.mini.stockeaseproject.Model.User;
import com.mini.stockeaseproject.Model.staff;
import com.mini.stockeaseproject.Repository.StaffRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StaffService {
    private final StaffRepository staffRepository;

    public StaffService(StaffRepository staffRepository) {
        this.staffRepository = staffRepository;
    }

    public void addEmployee(staff employee) {
        staffRepository.save(employee);
    }

    public List<staff> fetchstaff(User user) {
        return staffRepository.findByUser(user);
    }
}
