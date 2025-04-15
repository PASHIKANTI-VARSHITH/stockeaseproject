package com.mini.stockeaseproject.Controller;

import com.mini.stockeaseproject.Model.Bill;
import com.mini.stockeaseproject.Model.Customer;
import com.mini.stockeaseproject.Model.User;
import com.mini.stockeaseproject.Service.SalesService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class SalesController {

    private final SalesService salser;

    public SalesController(SalesService salser) {
        this.salser = salser;
    }

    @GetMapping("/sales")
    public String showSales(HttpSession session, Model model){
        User user=(User) session.getAttribute("user");
        if(user==null){
            return "redirect:/login";
        }
        List<Bill> salesList=salser.fetchsales(user);
        model.addAttribute("sales", salesList);
        return "sales";
    }
}
