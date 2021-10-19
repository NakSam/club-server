package com.naksam.clubserver.domain;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.naksam.clubserver.data.ClubRepository;

@Component
public class ClubDomain {

    public ClubDomain() {
    }

    public ClubDomain(ClubRepository clubRepository) {
        this.clubRepository = clubRepository;
    }

    private ClubRepository clubRepository;


    public List<Club> search(String location, String category) {
        return clubRepository.findAllByCategoryAndLocation(location, category);
    }
}
