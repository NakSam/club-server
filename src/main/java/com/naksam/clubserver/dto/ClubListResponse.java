package com.naksam.clubserver.dto;

import com.naksam.clubserver.domain.constants.Category;
import com.naksam.clubserver.domain.constants.Location;
import com.naksam.clubserver.domain.entity.Club;
import com.naksam.clubserver.domain.objects.ClubName;
import com.naksam.clubserver.domain.objects.MemberNumber;
import lombok.Getter;

@Getter
public class ClubListResponse {
    private Long id;
    private ClubName name;
    private Long clubMasterId;
    private String clubMasterName;
    private MemberNumber maxMemberNum;
    private String category;
    private String location;
    private String image;
    private Long memberNum;

    private ClubListResponse() {
    }

    public ClubListResponse(Long id, ClubName name, Long clubMasterId, String clubMasterName, MemberNumber maxMemberNum, Category category, Location location, String image, Long memberNum) {
        this.id = id;
        this.name = name;
        this.clubMasterId = clubMasterId;
        this.clubMasterName = clubMasterName;
        this.maxMemberNum = maxMemberNum;
        this.category = category.getCategoryName();
        this.location = location.getLocationName();
        this.image = image;
        this.memberNum = memberNum;
    }

    public ClubListResponse(Club club) {
        this.id = club.getId();
        this.name = club.getName();
        this.maxMemberNum = club.getMemberNumber();
        this.category = club.getCategory()
                .getCategoryName();
        this.location = club.getLocation()
                .getLocationName();
        this.image = club.getImage();
    }

    public ClubListResponse(Club club, Long memberNum) {
        this.id = club.getId();
        this.name = club.getName();
        this.maxMemberNum = club.getMemberNumber();
        this.category = club.getCategory()
                .getCategoryName();
        this.location = club.getLocation()
                .getLocationName();
        this.image = club.getImage();
        this.memberNum = memberNum;
    }

    public String getName() {
        return name.content();
    }

    public int getMaxMemberNum() {
        return maxMemberNum.count();
    }
}
