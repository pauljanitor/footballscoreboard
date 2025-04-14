package com.sportradar.footballscoreboard.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.Instant;

@Getter
@RequiredArgsConstructor
public class DurationInfo {
    private final Instant startedAt;
    private final Instant finishedAt;

    static DurationInfo of() {
        return null;
    }

    public void updateFinishTime(Instant finishTime) {


    }

}
