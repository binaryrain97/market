package com.example.market.controller;


import com.example.market.model.dto.DailyRecordDto;
import com.example.market.service.DailyRecordService;
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
public class DailyRecordController {

    private final DailyRecordService dailyRecordService;

    @GetMapping("/record")
    @PreAuthorize("isAuthenticated()")
    public String record(Principal principal,
                         Model model) {
        List<DailyRecordDto> dailyRecordList = dailyRecordService.getInvestList(principal.getName());
        model.addAttribute("dailyRecordList", dailyRecordList);
        return "invest/record";
    }

    @PostMapping("/record/new")
    @PreAuthorize("isAuthenticated()")
    public String createRecord(DailyRecordDto dto,
                               Principal principal) {
        dailyRecordService.createRecord(dto, principal.getName());
        return "redirect:/invest/record";
    }
}
