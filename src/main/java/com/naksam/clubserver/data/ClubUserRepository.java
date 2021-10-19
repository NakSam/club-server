package com.naksam.clubserver.data;

import com.naksam.clubserver.domain.entity.ClubUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClubUserRepository extends JpaRepository<ClubUser, Long> {
}
