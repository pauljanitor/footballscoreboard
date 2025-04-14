package com.sportradar.footballscoreboard.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class Score {
    private final int homeTeamScore;
    private final int awayTeamScore;

    public void updateScore(NewScore newScore) {
    }

    static Score initialScore() {
        return null;
    }
}
