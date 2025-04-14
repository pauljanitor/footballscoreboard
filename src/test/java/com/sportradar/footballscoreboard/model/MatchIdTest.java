package com.sportradar.footballscoreboard.model;


import org.junit.Test;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

public class MatchIdTest {

    @Test
    public void generateMatchId_shouldGenerateMatchId() {
        // when
        MatchId result = MatchId.generateMatchId();

        // then
        assertThat(result.getId()).isInstanceOf(UUID.class);

    }
}
