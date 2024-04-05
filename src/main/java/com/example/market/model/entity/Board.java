package com.example.market.model.entity;

import com.example.market.model.dto.BoardForm;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String title;

    @Column
    private String content;

    @ManyToOne
    private Member member;

    public void patch(BoardForm form) {
        if(form.getTitle() != null) this.title = form.getTitle();
        if(form.getContent() != null) this.content = form.getContent();
    }
}
