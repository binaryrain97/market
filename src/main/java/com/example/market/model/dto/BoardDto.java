package com.example.market.model.dto;

import com.example.market.model.entity.Board;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString
public class BoardDto {
    private Long id;
    private String title;
    private String content;

    public static BoardDto toDto(Board board) {
        return new BoardDto(board.getId(), board.getTitle(), board.getTitle());
    }
}
