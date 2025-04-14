package com.sportradar.footballscoreboard.model;


import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ScoreTest {

    @Test
    public void initialScore_shouldCreateNilNilScore() {
        // when
        Score result = Score.initialScore();

        // then
        assertThat(result.getHomeTeamScore()).isEqualTo(0);
        assertThat(result.getAwayTeamScore()).isEqualTo(0);
    }

    @Test
    public void updateScore_shouldReturnOneForHomeTeamAndTwoForAwayTeam() {
        // given
        Score score = Score.initialScore();
        NewScore newScore = NewScore.of(1, 2);

        // when
        score.updateScore(newScore);

        // then
        assertThat(score.getHomeTeamScore()).isEqualTo(1);
        assertThat(score.getAwayTeamScore()).isEqualTo(3);
    }
}