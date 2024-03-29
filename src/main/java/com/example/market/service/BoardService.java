package com.example.market.service;

import com.example.market.model.dto.BoardForm;
import com.example.market.model.entity.Board;
import com.example.market.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;

    public Board createBoard(BoardForm form) {
        return boardRepository.save(form.toEntity());
    }
}
