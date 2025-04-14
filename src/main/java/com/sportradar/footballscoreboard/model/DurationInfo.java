package com.sportradar.footballscoreboard.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.Instant;

@Getter
@RequiredArgsConstructor
public class DurationInfo {
    private final Instant startedAt;
    private final Instant finishedAt;

    static DurationInfo initialDuration() {
        return new DurationInfo(Instant.now(), null);
    }

    public DurationInfo updateFinishTime(Instant finishTime) {
        return new DurationInfo(startedAt, finishTime);
    }
}
