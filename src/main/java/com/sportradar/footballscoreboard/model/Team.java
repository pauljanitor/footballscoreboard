package com.sportradar.footballscoreboard.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.apache.commons.text.WordUtils;

@Getter
@RequiredArgsConstructor
public class Team {
    private final Country country;

    public static Team of(String countryName) {
        return new Team(Country.of(WordUtils.capitalizeFully(countryName)));
    }

}
