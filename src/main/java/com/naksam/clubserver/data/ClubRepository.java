package com.naksam.clubserver.data;


import org.springframework.data.jpa.repository.JpaRepository;

import com.naksam.clubserver.domain.Club;

public interface ClubRepository extends JpaRepository<Club, Long> {
}
