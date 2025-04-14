package com.sportradar.footballscoreboard.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class TeamSummaryScore {
    private final int score;

    public static TeamSummaryScore of(int score) {
        return null;
    }
}
