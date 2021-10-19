package com.naksam.clubserver.domain;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.naksam.clubserver.data.ClubRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Component
@AllArgsConstructor
@NoArgsConstructor
public class ClubDomain {

    private ClubRepository clubRepository;


    public List<Club> search(String location, String category) {
        return clubRepository.findAllByCategoryAndLocation(location, category);
    }
}
