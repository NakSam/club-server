package com.naksam.clubserver.data;

import com.naksam.clubserver.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
