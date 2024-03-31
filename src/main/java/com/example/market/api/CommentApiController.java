package com.example.market.api;

import com.example.market.model.dto.CommentDto;
import com.example.market.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CommentApiController {

    private final CommentService commentService;

    @GetMapping("/api/board/{boardId}/comment")
    public ResponseEntity<List<CommentDto>> comments(@PathVariable Long boardId) {
        List<CommentDto> dtos = commentService.comments(boardId);
        return ResponseEntity.status(HttpStatus.OK).body(dtos);
    }
}
