package com.example.market.model.dto;

import com.example.market.model.entity.Comment;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString
public class CommentDto {
    private Long id;
    private Long boardId;
    private String nickname;
    private String body;

    public static CommentDto toDto(Comment comment) {
        return new CommentDto(
                comment.getId(),
                comment.getBoard().getId(),
                comment.getBody(),
                comment.getBody()
        );
    }
}
