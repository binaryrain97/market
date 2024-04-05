package com.example.market.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FirstController {

    @GetMapping("/hi")
    public String niceToMeetYou(Model model) {
        model.addAttribute("username", "사오정");
        return "greetings";
    }

    @GetMapping("/quote")
    public String randomQuote(Model model) {
        model.addAttribute("randomQuote", "1234");
        return "quote";
    }

    @GetMapping("/")
    public String home() {
        return "redirect:/board/list";
    }

    @GetMapping("/home")
    public String test(@AuthenticationPrincipal UserDetails user, Model model) {
        if(user != null)
            model.addAttribute("user", user.getUsername());
        return "home";
    }
}
