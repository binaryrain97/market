package com.example.market.controller;

import com.example.market.model.dto.BoardDto;
import com.example.market.model.dto.BoardForm;
import com.example.market.model.dto.CommentDto;
import com.example.market.service.BoardService;
import com.example.market.service.CommentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/board")
@RequiredArgsConstructor
@Slf4j
public class BoardController {

    private final BoardService boardService;
    private final CommentService commentService;

    @GetMapping("/new")
    public String newBoardForm() {
        return "board/new";
    }

    @PostMapping("/create")
    @PreAuthorize("isAuthenticated()")
    public String createBoard(BoardForm form, Principal principal) {
        log.info(form.toString());
        BoardDto saved = boardService.createBoard(form, principal.getName());
        return "redirect:/board/" + saved.getId();
    }

    @GetMapping("/list")
    public String index(Principal principal, Model model) {
        List<BoardDto> dtoList = this.boardService.getIndex();
        model.addAttribute("boardList", dtoList);
        if(principal != null) {
            model.addAttribute("userId", principal.getName());
        }
        return "board/index";
    }

    @GetMapping("/{id}")
    public String getDetail(@PathVariable Long id,
                            Model model) {
        BoardDto dto = boardService.getDetail(id);
        List<CommentDto> commentDtos = commentService.comments(id);
        model.addAttribute("board", dto);
        model.addAttribute("commentDtos", commentDtos);
        return "board/show";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable Long id,
                       Model model) {
        BoardDto dto = boardService.getDetail(id);
        model.addAttribute("board", dto);
        return "board/edit";
    }

    @PostMapping("/update")
    public String update(BoardForm form) {
        BoardDto updated = this.boardService.update(form.getId(), form);
        log.info(updated.toString());
        return "redirect:/board/" + updated.getId();
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable Long id,
                         RedirectAttributes rttr) {
        rttr.addFlashAttribute("msg", "삭제됐습니다.!");
        this.boardService.delete(id);
        return "redirect:/board/list";
    }
}
