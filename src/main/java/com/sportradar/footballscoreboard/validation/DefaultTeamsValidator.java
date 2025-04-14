package com.sportradar.footballscoreboard.validation;

import java.util.Objects;

public class DefaultTeamsValidator implements TeamsValidator {
    private static final String COUNTRY_NAME_PATTERN = "^[a-zA-Z.-]+$";
    private static final int MAX_COUNTRY_NAME_LENGTH = 15;

    @Override
    public void validate(String homeTeamCountryName, String awayTeamCountryName) {
        validateSingle(homeTeamCountryName);
        validateSingle(awayTeamCountryName);
        if(homeTeamCountryName.equals(awayTeamCountryName)) {
            throw new IllegalArgumentException("Country names are equal");
        }
    }

    private static void validateSingle(String countryName) {
        if (Objects.isNull(countryName) || countryName.isBlank()) {
            throw new IllegalArgumentException("Country name cannot be null or blank");
        }
        if (countryName.length() > MAX_COUNTRY_NAME_LENGTH) {
            throw new IllegalArgumentException("Country name must not exceed " + MAX_COUNTRY_NAME_LENGTH + " characters");
        }
        if (!countryName.matches(COUNTRY_NAME_PATTERN)) {
            throw new IllegalArgumentException("Invalid country name: " + countryName + ". Allowed characters: letters, '.', '-'");
        }
    }
}
