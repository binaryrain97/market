package com.example.market.service;

import com.example.market.model.dto.BoardDto;
import com.example.market.model.dto.BoardForm;
import com.example.market.model.entity.Board;
import com.example.market.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;

    public BoardDto createBoard(BoardForm form) {
        return BoardDto.toDto(boardRepository.save(form.toEntity()));
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

    public BoardDto update(Long id, BoardForm form) {
        Board board = form.toEntity();
        Optional<Board> target = this.boardRepository.findById(form.getId());
        if(target.isEmpty() || !Objects.equals(target.get().getId(), form.getId()))
            throw new RuntimeException();
        Board targetBoard = target.get();
        targetBoard.patch(form.toEntity());
        Board updated = this.boardRepository.save(targetBoard);
        return BoardDto.toDto(updated);
    }

    public BoardDto delete(Long id) {
        Board target = this.boardRepository.findById(id).orElse(null);
        if(target == null) return null;
        this.boardRepository.delete(target);
        return BoardDto.toDto(target);
    }
}
