package com.sportradar.footballscoreboard.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class TeamSummaryDetails {

    private final Team team;
    private final TeamSummaryScore score;

    static TeamSummaryDetails of(Team team, TeamSummaryScore score) {
        return null;
    }
}
