package com.sportradar.footballscoreboard.service;

import com.sportradar.footballscoreboard.model.MatchId;
import com.sportradar.footballscoreboard.model.NewScore;

public interface ScoreUpdating {
    void updateScore(MatchId matchId, NewScore newScore);
}
