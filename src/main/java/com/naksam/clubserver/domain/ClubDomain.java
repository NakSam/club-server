package com.naksam.clubserver.domain;

import com.google.gson.Gson;
import com.naksam.clubserver.data.ClubRepository;
import com.naksam.clubserver.data.ClubUserRepository;
import com.naksam.clubserver.data.UserRepository;
import com.naksam.clubserver.data.query.ClubQueryRepository;
import com.naksam.clubserver.domain.constants.Category;
import com.naksam.clubserver.domain.constants.Location;
import com.naksam.clubserver.domain.entity.Club;
import com.naksam.clubserver.domain.entity.ClubUser;
import com.naksam.clubserver.domain.entity.User;
import com.naksam.clubserver.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class ClubDomain {

    private final ClubRepository clubRepository;
    private final ClubQueryRepository clubQueryRepository;
    private final UserRepository userRepository;
    private final ClubUserRepository clubUserRepository;
    private final KafkaTemplate<String, String> kafkaTemplate;

    @Value("${bootcamp.club.join}")
    private String join;

    @Value("${bootcamp.club.create}")
    private String create;

    private final Gson gson = new Gson();

    public List<ClubListResponse> search(Location location, Category category, String clubName) {
        return clubQueryRepository.search(location, category, clubName);
    }

    public ClubDetailResponse getClubDetail(Long clubId) {
        return clubQueryRepository.findClubDetail(clubId);
    }

    public List<ClubListResponse> findMyClub(Long id) {
        return clubQueryRepository.findByClub(id);
    }

    @Transactional
    public Long registerClub(RegisterClub registerClub, MemberPayload memberPayload) {
        User user = userRepository.findById(memberPayload.getId())
                .orElseThrow(() -> new RuntimeException("등록된 사용자가 없습니다"));

        Club club = registerClub.entity()
                .mapMaster(user);

        clubRepository.save(club);

        registerClubUser(club, user);
        transferCreateMessage(new CreateClubMessage(user.id(), club.id(), club.name(), registerClub.getAmount()));

        return club.id();
    }

    @Transactional
    public void join(Long clubId, Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("등록된 사용자가 없습니다"));

        Club club = clubRepository.findById(clubId)
                .orElseThrow(() -> new RuntimeException("클럽이 존재하지 않습니다"));

        registerClubUser(club, user);
        transferJoinMessage(new JoinClubMessage(user.id(), club.id()));
    }

    @Transactional
    public void inviteMember(InviteMembers inviteMembers, Long ownerId) {
        Club club = clubRepository.findById(inviteMembers.getClubId())
                .orElseThrow(() -> new RuntimeException("클럽이 존재하지 않습니다"));

        club.checkOwner(ownerId);

        List<User> users = userRepository.findAllByEmailIn(inviteMembers.getEmails());

        for (User user : users) {
            registerClubUser(club, user);
            transferJoinMessage(new JoinClubMessage(user.id(), club.id()));
        }
    }

    private void registerClubUser(Club club, User user) {
        Optional<ClubUser> clubUser = clubUserRepository.findByClubAndUser(club, user);
        if (clubUser.isPresent()) {
            return;
        }

        clubUserRepository.save(ClubUser.builder()
                .club(club)
                .user(user)
                .build()
        );
    }

    public List<ClubListResponse> getNewClubs() {
        return clubQueryRepository.findNewClubs();
    }

    private void transferCreateMessage(CreateClubMessage createClubMessage) {
        System.out.println("kafka send");
        try {
            String message = gson.toJson(createClubMessage);
            kafkaTemplate.send(create, message);
        } catch (Exception e) {
            System.out.println("ERROR");
            throw new RuntimeException(e);
        }
    }

    private void transferJoinMessage(JoinClubMessage joinClubMessage) {
        System.out.println("kafka send");
        try {
            String message = gson.toJson(joinClubMessage);
            kafkaTemplate.send(join, message);
        } catch (Exception e) {
            System.out.println("ERROR");
            throw new RuntimeException(e);
        }
    }
}
