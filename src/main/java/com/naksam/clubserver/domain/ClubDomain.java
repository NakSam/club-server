package com.naksam.clubserver.domain;

import com.naksam.clubserver.data.ClubQueryRepository;
import com.naksam.clubserver.data.ClubRepository;
import com.naksam.clubserver.domain.constants.Category;
import com.naksam.clubserver.domain.constants.Location;
import com.naksam.clubserver.dto.RegisterClub;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class ClubDomain {

    private ClubRepository clubRepository;

    private ClubQueryRepository clubQueryRepository;

    public List<Club> search(Location location, Category category, String clubname) {
        return clubQueryRepository.search(location, category, clubname);
    }

    public Long registerClub(RegisterClub registerClub) {
        Club club = registerClub.entity();
        return clubRepository.save(club).id();
    }
}
