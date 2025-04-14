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
        return new Match(MatchId.generateMatchId(),
                CompetingTeams.of(hometeam, awayTeam),
                Score.initialScore(),
                DurationInfo.initialDuration(),
                Instant.now());
    }

    public Match finishMatch() {
        return new Match(matchId, competingTeams, score, durationInfo.updateFinishTime(Instant.now()), createdAt);
    }

    public Match updateScore(NewScore newScore) {
        return new Match(matchId, competingTeams, new Score(newScore.getHomeScore(), newScore.getAwayScore()), durationInfo, createdAt);
    }
}
