package com.mini.stockeaseproject.Controller;

import com.mini.stockeaseproject.Model.Customer;
import com.mini.stockeaseproject.Model.User;
import com.mini.stockeaseproject.Service.CustomerService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class CustomerController {
    private final CustomerService cusser;

    public CustomerController(CustomerService cusser) {
        this.cusser = cusser;
    }

    @GetMapping("/Customer")
    public String showDepositions(HttpSession session, Model model){
        User user=(User) session.getAttribute("user");
        if(user==null){
            return "redirect:/login";
        }
        List<Customer> CustomerList=cusser.fetchcustomers(user);
        model.addAttribute("customers", CustomerList);
        return "Customer";
    }

}
