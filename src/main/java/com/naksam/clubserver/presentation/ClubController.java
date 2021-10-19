package com.naksam.clubserver.presentation;

import com.naksam.clubserver.config.ExampleClient;
import com.naksam.clubserver.config.RetryClient;
import com.naksam.clubserver.dto.ClubListResponse;
import com.naksam.clubserver.dto.MemberPayload;
import com.naksam.clubserver.dto.RegisterClub;
import com.naksam.clubserver.service.ClubService;
import feign.Response;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ClubController {
    private ClubService clubService;
    private RetryClient exampleClient;

    @GetMapping(params = {"location", "category", "clubname"})
    public ResponseEntity<List<ClubListResponse>> search(
            @RequestParam String location,
            @RequestParam String category,
            @RequestParam @Nullable String clubname
    ) {
        List<ClubListResponse> responses = clubService.search(location, category, clubname);
        return ResponseEntity.ok(responses);
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerClub(@RequestBody RegisterClub registerClub) {
        Long id = clubService.registerClub(registerClub);
        return ResponseEntity.ok(id);
    }

    @PostMapping("/join/{clubId}")
    public ResponseEntity<?> joinClub(@PathVariable Long clubId) {
        clubService.join(clubId);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/feign")
    public ResponseEntity<?> feign() {
        Object response = exampleClient.request(new MemberPayload(1L, "test@test.com"));
        return ResponseEntity.ok(response);
    }
}
