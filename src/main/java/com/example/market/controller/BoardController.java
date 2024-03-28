package com.example.market.controller;

import com.example.market.model.dto.BoardForm;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/board")
public class BoardController {
    @GetMapping("/new")
    public String newBoardForm() {
        return "board/new";
    }

    @PostMapping("/create")
    public String createBoard(BoardForm form) {
        System.out.println(form.toString());
        return "";
    }
}
