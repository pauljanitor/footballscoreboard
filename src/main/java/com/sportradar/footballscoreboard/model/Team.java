package com.sportradar.footballscoreboard.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.apache.commons.text.WordUtils;

import java.util.Objects;

@Getter
@RequiredArgsConstructor
public class Team {
    private final Country country;

    public static Team of(String countryName) {
        return new Team(Country.of(WordUtils.capitalizeFully(countryName)));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Team team = (Team) o;

        String thisCountryName = this.country != null ? this.country.getName() : null;
        String otherCountryName = team.country != null ? team.country.getName() : null;

        return Objects.equals(thisCountryName, otherCountryName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(country != null ? country.getName() : null);
    }


}
