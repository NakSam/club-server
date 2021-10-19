package com.naksam.clubserver.data;

import com.naksam.clubserver.domain.QClub;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
@NoArgsConstructor
public class ClubQueryRepository {
    private JPAQueryFactory query;
}
