package com.naksam.clubserver.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.naksam.clubserver.domain.ClubDomain;

@Service
public class ClubService {
    private final ClubDomain clubDomain;

    public ClubService(ClubDomain clubDomain) {
        this.clubDomain = clubDomain;
    }

    public List<ClubListResponse> search(String location, String category){
        return (List<ClubListResponse>)clubDomain.search(location, category).stream().map(ClubListResponse::new);
    }
}
