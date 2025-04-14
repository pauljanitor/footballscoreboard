package com.sportradar.footballscoreboard.model;


import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class SummaryTest {

    @Test
    public void of_shouldCreateProperSummary() {
        // given
        Team homeTeam_1 = Team.of("germany");
        Team awayTeam_1 = Team.of("poland");
        Match match_1 = Match.newMatch(homeTeam_1, awayTeam_1);
        match_1.updateScore(NewScore.of(1, 1));
        Team homeTeam_2 = Team.of("japan");
        Team awayTeam_2 = Team.of("usa");
        Match match_2 = Match.newMatch(homeTeam_2, awayTeam_2);
        match_1.updateScore(NewScore.of(2, 3));

        // when
        Summary result = Summary.of(List.of(match_1, match_2));

        // then
        MatchSummary summary_1 = result.getMatchSummaries().get(0);
        assertThat(summary_1.getHomeTeamSummary().getTeam()).isEqualTo(homeTeam_1);
        assertThat(summary_1.getHomeTeamSummary().getScore()).isEqualTo(1);
        assertThat(summary_1.getAwayTeamSummary().getTeam()).isEqualTo(awayTeam_1);
        assertThat(summary_1.getAwayTeamSummary().getScore()).isEqualTo(1);
        MatchSummary summary_2 = result.getMatchSummaries().get(1);
        assertThat(summary_2.getHomeTeamSummary().getTeam()).isEqualTo(homeTeam_2);
        assertThat(summary_2.getHomeTeamSummary().getScore()).isEqualTo(2);
        assertThat(summary_2.getAwayTeamSummary().getTeam()).isEqualTo(awayTeam_2);
        assertThat(summary_2.getAwayTeamSummary().getScore()).isEqualTo(3);
    }
}