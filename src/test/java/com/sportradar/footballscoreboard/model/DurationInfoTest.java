package com.sportradar.footballscoreboard.model;


import org.junit.Test;

import java.time.Instant;

import static org.assertj.core.api.Assertions.assertThat;

public class DurationInfoTest {

    @Test
    public void initialDuration_shouldCreateDurationInfoWithOnlyFinishedAtNull() {
        // when
        DurationInfo result = DurationInfo.initialDuration();

        // then
        assertThat(result.getStartedAt()).isInstanceOf(Instant.class);
        assertThat(result.getFinishedAt()).isNull();
    }

    @Test
    public void updateFinishTime_shouldUpdateDurationInfoWithFinishTime() {
        // given
        DurationInfo durationInfo = DurationInfo.initialDuration();
        Instant finishTime = Instant.now();

        // when
        DurationInfo result = durationInfo.updateFinishTime(finishTime);

        // then
        assertThat(result.getStartedAt()).isEqualTo(durationInfo.getStartedAt());
        assertThat(result.getFinishedAt()).isEqualTo(finishTime);
    }
}