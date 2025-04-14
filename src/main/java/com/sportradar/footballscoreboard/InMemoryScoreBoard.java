package com.sportradar.footballscoreboard;

import com.sportradar.footballscoreboard.model.*;
import com.sportradar.footballscoreboard.validation.TeamsValidator;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InMemoryScoreBoard implements ScoreBoard {
    private final Map<MatchId, Match> scoreBoard;
    private final TeamsValidator teamsValidator;

    public InMemoryScoreBoard(TeamsValidator teamsValidator) {
        this.scoreBoard = new HashMap<>();
        this.teamsValidator = teamsValidator;
    }

    @Override
    public MatchId startMatch(Team homeTeam, Team awayTeam) {
        teamsValidator.validate(homeTeam, awayTeam);
        validateInProgress(homeTeam, awayTeam);
        return saveMatch(homeTeam, awayTeam);
    }

    private void validateInProgress(Team homeTeam, Team awayTeam) {
        Set<Team> inProgress = scoreBoard.values().stream()
                .flatMap(match -> Stream.of(
                        match.getCompetingTeams().getHomeTeam(),
                        match.getCompetingTeams().getAwayTeam()
                ))
                .collect(Collectors.toSet());

        if (inProgress.contains(homeTeam) || inProgress.contains(awayTeam)) {
            throw new IllegalArgumentException("One team already in match. Cannot start new match");
        }
    }

    @Override
    public void finishMatch(MatchId matchId) {
        if (isInvalidMatchId(matchId)) {
            throw new IllegalArgumentException("MatchId cannot be null");
        }
        Match match = scoreBoard.get(matchId);
        if (Objects.isNull(match)) {
            throw new IllegalArgumentException("Match not found by MatchId: " + matchId);
        }
        match.finishMatch();
        // Here we can save match in a different storage i.e. finishedMatches
        scoreBoard.remove(matchId);
    }

    @Override
    public void updateScore(MatchId matchId, NewScore newScore) {
        if (isInvalidMatchId(matchId)) {
            throw new IllegalArgumentException("MatchId cannot be null");
        }
        validateNewScore(newScore);
        if (isInvalidMatchId(matchId)) {
            throw new IllegalArgumentException("MatchId cannot be null");
        }
        Match match = scoreBoard.get(matchId);
        if (Objects.nonNull(match)) {
            Match updated = match.updateScore(newScore);
            scoreBoard.put(matchId, updated);
        } else {
            throw new IllegalArgumentException("Match not found by MatchId: " + matchId);
        }
    }

    @Override
    public Summary getSummary() {
        return Summary.of(scoreBoard.values().stream().sorted(Comparator.comparingInt(Match::getTotalScore).reversed().thenComparing(Match::getStartTime).reversed()).toList());
    }

    private void validateNewScore(NewScore newScore) {
        if (Objects.isNull(newScore) || newScore.getHomeScore() < 0 || newScore.getAwayScore() < 0) {
            throw new IllegalArgumentException("New score invalid: null or negative value(s)");
        }
    }

    private MatchId saveMatch(Team homeTeam, Team awayTeam) {
        Match match = Match.newMatch(homeTeam, awayTeam);
        MatchId matchId = match.getMatchId();
        scoreBoard.put(matchId, match);
        return matchId;
    }

    private boolean isInvalidMatchId(MatchId matchId) {
        return Objects.isNull(matchId) || Objects.isNull(matchId.getId());
    }
}
