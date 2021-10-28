package com.naksam.clubserver.service;

import com.naksam.clubserver.common.HttpSupport;
import com.naksam.clubserver.domain.ClubDomain;
import com.naksam.clubserver.domain.constants.Category;
import com.naksam.clubserver.domain.constants.Location;
import com.naksam.clubserver.dto.*;
import com.naksam.clubserver.feign.AccountRetryClient;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
        return clubDomain.search(Location.fromString(location), Category.fromString(category), clubname);
    }

    public ClubDetailResponse showClubDetail(Long clubId){
        return clubDomain.getClubDetail(clubId);
    }

    public List<ClubListResponse> showMyClub(HttpServletRequest req) {
//        MemberPayload memberPayload = getMemberPayload(req);
//        return clubDomain.findMyClub(memberPayload.getId());
        return clubDomain.findMyClub(1L);
    }

    @Transactional
    public Long registerClub(RegisterClub registerClub, HttpServletRequest req) {
        MemberPayload memberPayload = getMemberPayload(req);
        return clubDomain.registerClub(registerClub, memberPayload);
    }

    @Transactional
    public void join(Long clubId, HttpServletRequest req) {
        MemberPayload memberPayload = getMemberPayload(req);
        clubDomain.join(clubId, memberPayload.getId());
    }

    @Transactional
    public void inviteMember(InviteMembers inviteMembers, HttpServletRequest req) {
        MemberPayload memberPayload = getMemberPayload(req);
        clubDomain.inviteMember(inviteMembers, memberPayload.getId());
    }

    private MemberPayload getMemberPayload(HttpServletRequest req) {
//        String token = HttpSupport.getCookie(req, COOKIE_NAME)
//                .orElseThrow(() -> new RuntimeException("쿠키가 없습니다"))
//                .getValue();

        String token = HttpSupport.getToken(req, COOKIE_NAME);

        return exampleClient.findInfo(new JsonWebToken(token));
    }

    public List<ClubListResponse> showNewClubs() {
        return clubDomain.getNewClubs();
    }
}
