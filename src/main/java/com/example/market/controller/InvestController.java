package com.example.market.controller;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@RequestMapping("/invest")
@RequiredArgsConstructor
@Slf4j
public class InvestController {
    @GetMapping("/record")
    @PreAuthorize("isAuthenticated()")
    public String record(Principal principal) {
        return "invest/record";
    }
}
