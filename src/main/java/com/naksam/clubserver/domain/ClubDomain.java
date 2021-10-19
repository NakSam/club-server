package com.naksam.clubserver.domain;

import com.naksam.clubserver.data.ClubRepository;
import com.naksam.clubserver.dto.RegisterClub;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class ClubDomain {

    private ClubRepository clubRepository;

    public List<Club> search(String location, String category) {
        return clubRepository.findAllByCategoryAndLocation(location, category);
    }

    public Long registerClub(RegisterClub registerClub) {
        Club club = registerClub.entity();
        return clubRepository.save(club).id();
    }
}
