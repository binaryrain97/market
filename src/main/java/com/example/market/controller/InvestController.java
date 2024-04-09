package com.example.market.controller;


import com.example.market.model.dto.InvestDto;
import com.example.market.service.InvestService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/invest")
@RequiredArgsConstructor
@Slf4j
public class InvestController {

    private final InvestService investService;

    @GetMapping("/record")
    @PreAuthorize("isAuthenticated()")
    public String record(Principal principal,
                         Model model) {
        List<InvestDto> investDtoList = investService.getInvestList(principal.getName());
        model.addAttribute("investList", investDtoList);
        return "invest/record";
    }

    @PostMapping("/record/new")
    @PreAuthorize("isAuthenticated()")
    public String createRecord(InvestDto dto,
                               Principal principal) {
        System.out.println("test");
        investService.createRecord(dto, principal.getName());
        System.out.println("success");
        return "redirect:/invest/record";
    }
}
