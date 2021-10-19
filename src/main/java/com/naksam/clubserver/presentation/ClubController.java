package com.naksam.clubserver.presentation;

import com.naksam.clubserver.dto.ClubListResponse;
import com.naksam.clubserver.dto.RegisterClub;
import com.naksam.clubserver.service.ClubService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class ClubController {
    private ClubService clubService;

    @GetMapping(params = {"location", "category"})
    public ResponseEntity<List<ClubListResponse>> search(
            @RequestParam String location,
            @RequestParam String category
    ) {
        List<ClubListResponse> responses = clubService.search(location, category);
        return ResponseEntity.ok(responses);
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerClub(@RequestBody RegisterClub registerClub) {
        Long id = clubService.registerClub(registerClub);
        return ResponseEntity.ok(id);
    }
}