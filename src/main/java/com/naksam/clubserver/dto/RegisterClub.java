package com.naksam.clubserver.dto;

import com.naksam.clubserver.domain.entity.Club;
import com.naksam.clubserver.domain.constants.Category;
import com.naksam.clubserver.domain.constants.Location;
import com.naksam.clubserver.domain.objects.ClubName;
import com.naksam.clubserver.domain.objects.MemberNumber;
import lombok.Data;

@Data
public class RegisterClub {
    private String name;

    private Long ownerId;

    private Integer memberNum;

    private Integer maxMemberNum;

    private String category;

    private String location;

    public Club entity() {
        return Club.builder()
                .name(new ClubName(name))
                .memberNumber(new MemberNumber(maxMemberNum))
                .category(Category.fromString(category))
                .location(Location.fromString(location))
                .build();
    }
}
