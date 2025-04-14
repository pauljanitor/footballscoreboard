package com.sportradar.footballscoreboard.validation;

import com.sportradar.footballscoreboard.model.Team;

import java.util.Objects;

public class DefaultTeamsValidator implements TeamsValidator {
    private static final String COUNTRY_NAME_PATTERN = "^[a-zA-Z.-]+$";
    private static final int MAX_COUNTRY_NAME_LENGTH = 15;

    @Override
    public void validate(Team homeTeam, Team awayTeam) {
        if (Objects.isNull(homeTeam) || Objects.isNull(awayTeam) || homeTeam.equals(awayTeam)) {
            throw new IllegalArgumentException("Country names are equal");
        }
        validateSingle(homeTeam);
        validateSingle(awayTeam);
    }

    private static void validateSingle(Team team) {
        if (Objects.isNull(team.getCountry())) {
            throw new IllegalArgumentException("Country cannot be null");
        }
        String countryName = team.getCountry().getName();
        if (Objects.isNull(team) || Objects.isNull(countryName) || countryName.isBlank()) {
            throw new IllegalArgumentException("Country name cannot be null or blank");
        }
        if (countryName.length() > MAX_COUNTRY_NAME_LENGTH) {
            throw new IllegalArgumentException("Country name must not exceed " + MAX_COUNTRY_NAME_LENGTH + " characters");
        }
        if (!countryName.matches(COUNTRY_NAME_PATTERN)) {
            throw new IllegalArgumentException("Invalid country name: " + team + ". Allowed characters: letters, '.', '-'");
        }
    }
}
