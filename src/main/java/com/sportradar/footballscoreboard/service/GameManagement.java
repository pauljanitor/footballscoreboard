package com.sportradar.footballscoreboard.service;

import com.sportradar.footballscoreboard.model.MatchId;
import com.sportradar.footballscoreboard.model.Team;

public interface GameManagement {

    MatchId startMatch(Team homeTeamCountryName, Team awayTeamCountryName);

    void finishMatch(MatchId matchId);
}
