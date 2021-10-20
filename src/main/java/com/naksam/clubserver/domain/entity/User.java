package com.naksam.clubserver.domain.entity;

import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "users")
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    @Column(name = "name")
    private String email;

    private String name;

    @Builder
    public User(Long id, String email, String name) {
        this.id = id;
        this.email = email;
        this.name = name;
    }
}
