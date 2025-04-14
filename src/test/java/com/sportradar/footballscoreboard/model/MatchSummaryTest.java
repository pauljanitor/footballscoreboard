package com.sportradar.footballscoreboard.model;


import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MatchSummaryTest {

    @Test
    public void of_shouldReturnProperSingleSummary() {
        // given
        Team homeTeam = Team.of("polanD");
        Team awayTeam = Team.of("aRGENtinA");
        CompetingTeams competingTeams = CompetingTeams.of(homeTeam, awayTeam);
        Score score = Score.initialScore();
        score.updateScore(NewScore.of(2, 0));

        // when
        MatchSummary result = MatchSummary.of(competingTeams, score);

        // then
        assertThat(result.getHomeTeamSummary().getTeam()).isEqualTo(homeTeam);
        assertThat(result.getHomeTeamSummary().getScore().getScore()).isEqualTo(score.getHomeTeamScore());
        assertThat(result.getAwayTeamSummary().getTeam()).isEqualTo(awayTeam);
        assertThat(result.getAwayTeamSummary().getScore().getScore()).isEqualTo(score.getAwayTeamScore());
    }
}