package com.example.market.model.entity;

import com.example.market.model.dto.CommentDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="board_id")
    private Board board;

    @Column
    private String nickname;

    @Column
    private String body;

    public static Comment createComment(CommentDto dto, Board board) {
        if(dto.getId() != null)
            throw new IllegalArgumentException("댓글의 id가 없어야 합니다");
        if(!dto.getBoardId().equals(board.getId()))
            throw new IllegalArgumentException("게시글의 id가 잘못됐습니다.");
        return new Comment(null, board, dto.getNickname(), dto.getBody());
    }

    public void patch(CommentDto dto) {
        if(this.id != dto.getId())
            throw new IllegalArgumentException("실패");
        if(dto.getNickname() != null)
            this.nickname = dto.getNickname();
        if(dto.getBody() != null)
            this.body = dto.getBody();
    }
}
