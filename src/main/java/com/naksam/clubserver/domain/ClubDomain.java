package com.naksam.clubserver.domain;

import com.naksam.clubserver.data.ClubRepository;
import com.naksam.clubserver.dto.RegisterClub;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class ClubDomain {

    private ClubRepository clubRepository;

    public List<Club> search(String location, String category) {
        return clubRepository.findAllByCategoryAndLocation(location, category);
    }

    public void registerClub(RegisterClub registerClub) {
        Club club = registerClub.entity();
        clubRepository.save(club);
    }
}
