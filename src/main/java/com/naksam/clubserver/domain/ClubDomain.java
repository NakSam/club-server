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
import com.naksam.clubserver.dto.RegisterClub;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;

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

    public Long registerClub(RegisterClub registerClub) {
        Club club = registerClub.entity();
        return clubRepository.save(club)
                .id();
    }

    @Transactional
    public void join(Long clubId) {
        User user = User.builder()
                .name("test")
                .build();
        userRepository.save(user);

        Club club = clubRepository.findById(clubId)
                .orElseThrow(() -> new RuntimeException("클럽이 존재하지 않습니다"));

        ClubUser clubUser = ClubUser.builder()
                .club(club)
                .user(user)
                .build();

        clubUserRepository.save(clubUser);
    }
}
