package com.sportradar.footballscoreboard.validation;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

abstract class AbstractTeamsValidatorTest {
    protected abstract TeamsValidator provideTeamsValidator();

    @Test
    public void validate_shouldNotThrowExceptionWhenBothTeamsValid() {
        // given
        TeamsValidator validator = provideTeamsValidator();
        String homeTeamCountryName = "germany";
        String awayTeamCountryName = "poland";

        // when - then
        assertThatCode(() -> validator.validate(homeTeamCountryName, awayTeamCountryName))
                .doesNotThrowAnyException();
    }

    @Test
    public void validate_shouldThrowIllegalArgumentExceptionWhenHomeTeamIsNull() {
        // given
        TeamsValidator validator = provideTeamsValidator();
        String homeTeamCountryName = null;
        String awayTeamCountryName = "poland";

        // when - then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> validator.validate(homeTeamCountryName, awayTeamCountryName));
    }

    @Test
    public void validate_shouldThrowIllegalArgumentExceptionWhenAwayTeamIsNull() {
        // given
        TeamsValidator validator = provideTeamsValidator();
        String homeTeamCountryName = "poland";
        String awayTeamCountryName = null;

        // when - then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> validator.validate(homeTeamCountryName, awayTeamCountryName));
    }

    @Test
    public void validate_shouldThrowIllegalArgumentExceptionWhenHomeTeamIsEmpty() {
        // given
        TeamsValidator validator = provideTeamsValidator();
        String homeTeamCountryName = "";
        String awayTeamCountryName = "poland";

        // when - then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> validator.validate(homeTeamCountryName, awayTeamCountryName));
    }

    @Test
    public void validate_shouldThrowIllegalArgumentExceptionWhenAwayTeamIsEmpty() {
        // given
        TeamsValidator validator = provideTeamsValidator();
        String homeTeamCountryName = "poland";
        String awayTeamCountryName = "";

        // when - then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> validator.validate(homeTeamCountryName, awayTeamCountryName));
    }

    @Test
    public void validate_shouldThrowIllegalArgumentExceptionWhenHomeTeamToLong() {
        // given
        TeamsValidator validator = provideTeamsValidator();
        String homeTeamCountryName = "polandpolandpoland";
        String awayTeamCountryName = "germany";

        // when - then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> validator.validate(homeTeamCountryName, awayTeamCountryName));
    }

    @Test
    public void validate_shouldThrowIllegalArgumentExceptionWhenAwayTeamToLong() {
        // given
        TeamsValidator validator = provideTeamsValidator();
        String homeTeamCountryName = "germany";
        String awayTeamCountryName = "polandpolandpoland";

        // when - then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> validator.validate(homeTeamCountryName, awayTeamCountryName));
    }

    @Test
    public void validate_shouldThrowIllegalArgumentExceptionWhenHomeTeamContainsSpecialChars() {
        // given
        TeamsValidator validator = provideTeamsValidator();
        String homeTeamCountryName = "+*/=<>%^\"(){}[]";
        String awayTeamCountryName = "poland";

        // when - then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> validator.validate(homeTeamCountryName, awayTeamCountryName));
    }

    @Test
    public void validate_shouldThrowIllegalArgumentExceptionWhenAwayTeamContainsSpecialChars() {
        // given
        TeamsValidator validator = provideTeamsValidator();
        String homeTeamCountryName = "poland";
        String awayTeamCountryName = "+*/=<>%^\"(){}[]";

        // when - then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> validator.validate(homeTeamCountryName, awayTeamCountryName));
    }

    @Test
    public void validate_shouldThrowIllegalArgumentExceptionWhenTeamsAreEqual() {
        // given
        TeamsValidator validator = provideTeamsValidator();
        String homeTeamCountryName = "poland";
        String awayTeamCountryName = "poland";

        // when - then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> validator.validate(homeTeamCountryName, awayTeamCountryName));
    }
}
