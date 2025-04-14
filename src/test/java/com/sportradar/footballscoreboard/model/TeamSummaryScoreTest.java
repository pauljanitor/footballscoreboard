package com.sportradar.footballscoreboard.model;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TeamSummaryScoreTest {

    @Test
    public void of_shouldCreateTeamSummaryScore() {
        // given
        int score = 4;

        // when
        TeamSummaryScore result = TeamSummaryScore.of(score);

        // then
        assertThat(result.getScore()).isEqualTo(score);
    }

}