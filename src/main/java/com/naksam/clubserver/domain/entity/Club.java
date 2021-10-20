package com.naksam.clubserver.domain.entity;

import com.naksam.clubserver.domain.constants.Category;
import com.naksam.clubserver.domain.constants.Location;
import com.naksam.clubserver.domain.objects.ClubName;
import com.naksam.clubserver.domain.objects.MemberNumber;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.CreatedDate;

@Entity
@NoArgsConstructor
@Getter
public class Club extends BaseTimeEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "club_id")
    private Long id;

    @Column(name = "name")
    private ClubName name;

    @ManyToOne
    @JoinColumn(name = "club_master_id")
    private User clubMaster;

    @Column(name = "member_number")
    private MemberNumber memberNumber;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "category")
    private Category category;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "location")
    private Location location;

    @Column(name = "image")
    private String image;

    @Column(name = "dues")
    private Long dues;

    @Lob
    @Column(name = "description")
    private String description;

    @Column(name = "delete_yn")
    private Boolean deleteYn;

    @Builder
    public Club(Long id, ClubName name, User clubMaster, MemberNumber memberNumber, Category category, Location location, String image, Long dues,  String description, Boolean deleteYn, LocalDateTime createdTime, LocalDateTime modifiedTime ) {
        this.id = id;
        this.name = name;
        this.clubMaster = clubMaster;
        this.memberNumber = memberNumber;
        this.category = category;
        this.location = location;
        this.image = image;
        this.dues = dues;
        this.description = description;
        this.deleteYn = deleteYn;
        this.createdTime = createdTime;
        this.modifiedTime = modifiedTime;
    }

    public Long id() {
        return id;
    }
}
