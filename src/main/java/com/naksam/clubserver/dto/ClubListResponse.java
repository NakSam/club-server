package com.naksam.clubserver.dto;

import com.naksam.clubserver.domain.Club;

public class ClubListResponse {


    private long id;
    private String name;
    private long memberNum;
    private long maxMemberNum;
    private String category;
    private String location;

    private ClubListResponse() {
    }

    private ClubListResponse(long id, String name, long memberNum, long maxMemberNum, String category, String location){
        this.id = id;
        this.name = name;
        this.memberNum = memberNum;
        this.maxMemberNum = maxMemberNum;
        this.category = category;
        this.location = location;
    }
    public ClubListResponse(Club club){
        this.id = club.getId();
        this.name = club.getName();
        this.memberNum = club.getMemberNum();
        this.maxMemberNum = club.getMaxMemberNum();
        this.category = club.getCategory();
        this.location = club.getLocation();
    }



    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getMemberNum() {
        return memberNum;
    }

    public void setMemberNum(long memberNum) {
        this.memberNum = memberNum;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public long getMaxMemberNum() {
        return maxMemberNum;
    }

    public void setMaxMemberNum(long maxMemberNum) {
        this.maxMemberNum = maxMemberNum;
    }
}
