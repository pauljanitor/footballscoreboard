package com.sportradar.footballscoreboard.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class CompetingTeams {
    private final Team homeTeam;
    private final Team awayTeam;

    static CompetingTeams of(Team homeTeam, Team awayTeam) {
        return new CompetingTeams(homeTeam, awayTeam);
    }
}
