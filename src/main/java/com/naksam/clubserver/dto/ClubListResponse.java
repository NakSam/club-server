package com.naksam.clubserver.dto;

import com.naksam.clubserver.domain.entity.Club;
import com.naksam.clubserver.domain.objects.ClubName;
import com.naksam.clubserver.domain.objects.MemberNumber;
import lombok.Getter;

@Getter
public class ClubListResponse {
    private long id;
    private ClubName name;
    private MemberNumber maxMemberNum;
    private String category;
    private String location;

    private ClubListResponse() {
    }

    private ClubListResponse(long id, ClubName name, MemberNumber maxMemberNum, String category, String location) {
        this.id = id;
        this.name = name;
        this.maxMemberNum = maxMemberNum;
        this.category = category;
        this.location = location;
    }

    public ClubListResponse(Club club) {
        this.id = club.getId();
        this.name = club.getName();
        this.maxMemberNum = club.getMemberNumber();
        this.category = club.getCategory()
                .getCategoryName();
        this.location = club.getLocation()
                .getLocationName();
    }

    public String getName() {
        return name.content();
    }

    public int getMaxMemberNum() {
        return maxMemberNum.count();
    }
}
