package com.example.market.service;

import com.example.market.model.dto.CommentDto;
import com.example.market.model.entity.Comment;
import com.example.market.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;
    public List<CommentDto> comments(Long boardId) {
        List<Comment> comments = commentRepository.findAllByBoardId(boardId);
        return comments.stream().map(CommentDto::toDto).toList();
    }
}
