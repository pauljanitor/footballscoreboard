package com.sportradar.footballscoreboard;

import com.sportradar.footballscoreboard.validation.DefaultTeamsValidator;

public class InMemoryScoreBoardTest extends AbstractScoreBoardTest {

    @Override
    protected ScoreBoard createScoreBoard() {
        return new InMemoryScoreBoard(new DefaultTeamsValidator());
    }
}
