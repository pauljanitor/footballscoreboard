package com.sportradar.footballscoreboard.model;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TeamTest {
    @Test
    public void of_shouldTeam() {
        // given
        String countryName = "polANd";
        // when
        Team result = Team.of(countryName);

        // then
        assertThat(result.getCountry().getName()).isEqualTo("Poland");
    }
}