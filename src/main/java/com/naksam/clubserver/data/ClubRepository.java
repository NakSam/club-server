package com.naksam.clubserver.data;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.naksam.clubserver.domain.entity.Club;

public interface ClubRepository extends JpaRepository<Club, Long> {
}
