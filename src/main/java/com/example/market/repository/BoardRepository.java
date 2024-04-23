package com.example.market.repository;

import com.example.market.model.entity.Board;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BoardRepository extends JpaRepository<Board, Long> {
    @Query("SELECT b FROM Board b WHERE b.author.id = :memberId")
    List<Board> findAllByMemberId(String memberId);

    Page<Board> findAllOnPage(Pageable pageable);
}
