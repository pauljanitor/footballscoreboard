package com.sportradar.footballscoreboard.model;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TeamSummaryDetailsTest {

    @Test
    public void of_shouldReturnProperSummaryDetails() {
        // given
        Team team = Team.of("poLAnd");
        TeamSummaryScore score = TeamSummaryScore.of(3);

        // when
        TeamSummaryDetails result = TeamSummaryDetails.of(team, score);

        // then
        assertThat(result.getTeam()).isEqualTo(team);
        assertThat(result.getScore().getScore()).isEqualTo(3);
    }
}