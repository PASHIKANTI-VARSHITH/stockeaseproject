package com.mini.stockeaseproject.Controller;

import com.mini.stockeaseproject.Model.User;
import com.mini.stockeaseproject.Service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

@Controller
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping("/index")
    public String home(){
        return "index";
    }

    @GetMapping("/login")
    public String loginpage(){
        return "login";
    }
    @GetMapping("/createaccount")
    public String createaccpage(){
        return "createaccount";
    }

    @PostMapping("/saveuser")
    public String adduser(@ModelAttribute User user){
        service.save(user);
        return "redirect:/login";
    }

    @PostMapping("/login")
    public String login(@RequestParam("usermobilenumber") String usermobilenumber,
                        @RequestParam("password") String password,
                        HttpSession session, Model model) {
        // Validate user using UserService
        User user = service.validateUser(usermobilenumber, password);

        // If user is found and password is correct
        if (user != null) {
            session.setAttribute("user", user); // Store user in session
            return "redirect:/landing"; // Redirect to dashboard
        } else {
            model.addAttribute("error", "Invalid credentials or user not found!");
            return "login"; // Redirect back to login if authentication fails
        }
    }



    // Show Dashboard (Only if Logged In)
    @GetMapping("/landing")
    public String dashboard(HttpSession session, Model model) {
        User user = (User) session.getAttribute("user");

        if (user == null) {
            return "redirect:/login"; // Redirect to login if session expired or user not logged in
        }

        // Add user details to the model to display on the dashboard
        model.addAttribute("user", user);
        return "landing"; // Renders dashboard.html
    }

    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "redirect:/index";
    }

    @GetMapping("/dashboard")
    public String showDashboard() {
        return "dashboard"; // This will refer to src/main/resources/templates/{page}.html
    }


}
