package com.naksam.clubserver.data;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.naksam.clubserver.domain.Club;
import com.naksam.clubserver.domain.constants.Category;
import com.naksam.clubserver.domain.constants.Location;

public interface ClubRepository extends JpaRepository<Club, Long> {
    List<Club> findAllByLocationAndCategory(Location location, Category category);
}
