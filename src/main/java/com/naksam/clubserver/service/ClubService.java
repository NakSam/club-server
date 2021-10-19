package com.naksam.clubserver.service;

import com.naksam.clubserver.domain.ClubDomain;
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

    public List<ClubListResponse> search(String location, String category) {
        return clubDomain.search(location, category)
                .stream()
                .map(ClubListResponse::new)
                .collect(Collectors.toList());
    }

    public void registerClub(RegisterClub registerClub) {
        clubDomain.registerClub(registerClub);
    }
}
