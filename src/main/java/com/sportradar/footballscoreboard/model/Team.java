package com.sportradar.footballscoreboard.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class Team {
    private final Country country;

    public static Team of(String countryName) {
        return null;
    }

}
