package com.example.market.service;

import com.example.market.model.dto.CommentDto;
import com.example.market.model.entity.Board;
import com.example.market.model.entity.Comment;
import com.example.market.repository.BoardRepository;
import com.example.market.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;
    private final BoardRepository boardRepository;

    public List<CommentDto> comments(Long boardId) {
        List<Comment> comments = commentRepository.findAllByBoardId(boardId);
        return comments.stream().map(CommentDto::toDto).toList();
    }

    @Transactional
    public CommentDto create(Long boardId, CommentDto dto) {
        Board board = this.boardRepository.findById(boardId)
                .orElseThrow(() -> new IllegalArgumentException("댓글 생성 실패"));
        Comment comment = Comment.createComment(dto, board);
        Comment created = commentRepository.save(comment);
        return CommentDto.toDto(created);
    }

    @Transactional
    public CommentDto update(Long id, CommentDto dto) {
        Comment target = commentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("실패"));
        target.patch(dto);
        Comment updated = commentRepository.save(target);
        return CommentDto.toDto(updated);
    }

    @Transactional
    public CommentDto delete(Long id) {
        Comment target = commentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("실패"));
        this.commentRepository.delete(target);
        return CommentDto.toDto(target);
    }
}
