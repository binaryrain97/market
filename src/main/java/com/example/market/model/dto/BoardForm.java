package com.example.market.model.dto;

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
}
