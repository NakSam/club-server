package com.naksam.clubserver.data.query;

import com.naksam.clubserver.domain.constants.Category;
import com.naksam.clubserver.domain.constants.Location;
import com.naksam.clubserver.domain.entity.Club;
import com.naksam.clubserver.dto.ClubDetailResponse;
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

    public ClubDetailResponse findClubDetail(Long clubId){
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
                .join(clubUser).on(club.id.eq(clubUser.id))
                .fetchFirst();
    }

    public List<Club> search(Location location, Category category, String clubName) {
        return query.selectFrom(club)
                .where(
                        locationEq(location),
                        categoryEq(category),
                        clubnameContains(clubName)
                )
                .fetch();
    }

    private BooleanExpression clubIdEq(Long clubId) {
        return club.id.eq(clubId);
    }

    private BooleanExpression clubnameContains(String clubName) {
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
