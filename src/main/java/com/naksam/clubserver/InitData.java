package com.naksam.clubserver;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.naksam.clubserver.domain.Club;
import com.naksam.clubserver.domain.constants.Category;
import com.naksam.clubserver.domain.constants.Location;
import com.naksam.clubserver.domain.objects.ClubName;
import com.naksam.clubserver.domain.objects.MemberNumber;

@Component
public class InitData {
    private final InitDataService initDataService;

    public InitData(InitDataService initDataService) {
        this.initDataService = initDataService;
    }

    @PostConstruct
    public void init() {
        initDataService.init();
    }

    @Component
    static class InitDataService {
        @PersistenceContext
        EntityManager em;

        @Transactional
        public void init() {
            Club club = Club.builder()
                    .name(new ClubName("KB 축구모임"))
                    .ownerId(1L)
                    .memberNumber(new MemberNumber(6))
                    .category(Category.SPORT)
                    .location(Location.GANGSEOGU)
                    .build();
            em.persist(club);

            Club club1 = Club.builder()
                    .name(new ClubName("KB 맛집탐방"))
                    .ownerId(2L)
                    .memberNumber(new MemberNumber(8))
                    .category(Category.EAT)
                    .location(Location.GANGBUKGU)
                    .build();
            em.persist(club1);

            Club club2 = Club.builder()
                    .name(new ClubName("KB 코딩스터디"))
                    .ownerId(3L)
                    .memberNumber(new MemberNumber(10))
                    .category(Category.STUDY)
                    .location(Location.GANGNAMGU)
                    .build();
            em.persist(club2);

            Club club3 = Club.builder()
                    .name(new ClubName("KB 야구단"))
                    .ownerId(4L)
                    .memberNumber(new MemberNumber(12))
                    .category(Category.SPORT)
                    .location(Location.GANGDONGGU)
                    .build();
            em.persist(club3);

        }
    }
}
