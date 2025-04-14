package com.sportradar.footballscoreboard.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.Instant;

@Getter
@RequiredArgsConstructor
public class Match {
    private final MatchId matchId;
    private final CompetingTeams competingTeams;
    private final Score score;
    private final DurationInfo durationInfo;
    private final Instant createdAt;

    public static Match newMatch(Team hometeam, Team awayTeam) {
        return null;
    }

    public void finishMatch() {
    }

    public void updateScore(NewScore newScore) {
    }
}
