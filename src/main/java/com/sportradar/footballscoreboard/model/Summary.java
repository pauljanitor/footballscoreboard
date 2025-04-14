package com.sportradar.footballscoreboard.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Getter
@RequiredArgsConstructor
public class Summary {
    private final List<MatchSummary> matchSummaries;

    public static Summary of(List<Match> matches) {
        return new Summary(prepareList(matches));
    }

    private static List<MatchSummary> prepareList(List<Match> matches) {
        return matches
                .stream()
                .map(match -> MatchSummary.of(match.getCompetingTeams(), match.getScore()))
                .toList();
    }
}
