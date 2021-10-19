package com.naksam.clubserver.domain;

import com.naksam.clubserver.data.ClubRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
@NoArgsConstructor
public class ClubDomain {

    private ClubRepository clubRepository;

    public List<Club> search(String location, String category) {
        return clubRepository.findAllByCategoryAndLocation(location, category);
    }
}
