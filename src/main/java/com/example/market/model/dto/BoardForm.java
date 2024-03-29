package com.example.market.model.dto;

import com.example.market.model.entity.Board;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class BoardForm {
    private String title;
    private String content;

    @Override
    public String toString() {
        return "BoardForm{" +
                "title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }

    public Board toEntity()  {
        return new Board(null, title, content);
    }
}
