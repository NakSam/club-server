package com.naksam.clubserver.domain;

import com.naksam.clubserver.data.ClubRepository;
import com.naksam.clubserver.data.ClubUserRepository;
import com.naksam.clubserver.data.UserRepository;
import com.naksam.clubserver.data.query.ClubQueryRepository;
import com.naksam.clubserver.domain.constants.Category;
import com.naksam.clubserver.domain.constants.Location;
import com.naksam.clubserver.domain.entity.Club;
import com.naksam.clubserver.domain.entity.ClubUser;
import com.naksam.clubserver.domain.entity.User;
import com.naksam.clubserver.dto.ClubDetailResponse;
import com.naksam.clubserver.dto.ClubListResponse;
import com.naksam.clubserver.dto.InviteMembers;
import com.naksam.clubserver.dto.RegisterClub;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Component
@AllArgsConstructor
public class ClubDomain {

    private final ClubRepository clubRepository;

    private final ClubQueryRepository clubQueryRepository;

    private final UserRepository userRepository;

    private final ClubUserRepository clubUserRepository;

    public List<Club> search(Location location, Category category, String clubName) {
        return clubQueryRepository.search(location, category, clubName);
    }

    public ClubDetailResponse getClubDetail(Long clubId){
        return clubQueryRepository.findClubDetail(clubId);
    }

    public List<ClubListResponse> findMyClub(Long id) {
        return clubQueryRepository.findByClub(id);
    }

    public Long registerClub(RegisterClub registerClub) {
        Club club = registerClub.entity();
        return clubRepository.save(club)
                .id();
    }

    public void join(Long clubId, Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("등록된 사용자가 없습니다"));

        Club club = clubRepository.findById(clubId)
                .orElseThrow(() -> new RuntimeException("클럽이 존재하지 않습니다"));

        registerClubUser(club, user);
    }

    public void inviteMember(InviteMembers inviteMembers, Long ownerId) {
        Club club = clubRepository.findById(inviteMembers.getClubId())
                .orElseThrow(() -> new RuntimeException("클럽이 존재하지 않습니다"));

        club.checkOwner(ownerId);

        List<User> users = userRepository.findAllByEmailIn(inviteMembers.getEmails());

        for (User user : users) {
            registerClubUser(club, user);
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
}
