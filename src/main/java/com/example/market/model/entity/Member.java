package com.example.market.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.List;

@Entity
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Member {
    @Id
    private String id;

    private String nickname;

    private String password;

    private String email;

    @OneToMany
    private List<Invest> investList;

    @OneToMany
    private List<Board> boardList;

    @OneToMany
    private List<DailyRecord> recordList;
}
