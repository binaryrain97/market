package com.example.market.service;

import com.example.market.model.dto.BoardDto;
import com.example.market.model.dto.BoardForm;
import com.example.market.model.entity.Board;
import com.example.market.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;

    public Board createBoard(BoardForm form) {
        return boardRepository.save(form.toEntity());
    }

    public BoardDto getDetail(Long id) {
        Optional<Board> board = this.boardRepository.findById(id);
        if(board.isEmpty()) throw new RuntimeException();
        return BoardDto.toDto(board.get());
    }

    public List<BoardDto> getIndex() {
        return this.boardRepository.findAll()
                .stream().map(BoardDto::toDto).toList();
    }

    public BoardDto update(BoardForm form) {
        Optional<Board> target = this.boardRepository.findById(form.getId());
        if(target.isEmpty()) throw new RuntimeException();
        Board updated = this.boardRepository.save(form.toEntity());
        return BoardDto.toDto(updated);
    }

    public void delete(Long id) {
        Optional<Board> target = this.boardRepository.findById(id);
        if(target.isPresent()) this.boardRepository.delete(target.get());
    }
}
