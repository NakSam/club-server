package com.naksam.clubserver.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Club {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "club_id")
    private Long id;

    private String name;

    private Long ownerId;

    private long memberNum;

    private long maxMemberNum;

    private String category;

    private String location;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Long getOwnerId() {
        return ownerId;
    }

    public long getMemberNum() {
        return memberNum;
    }

    public long getMaxMemberNum() {
        return maxMemberNum;
    }

    public String getCategory() {
        return category;
    }

    public String getLocation() {
        return location;
    }



}
