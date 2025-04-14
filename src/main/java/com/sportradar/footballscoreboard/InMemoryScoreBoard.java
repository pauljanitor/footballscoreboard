package com.sportradar.footballscoreboard;

import com.sportradar.footballscoreboard.model.*;
import com.sportradar.footballscoreboard.validation.TeamsValidator;

import java.util.HashMap;
import java.util.Map;

public class InMemoryScoreBoard implements ScoreBoard {
    private final Map<MatchId, Match> scoreBoard;
    private final TeamsValidator teamsValidator;

    public InMemoryScoreBoard(TeamsValidator teamsValidator) {
        this.scoreBoard = new HashMap<>();
        this.teamsValidator = teamsValidator;
    }

    @Override
    public MatchId startMatch(Team homeTeam, Team awayTeam) {
        return null;
    }

    @Override
    public void finishMatch(MatchId matchId) {
    }

    @Override
    public void updateScore(MatchId matchId, NewScore newScore) {
    }

    @Override
    public Summary getSummary() {
        return null;
    }
}
