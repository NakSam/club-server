package com.naksam.clubserver.data.query;

import com.naksam.clubserver.domain.constants.Category;
import com.naksam.clubserver.domain.constants.Location;
import com.naksam.clubserver.domain.entity.Club;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.naksam.clubserver.domain.entity.QClub.club;

@Repository
@AllArgsConstructor
public class ClubQueryRepository {
    private JPAQueryFactory query;

    public List<Club> search(Location location, Category category, String clubName) {
        return query.selectFrom(club)
                .where(
                        locationEq(location),
                        categoryEq(category),
                        clubnameContains(clubName)
                )
                .fetch();
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
