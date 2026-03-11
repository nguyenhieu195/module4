package com.hieudev.demo.Controller;

import com.hieudev.demo.Entity.Account;
import com.hieudev.demo.Service.ILoginSv;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping
public class LoginCtl {

    @Autowired
    private ILoginSv loginSv;

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @GetMapping("/home")
    public String homePage(HttpSession session) {
        if(session.getAttribute("user")==null){
            return "redirect:/login";
        }
        return "home";
    }

    @PostMapping("/login")
    public String login(@RequestParam ("username") String username,
                        @RequestParam ("password") String password,
                        HttpSession session) {

        Account account = loginSv.checkLogin(username, password);

        if (account != null) {
            session.setAttribute("user", account);
            return "redirect:/home";
        }

        return "login";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {

        session.invalidate();

        return "redirect:/login";
    }
}