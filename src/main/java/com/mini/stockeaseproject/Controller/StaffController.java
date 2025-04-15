package com.mini.stockeaseproject.Controller;

import com.mini.stockeaseproject.Model.User;
import com.mini.stockeaseproject.Model.staff;
import com.mini.stockeaseproject.Service.StaffService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.time.LocalDate;
import java.util.List;

@Controller
public class StaffController {

    private final StaffService staffService;

    public StaffController(StaffService staffService) {
        this.staffService = staffService;
    }

    @GetMapping("/staff")
    public String showStaff(HttpSession session, Model model) {
        User user = (User) session.getAttribute("user");
        if (user == null) {
            return "redirect:/login";
        }
        List<staff> staffList = staffService.fetchstaff(user);
        model.addAttribute("employees", staffList);
        return "staff";
    }

    @PostMapping("/addStaff")
    public String addStaff(@RequestParam String staffid,
                           @RequestParam String employeename,
                           @RequestParam String employeemobilenumber,
                           @RequestParam String employeerole,
                           @RequestParam double employeesalary,
                           @RequestParam String employeejoiningdate,
                           HttpSession session) {
        User user = (User) session.getAttribute("user");
        LocalDate joindate = LocalDate.parse(employeejoiningdate);
        staff employeeList = new staff(staffid, user, employeename, employeemobilenumber, employeerole, employeesalary, joindate);
        staffService.addEmployee(employeeList);
        return "redirect:/landing";
    }
}
