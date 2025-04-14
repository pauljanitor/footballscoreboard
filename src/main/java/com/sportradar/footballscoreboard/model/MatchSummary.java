package com.sportradar.footballscoreboard.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class MatchSummary {
    private final TeamSummaryDetails homeTeamSummary;
    private final TeamSummaryDetails awayTeamSummary;

    static MatchSummary of(CompetingTeams teamsSource, Score scoreSource) {
        return null;
    }
}
