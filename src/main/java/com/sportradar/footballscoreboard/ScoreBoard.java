package com.sportradar.footballscoreboard;

import com.sportradar.footballscoreboard.service.GameManagement;
import com.sportradar.footballscoreboard.service.ScoreUpdating;
import com.sportradar.footballscoreboard.service.SummaryProvider;

public interface ScoreBoard extends GameManagement, ScoreUpdating, SummaryProvider {
}
