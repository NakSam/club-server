package com.naksam.clubserver.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
public class Club {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "club_id")
    private Long id;

    private String name;

    private Long ownerId;

    private Long memberNum;

    private Long maxMemberNum;

    private String category;

    private String location;

    public Long id() {
        return id;
    }
}
