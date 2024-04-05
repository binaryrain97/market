package com.example.market.api;

import com.example.market.model.dto.BoardDto;
import com.example.market.model.dto.BoardForm;
import com.example.market.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BoardApiController {
    private final BoardService boardService;

    @GetMapping("/api/board/list")
    public List<BoardDto> index() {
        return this.boardService.getIndex();
    }

    @GetMapping("/api/board/{id}")
    public BoardDto show(@PathVariable Long id) {
        return this.boardService.getDetail(id);
    }

//    @PostMapping("/api/board")
//    public ResponseEntity<BoardDto> create(@RequestBody BoardForm form) {
//        BoardDto created = this.boardService.createBoard(form);
//        return (created != null) ?
//                ResponseEntity.status(HttpStatus.OK).body(created):
//                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
//    }

    @PatchMapping("/api/board/{id}")
    public ResponseEntity<BoardDto> update(@PathVariable Long id,
                                          @RequestBody BoardForm form) {
        BoardDto updated = this.boardService.update(id, form);
        return (updated != null)?
                ResponseEntity.status(HttpStatus.OK).body(updated):
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @DeleteMapping("/api/board/{id}")
    public ResponseEntity<BoardDto> delete(@PathVariable Long id) {
        BoardDto deleted = this.boardService.delete(id);
        return (deleted != null)?
                ResponseEntity.status(HttpStatus.NO_CONTENT).body(deleted):
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
}
