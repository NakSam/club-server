package com.naksam.clubserver.data;

import com.naksam.clubserver.domain.entity.Club;
import com.naksam.clubserver.domain.entity.ClubUser;
import com.naksam.clubserver.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClubUserRepository extends JpaRepository<ClubUser, Long> {
    Optional<ClubUser> findByClubAndUser(Club club, User user);
}
