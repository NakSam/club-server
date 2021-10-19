package com.naksam.clubserver.domain;

import java.util.Arrays;

public enum Location {
    GANGNAMGU("강남구"),
    GANGDONGGU("강동구"),
    GANGSEOGU("강서구"),
    GANGBUKGU("강북구"),
    JUNGGU("중구");

    private final String locationName;

    Location(String locationName) {
        this.locationName = locationName;
    }

    public String getLocationName() {
        return locationName;
    }

    public static Location fromString(String locationName) {
        return Arrays.stream(values())
                .filter(v -> v.locationName.equals(locationName))
                .findFirst()
                .orElseThrow(() ->
                        new IllegalArgumentException(
                                String.format("잘못된 위치 : %s.", locationName)));
    }
}
