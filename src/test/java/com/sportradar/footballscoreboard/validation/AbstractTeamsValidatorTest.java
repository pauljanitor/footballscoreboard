package com.sportradar.footballscoreboard.validation;

import com.sportradar.footballscoreboard.model.Team;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

abstract class AbstractTeamsValidatorTest {
    protected abstract TeamsValidator provideTeamsValidator();

    @Test
    public void validate_shouldNotThrowExceptionWhenBothTeamsValid() {
        // given
        TeamsValidator validator = provideTeamsValidator();
        Team homeTeamCountryName = Team.of("germany");
        Team awayTeamCountryName = Team.of("poland");

        // when - then
        assertThatCode(() -> validator.validate(homeTeamCountryName, awayTeamCountryName))
                .doesNotThrowAnyException();
    }

    @Test
    public void validate_shouldThrowIllegalArgumentExceptionWhenHomeTeamIsNull() {
        // given
        TeamsValidator validator = provideTeamsValidator();
        Team homeTeamCountryName = null;
        Team awayTeamCountryName = Team.of("poland");

        // when - then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> validator.validate(homeTeamCountryName, awayTeamCountryName));
    }

    @Test
    public void validate_shouldThrowIllegalArgumentExceptionWhenAwayTeamIsNull() {
        // given
        TeamsValidator validator = provideTeamsValidator();
        Team homeTeamCountryName = Team.of("poland");
        Team awayTeamCountryName = null;

        // when - then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> validator.validate(homeTeamCountryName, awayTeamCountryName));
    }

    @Test
    public void validate_shouldThrowIllegalArgumentExceptionWhenHomeTeamIsEmpty() {
        // given
        TeamsValidator validator = provideTeamsValidator();
        Team homeTeamCountryName = Team.of("");
        Team awayTeamCountryName = Team.of("poland");

        // when - then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> validator.validate(homeTeamCountryName, awayTeamCountryName));
    }

    @Test
    public void validate_shouldThrowIllegalArgumentExceptionWhenAwayTeamIsEmpty() {
        // given
        TeamsValidator validator = provideTeamsValidator();
        Team homeTeamCountryName = Team.of("poland");
        Team awayTeamCountryName = Team.of("");

        // when - then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> validator.validate(homeTeamCountryName, awayTeamCountryName));
    }

    @Test
    public void validate_shouldThrowIllegalArgumentExceptionWhenHomeTeamToLong() {
        // given
        TeamsValidator validator = provideTeamsValidator();
        Team homeTeamCountryName = Team.of("polandpolandpoland");
        Team awayTeamCountryName = Team.of("germany");

        // when - then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> validator.validate(homeTeamCountryName, awayTeamCountryName));
    }

    @Test
    public void validate_shouldThrowIllegalArgumentExceptionWhenAwayTeamToLong() {
        // given
        TeamsValidator validator = provideTeamsValidator();
        Team homeTeamCountryName = Team.of("germany");
        Team awayTeamCountryName = Team.of("polandpolandpoland");

        // when - then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> validator.validate(homeTeamCountryName, awayTeamCountryName));
    }

    @Test
    public void validate_shouldThrowIllegalArgumentExceptionWhenHomeTeamContainsSpecialChars() {
        // given
        TeamsValidator validator = provideTeamsValidator();
        Team homeTeamCountryName = Team.of("+*/=<>%^\"(){}[]");
        Team awayTeamCountryName = Team.of("poland");

        // when - then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> validator.validate(homeTeamCountryName, awayTeamCountryName));
    }

    @Test
    public void validate_shouldThrowIllegalArgumentExceptionWhenAwayTeamContainsSpecialChars() {
        // given
        TeamsValidator validator = provideTeamsValidator();
        Team homeTeamCountryName = Team.of("poland");
        Team awayTeamCountryName = Team.of("+*/=<>%^\"(){}[]");

        // when - then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> validator.validate(homeTeamCountryName, awayTeamCountryName));
    }

    @Test
    public void validate_shouldThrowIllegalArgumentExceptionWhenTeamsAreEqual() {
        // given
        TeamsValidator validator = provideTeamsValidator();
        Team homeTeamCountryName = Team.of("poland");
        Team awayTeamCountryName = Team.of("poland");

        // when - then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> validator.validate(homeTeamCountryName, awayTeamCountryName));
    }
}
