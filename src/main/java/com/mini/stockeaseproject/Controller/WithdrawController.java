package com.mini.stockeaseproject.Controller;

import com.mini.stockeaseproject.Model.User;
import com.mini.stockeaseproject.Model.withdraw;
import com.mini.stockeaseproject.Service.WithdrawService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.List;

@Controller
public class WithdrawController {
    private final WithdrawService wdser;

    public WithdrawController(WithdrawService wdser) {
        this.wdser = wdser;
    }

    @GetMapping("/withdraw")
    public String showWithdraw(HttpSession session, Model model){
        User user=(User) session.getAttribute("user");
        if(user==null){
            return "redirect:/login";
        }
        List<withdraw> withdrawList=wdser.fetchwithdraw(user);
        model.addAttribute("withdraws",withdrawList);
        return "withdraw";
    }

    @PostMapping("/addWithdraw")
    public String addWithdraw(@RequestParam double withdrawamount,
                              @RequestParam String withdrawdate,
                              HttpSession session){
        User user=(User) session.getAttribute("user");
        LocalDate wddate=LocalDate.parse(withdrawdate);
        withdraw withdraws=new withdraw(user,withdrawamount,wddate);
        wdser.addWithdraws(withdraws);
        return "redirect:/landing";
    }
}
