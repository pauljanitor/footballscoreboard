package com.sportradar.footballscoreboard.model;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class NewScoreTest {

    @Test
    public void of_shouldCreateNewScore() {
        // when
        NewScore result = NewScore.of(2, 3);

        // then
        assertThat(result.getHomeScore()).isEqualTo(2);
        assertThat(result.getAwayScore()).isEqualTo(3);
    }

}