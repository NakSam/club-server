package com.naksam.clubserver.domain.constants;

import java.util.Arrays;
import java.util.Objects;

public enum Category {
    ALL("전체"),
    SPORT("스포츠"),
    STUDY("스터디"),
    EAT("맛집탐방");

    private final String categoryName;

    Category(String categoryName){ this.categoryName = categoryName; }

    public String getCategoryName(){
        return categoryName;
    }

    public static Category fromString(String categoryName) {
        return Arrays.stream(values())
                .filter(v -> v.categoryName.equals(categoryName))
                .findFirst()
                .orElseThrow(() ->
                        new IllegalArgumentException(
                                String.format("잘못된 카테고리 : %s.", categoryName)));
    }

    public boolean isCategory(String categoryName) {
        return this.categoryName.equals(categoryName);
    }
}
