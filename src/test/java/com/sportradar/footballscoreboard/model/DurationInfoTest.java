package com.sportradar.footballscoreboard.model;


import org.junit.Test;

import java.time.Instant;

import static org.assertj.core.api.Assertions.assertThat;

public class DurationInfoTest {

    @Test
    public void of_shouldCreateDurationInfoWithOnlyFinishedAtNull() {
        // when
        DurationInfo result = DurationInfo.of();

        // then
        assertThat(result.getStartedAt()).isInstanceOf(Instant.class);
        assertThat(result.getFinishedAt()).isNull();
    }

    @Test
    public void updateFinishTime_shouldUpdateDurationInfoWithFinishTime() {
        // given
        DurationInfo durationInfo = DurationInfo.of();
        Instant finishTime = Instant.now();

        // when
        durationInfo.updateFinishTime(finishTime);

        // then
        assertThat(durationInfo.getStartedAt()).isInstanceOf(Instant.class);
        assertThat(durationInfo.getFinishedAt()).isEqualTo(finishTime);
    }
}