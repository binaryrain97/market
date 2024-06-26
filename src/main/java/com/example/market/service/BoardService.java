package com.example.market.service;

import com.example.market.model.dto.BoardDto;
import com.example.market.model.dto.BoardForm;
import com.example.market.model.entity.Board;
import com.example.market.model.entity.Member;
import com.example.market.repository.BoardRepository;
import com.example.market.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;
    private final MemberRepository memberRepository;

    @Transactional
    public BoardDto createBoard(BoardForm form, String userId) {
        Optional<Member> _member = this.memberRepository.findById(userId);
        if(_member.isEmpty()) return null;
        Member member = _member.get();
        Board board = Board.builder()
                .title(form.getTitle())
                .content(form.getContent())
                .createdAt(LocalDateTime.now())
                .author(member)
                .commentList(new ArrayList<>())
                .build();
        return BoardDto.toDto(boardRepository.save(board));
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
        Optional<Board> _target = this.boardRepository.findById(form.getId());
        if(_target.isEmpty() || !Objects.equals(_target.get().getId(), form.getId()))
            throw new RuntimeException();
        Board target = _target.get();
        target.patch(form);
        Board updated = this.boardRepository.save(target);
        return BoardDto.toDto(updated);
    }

    public BoardDto delete(Long id) {
        Board target = this.boardRepository.findById(id).orElse(null);
        if(target == null) return null;
        this.boardRepository.delete(target);
        return BoardDto.toDto(target);
    }

    public List<BoardDto> getMyBoardList(String memberId) {
        return this.boardRepository.findAllByMemberId(memberId)
                .stream().map(BoardDto::toDto).toList();
    }

    public Page<Board> getListOnPage(int page) {
        Pageable pageable = PageRequest.of(page, 10);
        return this.boardRepository.findAllOnPage(pageable);
    }
}
