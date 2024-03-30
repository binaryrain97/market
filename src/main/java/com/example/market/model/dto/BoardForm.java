package com.example.market.model.dto;

import com.example.market.model.entity.Board;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString
public class BoardForm {
    private Long id;
    private String title;
    private String content;

    public Board toEntity()  {
        return new Board(id, title, content);
    }
}
