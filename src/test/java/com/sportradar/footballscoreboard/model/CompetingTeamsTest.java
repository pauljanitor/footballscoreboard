package com.sportradar.footballscoreboard.model;


import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CompetingTeamsTest {

    @Test
    public void of_shouldCreateCompetingTeamsWhenAllValid() {
        // given
        Team homeTeam = Team.of("germany");
        Team awayTeam = Team.of("poland");

        // when
        CompetingTeams result = CompetingTeams.of(homeTeam, awayTeam);

        // then
        assertThat(result.getHomeTeam()).isEqualTo(homeTeam);
        assertThat(result.getAwayTeam()).isEqualTo(awayTeam);
    }
}