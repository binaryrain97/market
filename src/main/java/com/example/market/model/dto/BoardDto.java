package com.example.market.model.dto;

import com.example.market.model.entity.Board;
import lombok.*;

import java.time.LocalDateTime;

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
    private MemberDto author;
    private LocalDateTime createdAt;
    private Integer commentCount;

    public static BoardDto toDto(Board board) {
        return BoardDto.builder()
                .id(board.getId())
                .title(board.getTitle())
                .content(board.getContent())
                .author(MemberDto.toDto(board.getAuthor()))
                .createdAt(board.getCreatedAt())
                .commentCount(board.getCommentList().size())
                .build();
    }
}
