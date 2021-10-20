package com.naksam.clubserver.presentation;

import com.naksam.clubserver.dto.ClubDetailResponse;
import com.naksam.clubserver.dto.ClubListResponse;
import com.naksam.clubserver.dto.RegisterClub;
import com.naksam.clubserver.dto.*;
import com.naksam.clubserver.service.ClubService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ClubController {
    private ClubService clubService;

    @GetMapping(params = {"location", "category", "clubname"})
    public ResponseEntity<List<ClubListResponse>> search(
            @RequestParam String location,
            @RequestParam String category,
            @RequestParam @Nullable String clubname
    ) {
        List<ClubListResponse> responses = clubService.search(location, category, clubname);
        return ResponseEntity.ok(responses);
    }

    @GetMapping("/{clubId}")
    public ResponseEntity<ClubDetailResponse> showClubDetail(@PathVariable Long clubId){
        ClubDetailResponse response = clubService.showClubDetail(clubId);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/myClub")
    public ResponseEntity<?> showByClubs(HttpServletRequest req) {
        List<ClubListResponse> responses =clubService.showByClub(req);
        return ResponseEntity.ok(responses);
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerClub(@RequestBody RegisterClub registerClub) {
        Long id = clubService.registerClub(registerClub);
        return ResponseEntity.ok(id);
    }

    @PostMapping("/join/{clubId}")
    public ResponseEntity<?> joinClub(@PathVariable Long clubId, HttpServletRequest req) {
        clubService.join(clubId, req);
        return ResponseEntity.ok()
                .build();
    }

    @PostMapping("/invite")
    public ResponseEntity<?> inviteMember(@RequestBody InviteMembers inviteMembers, HttpServletRequest req) {
        clubService.inviteMember(inviteMembers, req);
        return ResponseEntity.ok()
                .build();
    }
}
