package com.example.market.controller;

import com.example.market.model.dto.BoardForm;
import com.example.market.model.entity.Board;
import com.example.market.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    @GetMapping("/new")
    public String newBoardForm() {
        return "board/new";
    }

    @PostMapping("/create")
    public String createBoard(BoardForm form) {
        System.out.println(form.toString());
        Board saved = boardService.createBoard(form);
        return "";
    }

    @GetMapping("/list")
    public String index() {
        return "";
    }
}
