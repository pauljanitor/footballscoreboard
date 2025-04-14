package com.sportradar.footballscoreboard.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class MatchSummary {
    private final TeamSummaryDetails homeTeamSummary;
    private final TeamSummaryDetails awayTeamSummary;

    static MatchSummary of(CompetingTeams teams, Score score) {
        return new MatchSummary(TeamSummaryDetails.of(teams.getHomeTeam(), TeamSummaryScore.of(score.getHomeTeamScore())),
                TeamSummaryDetails.of(teams.getAwayTeam(), TeamSummaryScore.of(score.getAwayTeamScore())));
    }
}
