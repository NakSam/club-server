package com.naksam.clubserver.domain;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.naksam.clubserver.data.ClubRepository;

@Component
public class ClubDomain {
    @Autowired
    private final ClubRepository clubRepository;

    public ClubDomain(ClubRepository clubRepository) {
        this.clubRepository = clubRepository;
    }

    public List<Club> search(String location, String category) {
        return clubRepository.findAllByCategoryAndLocation(location, category);
    }
}
