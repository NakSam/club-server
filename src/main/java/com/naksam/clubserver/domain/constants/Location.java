package com.naksam.clubserver.domain.constants;

import java.util.Arrays;

public enum Location {
    ALL("전체"),
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

    public Boolean isLocation(String locationName){
        return this.locationName.equals(locationName);
    }

    public static Location fromString(String locationName) {
        return Arrays.stream(values())
                .filter(v -> v.locationName.equals(locationName))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(String.format("잘못된 위치 : %s.", locationName)));
    }
}
