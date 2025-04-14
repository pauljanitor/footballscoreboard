package com.sportradar.footballscoreboard.validation;

import com.sportradar.footballscoreboard.model.Team;

public interface TeamsValidator {
    void validate(Team homeTeamCountryName, Team awayTeamCountryName);
}
