package com.example.market.repository;

import com.example.market.model.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    @Query("SELECT c FROM Comment c WHERE c.board.id = :boardId")
    List<Comment> findAllByBoardId(Long boardId);
}
