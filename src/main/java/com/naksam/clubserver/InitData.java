//package com.naksam.clubserver;
//
//import com.naksam.clubserver.domain.constants.Category;
//import com.naksam.clubserver.domain.constants.Location;
//import com.naksam.clubserver.domain.entity.Club;
//import com.naksam.clubserver.domain.entity.ClubUser;
//import com.naksam.clubserver.domain.entity.User;
//import com.naksam.clubserver.domain.objects.ClubName;
//import com.naksam.clubserver.domain.objects.MemberNumber;
//import org.springframework.stereotype.Component;
//import org.springframework.transaction.annotation.Transactional;
//
//import javax.annotation.PostConstruct;
//import javax.persistence.EntityManager;
//import javax.persistence.PersistenceContext;
//
//@Component
//public class InitData {
//    private final InitDataService initDataService;
//
//    public InitData(InitDataService initDataService) {
//        this.initDataService = initDataService;
//    }
//
//    @PostConstruct
//    public void init() {
//        initDataService.init();
//    }
//
//    @Component
//    static class InitDataService {
//        @PersistenceContext
//        EntityManager em;
//
//        @Transactional
//        public void init() {
//            User user1 = User.builder()
//                    .name("박준형")
//                    .email("xcq@google.com")
//                    .build();
//            em.persist(user1);
//
//            User user2 = User.builder()
//                    .name("강민형")
//                    .email("jhjd@google.com")
//                    .build();
//            em.persist(user2);
//
//            User user3 = User.builder()
//                    .name("김형준")
//                    .email("zxcasd@google.com")
//                    .build();
//            em.persist(user3);
//
//            User user4 = User.builder()
//                    .name("박용수")
//                    .email("asddqw@google.com")
//                    .build();
//            em.persist(user4);
//
//            User user5 = User.builder()
//                    .name("이서라")
//                    .email("cxvxcv@google.com")
//                    .build();
//            em.persist(user5);
//
//            User user6 = User.builder()
//                    .name("정다솜")
//                    .email("asdadsasdqw@google.com")
//                    .build();
//            em.persist(user6);
//
//            Club club = Club.builder()
//                    .name(new ClubName("KB 축구모임"))
//                    .clubMaster(user1)
//                    .memberNumber(new MemberNumber(6))
//                    .category(Category.SPORT)
//                    .location(Location.GANGSEOGU)
//                    .image("https://naksam.s3.ap-northeast-2.amazonaws.com/img/gym_1920.jpg")
//                    .dues(3000L)
//                    .description("KB 임직원 축구 동호회입니다. 나이, 실력 상관없습니다!! 축구를 좋아하시는 분이면 환영합니다!")
//                    .deleteYn(false)
//                    .build();
//            em.persist(club);
//
//            ClubUser clubUser = ClubUser.builder()
//                    .club(club)
//                    .user(user1)
//                    .build();
//            em.persist(clubUser);
//
//            Club club1 = Club.builder()
//                    .name(new ClubName("KB 맛집탐방"))
//                    .clubMaster(user2)
//                    .memberNumber(new MemberNumber(8))
//                    .category(Category.EAT)
//                    .location(Location.GANGBUKGU)
//                    .image("https://naksam.s3.ap-northeast-2.amazonaws.com/img/platter_1920.jpg")
//                    .dues(5000L)
//                    .description("KB 맛집탐방 모임입니다. 주 1회씩 다양한 맛집을 다니면서 스트레스 풀 사람~")
//                    .deleteYn(false)
//                    .build();
//            em.persist(club1);
//
//            ClubUser clubUser1 = ClubUser.builder()
//                    .club(club1)
//                    .user(user2)
//                    .build();
//            em.persist(clubUser1);
//
//            Club club2 = Club.builder()
//                    .name(new ClubName("KB 코딩스터디"))
//                    .clubMaster(user3)
//                    .memberNumber(new MemberNumber(10))
//                    .category(Category.STUDY)
//                    .location(Location.GANGNAMGU)
//                    .image("https://naksam.s3.ap-northeast-2.amazonaws.com/img/books_1920.jpg")
//                    .dues(10000L)
//                    .description("KB 코딩스터디입니다. 주 1회씩 다양한 알고리즘 문제풀이를 통해 코딩 역량을 쌓으실 분, 공부에 열정적이신 분 가입 신청해주세요~")
//                    .deleteYn(false)
//                    .build();
//            em.persist(club2);
//
//            ClubUser clubUser2 = ClubUser.builder()
//                    .club(club2)
//                    .user(user3)
//                    .build();
//            em.persist(clubUser2);
//
//            Club club3 = Club.builder()
//                    .name(new ClubName("KB 야구단"))
//                    .clubMaster(user4)
//                    .memberNumber(new MemberNumber(12))
//                    .category(Category.SPORT)
//                    .location(Location.GANGDONGGU)
//                    .image("https://naksam.s3.ap-northeast-2.amazonaws.com/img/gym_1920.jpg")
//                    .dues(10000L)
//                    .description("KB 야구단!! 나이, 실력 상관없습니다!! 야구를 좋아하시는 분이면 환영합니다!")
//                    .deleteYn(false)
//                    .build();
//            em.persist(club3);
//
//            ClubUser clubUser3 = ClubUser.builder()
//                    .club(club3)
//                    .user(user4)
//                    .build();
//            em.persist(clubUser3);
//
//            User user = User.builder()
//                    .name("tester")
//                    .email("test@test.com")
//                    .build();
//
//            em.persist(user);
//
//            Club club4 = Club.builder()
//                    .name(new ClubName("KB 맛집탐방"))
//                    .clubMaster(user)
//                    .memberNumber(new MemberNumber(8))
//                    .category(Category.EAT)
//                    .location(Location.GANGBUKGU)
//                    .image("https://naksam.s3.ap-northeast-2.amazonaws.com/img/platter_1920.jpg")
//                    .dues(5000L)
//                    .description("KB 맛집탐방 모임입니다. 주 1회씩 다양한 맛집을 다니면서 스트레스 풀 사람~")
//                    .deleteYn(false)
//                    .build();
//            em.persist(club4);
//        }
//    }
//}
