package com.naksam.clubserver.domain;

import com.naksam.clubserver.domain.constants.Category;
import com.naksam.clubserver.domain.constants.Location;
import com.naksam.clubserver.domain.objects.ClubName;
import com.naksam.clubserver.domain.objects.MemberNumber;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@NoArgsConstructor
@Getter
public class Club implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "club_id")
    private Long id;

    private ClubName name;

    private Long ownerId;

    private MemberNumber memberNumber;

    @Enumerated(value = EnumType.STRING)
    private Category category;

    @Enumerated(value = EnumType.STRING)
    private Location location;

    @Builder
    public Club(Long id, ClubName name, Long ownerId, MemberNumber memberNumber, Category category, Location location) {
        this.id = id;
        this.name = name;
        this.ownerId = ownerId;
        this.memberNumber = memberNumber;
        this.category = category;
        this.location = location;
    }

    public Long id() {
        return id;
    }
}
