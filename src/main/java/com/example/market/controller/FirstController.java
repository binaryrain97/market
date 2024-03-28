package com.example.market.controller;

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
}
