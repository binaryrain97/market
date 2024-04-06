package com.example.market.api;

import com.example.market.model.dto.CommentDto;
import com.example.market.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
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

    @PreAuthorize("isAuthenticated()")
    @PostMapping("/api/board/{boardId}/comment")
    public ResponseEntity<CommentDto> create(@PathVariable Long boardId,
                                             @RequestBody CommentDto dto,
                                             Principal principal) {
        CommentDto createdDto = this.commentService.create(boardId, dto, principal.getName());
        return ResponseEntity.status(HttpStatus.OK).body(createdDto);
    }

    @PatchMapping("/api/comment/{id}")
    public ResponseEntity<CommentDto> update(@PathVariable Long id,
                                             @RequestBody CommentDto dto) {
        CommentDto updatedDto = this.commentService.update(id, dto);
        return ResponseEntity.status(HttpStatus.OK).body(updatedDto);
    }

    @DeleteMapping("/api/comment/{id}")
    public ResponseEntity<CommentDto> delete(@PathVariable Long id) {
        CommentDto deletedDto = this.commentService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body(deletedDto);
    }
}
