package com.naksam.clubserver.dto;

import com.naksam.clubserver.domain.Club;
import lombok.Data;

@Data
public class RegisterClub {
    private String name;

    private Long ownerId;

    private Long memberNum;

    private Long maxMemberNum;

    private String category;

    private String location;

    public Club entity() {
        return Club.builder()
                .name(name)
                .memberNum(memberNum)
                .maxMemberNum(maxMemberNum)
                .category(category)
                .location(location)
                .build();
    }
}
