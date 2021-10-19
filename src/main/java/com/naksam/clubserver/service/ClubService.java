package com.naksam.clubserver.service;

import com.naksam.clubserver.domain.ClubDomain;
import com.naksam.clubserver.domain.constants.Category;
import com.naksam.clubserver.domain.constants.Location;
import com.naksam.clubserver.dto.ClubListResponse;
import com.naksam.clubserver.dto.RegisterClub;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ClubService {
    private ClubDomain clubDomain;

    public List<ClubListResponse> search(String location, String category, String clubname) {
        return clubDomain.search(Location.fromString(location), Category.fromString(category), clubname)
                .stream()
                .map(ClubListResponse::new)
                .collect(Collectors.toList());
    }

    public Long registerClub(RegisterClub registerClub) {
        return clubDomain.registerClub(registerClub);
    }
}
