package com.example.market.model.dto;

import com.example.market.model.entity.Member;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString
public class MemberDto {
    private String userId;
    private String nickname;
    private String password;

    public static MemberDto toDto(Member member) {
        return MemberDto.builder()
                .userId(member.getUserId())
                .nickname(member.getNickname())
                .password(member.getPassword())
                .build();
    }
}
