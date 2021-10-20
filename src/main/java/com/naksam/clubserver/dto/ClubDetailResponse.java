package com.naksam.clubserver.dto;

import com.naksam.clubserver.domain.constants.Category;
import com.naksam.clubserver.domain.constants.Location;
import com.naksam.clubserver.domain.objects.ClubName;
import com.naksam.clubserver.domain.objects.MemberNumber;
import lombok.Getter;

@Getter
public class ClubDetailResponse {
    private long id;
    private ClubName name;
    private String clubMaster;
    private MemberNumber maxMemberNum;
    private Long memberNum;
    private Category category;
    private Location location;
    private String image;
    private Long dues;
    private String description;

    public ClubDetailResponse() {
    }

    public ClubDetailResponse(long id, ClubName name, String clubMaster, MemberNumber maxMemberNum,
            Long memberNum, Category category, Location location, String image, Long dues,
            String description) {
        this.id = id;
        this.name = name;
        this.clubMaster = clubMaster;
        this.maxMemberNum = maxMemberNum;
        this.memberNum = memberNum;
        this.category = category;
        this.location = location;
        this.image = image;
        this.dues = dues;
        this.description = description;
    }



    public int getMaxMemberNum() {
        return maxMemberNum.count();
    }

    public String getCategory(){return category.getCategoryName();}

    public String getLocation(){return location.getLocationName();}

    public String getName() {
        return name.content();
    }
}
