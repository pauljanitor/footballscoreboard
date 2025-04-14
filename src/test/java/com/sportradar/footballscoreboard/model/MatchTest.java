package com.sportradar.footballscoreboard.model;

import org.junit.Test;

import java.time.Instant;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

public class MatchTest {

    @Test
    public void newGame_shouldCreateNewMatchWhenCountryNamesAreValid() {
        // given
        Team homeTeam = Team.of("germany");
        Team awayTeam = Team.of("poland");

        // when
        Match result = Match.newMatch(homeTeam, awayTeam);

        // then
        assertThat(result.getMatchId().getId()).isInstanceOf(UUID.class);
        assertThat(result.getCompetingTeams().getHomeTeam().getCountry().getName()).isEqualTo("Germany");
        assertThat(result.getCompetingTeams().getAwayTeam().getCountry().getName()).isEqualTo("Poland");
        assertThat(result.getScore().getHomeTeamScore()).isEqualTo(0);
        assertThat(result.getScore().getAwayTeamScore()).isEqualTo(0);
        assertThat(result.getDurationInfo().getStartedAt()).isBefore(Instant.now());
        assertThat(result.getDurationInfo().getFinishedAt()).isNull();
        assertThat(result.getCreatedAt()).isBefore(Instant.now());
    }

    @Test
    public void finishMatch_shouldSetFinishedAtForDurationTime() {
        // given
        Team homeTeam = Team.of("germany");
        Team awayTeam = Team.of("poland");
        Match match = Match.newMatch(homeTeam, awayTeam);

        assertThat(match.getMatchId().getId()).isInstanceOf(UUID.class);
        assertThat(match.getCompetingTeams().getHomeTeam()).isEqualTo(homeTeam);
        assertThat(match.getCompetingTeams().getAwayTeam()).isEqualTo(awayTeam);
        assertThat(match.getScore().getHomeTeamScore()).isEqualTo(0);
        assertThat(match.getScore().getAwayTeamScore()).isEqualTo(0);
        assertThat(match.getDurationInfo().getStartedAt()).isBefore(Instant.now());
        assertThat(match.getDurationInfo().getFinishedAt()).isNull();
        assertThat(match.getCreatedAt()).isBefore(Instant.now());
        // when
        match.finishMatch();

        // then
        assertThat(match.getMatchId().getId()).isInstanceOf(UUID.class);
        assertThat(match.getCompetingTeams().getHomeTeam()).isEqualTo(homeTeam);
        assertThat(match.getCompetingTeams().getAwayTeam()).isEqualTo(awayTeam);
        assertThat(match.getScore().getHomeTeamScore()).isEqualTo(0);
        assertThat(match.getScore().getAwayTeamScore()).isEqualTo(0);
        assertThat(match.getDurationInfo().getStartedAt()).isBefore(Instant.now());
        assertThat(match.getDurationInfo().getFinishedAt()).isAfter(match.getDurationInfo().getStartedAt());
        assertThat(match.getCreatedAt()).isBefore(Instant.now());
    }

    @Test
    public void updateScore_shouldUpdateHomeTeamScore() {
        // given
        Team homeTeam = Team.of("germany");
        Team awayTeam = Team.of("poland");
        Match match = Match.newMatch(homeTeam, awayTeam);
        assertThat(match.getMatchId().getId()).isInstanceOf(UUID.class);
        assertThat(match.getCompetingTeams().getHomeTeam()).isEqualTo(homeTeam);
        assertThat(match.getCompetingTeams().getAwayTeam()).isEqualTo(awayTeam);
        assertThat(match.getScore().getHomeTeamScore()).isEqualTo(0);
        assertThat(match.getScore().getAwayTeamScore()).isEqualTo(0);
        assertThat(match.getDurationInfo().getStartedAt()).isBefore(Instant.now());
        assertThat(match.getDurationInfo().getFinishedAt()).isNull();
        assertThat(match.getCreatedAt()).isBefore(Instant.now());

        // when
        match.updateScore(NewScore.of(1, 2));

        // then
        assertThat(match.getCompetingTeams().getHomeTeam()).isEqualTo(homeTeam);
        assertThat(match.getCompetingTeams().getAwayTeam()).isEqualTo(awayTeam);
        assertThat(match.getScore().getHomeTeamScore()).isEqualTo(1);
        assertThat(match.getScore().getAwayTeamScore()).isEqualTo(2);
        assertThat(match.getDurationInfo().getStartedAt()).isBefore(Instant.now());
        assertThat(match.getDurationInfo().getFinishedAt()).isNull();
        assertThat(match.getCreatedAt()).isBefore(Instant.now());
    }
}
