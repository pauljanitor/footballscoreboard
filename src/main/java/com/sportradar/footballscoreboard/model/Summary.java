package com.sportradar.footballscoreboard.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Getter
@RequiredArgsConstructor
public class Summary {
    private final List<MatchSummary> matchSummaries;

    static Summary of(List<Match> matches) {
        return null;
    }
}
