package com.naksam.clubserver;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class TestEntity {
    @Id
    private Long id;

    public TestEntity() {
    }

    public TestEntity(Long id) {
        this.id = id;
    }
}
