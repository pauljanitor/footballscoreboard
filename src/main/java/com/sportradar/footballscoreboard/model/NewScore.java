package com.sportradar.footballscoreboard.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class NewScore {
    private final int homeScore;
    private final int awayScore;

    public static NewScore of(int homeScore, int awayScore) {
        return new NewScore(homeScore, awayScore);
    }
}
