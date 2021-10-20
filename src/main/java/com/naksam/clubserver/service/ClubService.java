package com.naksam.clubserver.service;

import com.naksam.clubserver.common.HttpSupport;
import com.naksam.clubserver.domain.ClubDomain;
import com.naksam.clubserver.domain.constants.Category;
import com.naksam.clubserver.domain.constants.Location;
import com.naksam.clubserver.dto.ClubListResponse;
import com.naksam.clubserver.dto.JsonWebToken;
import com.naksam.clubserver.dto.MemberPayload;
import com.naksam.clubserver.dto.RegisterClub;
import com.naksam.clubserver.feign.AccountRetryClient;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ClubService {
    private ClubDomain clubDomain;
    private AccountRetryClient exampleClient;
    private static final String COOKIE_NAME = "naksam";

    public List<ClubListResponse> search(String location, String category, String clubname) {
        return clubDomain.search(Location.fromString(location), Category.fromString(category), clubname)
                .stream()
                .map(ClubListResponse::new)
                .collect(Collectors.toList());
    }

    public Long registerClub(RegisterClub registerClub) {
        return clubDomain.registerClub(registerClub);
    }

    public void join(Long clubId, HttpServletRequest req) {
        String token = HttpSupport.getCookie(req, COOKIE_NAME)
                .orElseThrow(() -> new RuntimeException("쿠키가 없습니다"))
                .getValue();

        MemberPayload memberPayload = exampleClient.findInfo(new JsonWebToken(token));

        clubDomain.join(clubId, memberPayload.getId());
    }
}
