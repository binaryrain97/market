package com.example.market.controller;

import com.example.market.model.dto.MemberDto;
import com.example.market.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/member")
@RequiredArgsConstructor
@Slf4j
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/new")
    public String create() {
        return "member/new";
    }

    @GetMapping("/login")
    public String login() {
        return "member/login";
    }

    @PostMapping("/new")
    public String signUp(MemberDto dto) {
        this.memberService.create(dto.getUserId(), dto.getPassword());
        return "redirect:/board/list";
    }

}
