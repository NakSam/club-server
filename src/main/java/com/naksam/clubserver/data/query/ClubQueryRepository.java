package com.naksam.clubserver.data.query;

import com.naksam.clubserver.domain.constants.Category;
import com.naksam.clubserver.domain.constants.Location;
import com.naksam.clubserver.dto.ClubDetailResponse;
import com.naksam.clubserver.dto.ClubListResponse;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.naksam.clubserver.domain.entity.QClub.club;
import static com.naksam.clubserver.domain.entity.QClubUser.clubUser;

@Repository
@AllArgsConstructor
public class ClubQueryRepository {
    private JPAQueryFactory query;

    public ClubDetailResponse findClubDetail(Long clubId) {
        return query.select(Projections.constructor(ClubDetailResponse.class,
                        club.id,
                        club.name,
                        club.clubMaster.name,
                        club.memberNumber,
                        clubUser.count(),
                        club.category,
                        club.location,
                        club.image,
                        club.dues,
                        club.description
                ))
                .from(club)
                .where(clubIdEq(clubId))
                .join(clubUser)
                .on(club.id.eq(clubUser.id))
                .groupBy(club.id, club.name, club.memberNumber, club.category, club.location, club.image
                )
                .fetchFirst();
    }

    public List<ClubListResponse> search(Location location, Category category, String clubName) {
        return query.select(Projections.constructor(ClubListResponse.class,
                        club.id,
                        club.name,
                        club.memberNumber,
                        club.category,
                        club.location,
                        club.image,
                        clubUser.count()
                        ))
                .from(club)
                .join(clubUser)
                .on(club.eq(clubUser.club))
                .groupBy(club.id, club.name, club.memberNumber, club.category, club.location, club.image
                )
                .where(
                        locationEq(location),
                        categoryEq(category),
                        clubNameContains(clubName)
                )
                .orderBy(club.createdTime.desc())
                .fetch();
    }

    public List<ClubListResponse> findByClub(Long id) {
        return query.select(Projections.constructor(
                                ClubListResponse.class,
                                club.id,
                                club.name,
                                club.memberNumber,
                                club.category,
                                club.location,
                                club.image,
                                clubUser.count()
                        )
                )
                .from(club)
                .join(clubUser)
                .on(club.eq(clubUser.club))
                .groupBy(clubUser)
                .where(clubUserUserEq(id))
                .fetch();
    }

    public List<ClubListResponse> findNewClubs() {
        return query.select(Projections.constructor(
                                ClubListResponse.class,
                                club.id,
                                club.name,
                                club.memberNumber,
                                club.category,
                                club.location,
                                club.image,
                                clubUser.count()
                        )
                )
                .from(club)
                .join(clubUser)
                .on(club.eq(clubUser.club))
                .groupBy(club.id, club.name, club.memberNumber, club.category, club.location, club.image
                )
                .orderBy(club.createdTime.desc())
                .limit(5)
                .fetch();
    }

    private BooleanExpression clubUserUserEq(Long id) {
        return clubUser.user.id.eq(id);
    }

    private BooleanExpression clubIdEq(Long clubId) {
        return club.id.eq(clubId);
    }

    private BooleanExpression clubNameContains(String clubName) {
        if (clubName == null) {
            return null;
        }
        return club.name.name.contains(clubName);
    }

    private BooleanExpression locationEq(Location location) {
        if (location.isLocation("전체")) {
            return null;
        }
        return club.location.eq(location);
    }

    private BooleanExpression categoryEq(Category category) {
        if (category.isCategory("전체")) {
            return null;
        }
        return club.category.eq(category);
    }
}
