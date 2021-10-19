package com.naksam.clubserver.data;

import static com.naksam.clubserver.domain.QClub.*;

import java.util.List;

import com.naksam.clubserver.domain.Club;
import com.naksam.clubserver.domain.constants.Category;
import com.naksam.clubserver.domain.constants.Location;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
@NoArgsConstructor
public class ClubQueryRepository{
     private JPAQueryFactory query;

     public List<Club> search(Location location, Category category, String clubname){
          return query.selectFrom(club)
                  .where(
                          locationEq(location),
                          categoryEq(category),
                          clubnameContains(clubname)
                  ).fetch();
     }

     private BooleanExpression clubnameContains(String clubname){
          if(clubname == null){
               return null;
          }
          return club.name.contains(clubname);
     }

     private BooleanExpression locationEq(Location location){
          if(location.isLocation("전체")){
               return null;
          }
          return club.location.eq(location);
     }

     private BooleanExpression categoryEq(Category category){
          if(category.isCategory("전체")){
               return null;
          }
          return club.category.eq(category);
     }

}
