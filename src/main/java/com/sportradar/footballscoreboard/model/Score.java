package com.sportradar.footballscoreboard.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class Score {
    private final int homeTeamScore;
    private final int awayTeamScore;

    public Score updateScore(NewScore newScore) {
        return new Score(newScore.getHomeScore(), newScore.getAwayScore());
    }

    public int getTotalScore() {
        return homeTeamScore + awayTeamScore;
    }

    static Score initialScore() {
        return new Score(0, 0);
    }
}
