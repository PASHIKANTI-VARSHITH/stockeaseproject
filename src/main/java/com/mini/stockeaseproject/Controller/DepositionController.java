package com.mini.stockeaseproject.Controller;

import com.mini.stockeaseproject.Model.User;
import com.mini.stockeaseproject.Model.deposition;
import com.mini.stockeaseproject.Service.DepositionService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.List;

@Controller
public class DepositionController {
    private final DepositionService depser;

    public DepositionController(DepositionService depser) {
        this.depser = depser;
    }

    @GetMapping("/deposition")
    public String showDepositions(HttpSession session, Model model){
        User user=(User) session.getAttribute("user");
        if(user==null){
            return "redirect:/login";
        }
        List<deposition> depositionList=depser.fetchdepositions(user);
        model.addAttribute("deposits", depositionList);
        return "deposition";
    }

    @PostMapping("/addDeposition")
    public String addDeposition(@RequestParam double depositionamount,
                                @RequestParam String depositiondate ,
                                HttpSession session){
        User user=(User) session.getAttribute("user");

        LocalDate depdate=LocalDate.parse(depositiondate);
        deposition depositions=new deposition(user,depositionamount,depdate);
        depser.addDeposition(depositions);
        return "redirect:/landing";
    }
}
