package com.naksam.clubserver.dto;

import com.naksam.clubserver.domain.constants.Category;
import com.naksam.clubserver.domain.constants.Location;
import com.naksam.clubserver.domain.entity.Club;
import com.naksam.clubserver.domain.entity.User;
import com.naksam.clubserver.domain.objects.ClubName;
import com.naksam.clubserver.domain.objects.MemberNumber;
import lombok.Data;

@Data
public class RegisterClub {
    private String name;

    private Integer maxMemberNum;

    private String category;

    private String location;

    private String image;

    private String description;

    private Long amount;

    public Club entity() {
        return Club.builder()
                .name(new ClubName(name))
                .memberNumber(new MemberNumber(maxMemberNum))
                .category(Category.fromString(category))
                .location(Location.fromString(location))
                .image(image)
                .description(description)
                .build();
    }
}
