package com.naksam.clubserver.presentation;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.naksam.clubserver.service.ClubListResponse;
import com.naksam.clubserver.service.ClubService;

@RestController
@RequestMapping("/club")
public class ClubController {
    private ClubService clubService;

    @GetMapping("/test")
    public String test() {
        return "OK";
    }

    @GetMapping(params = {"location", "category"})
    public ResponseEntity<List<ClubListResponse>> search(
        @RequestParam String location,
        @RequestParam String category
    ){
        List<ClubListResponse> responses = clubService.search(location, category);
        return ResponseEntity.ok(responses);
    }
}
