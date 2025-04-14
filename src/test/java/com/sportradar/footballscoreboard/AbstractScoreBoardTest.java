package com.sportradar.footballscoreboard;

import com.sportradar.footballscoreboard.model.*;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

abstract class AbstractScoreBoardTest {

    protected abstract ScoreBoard createScoreBoard();

    @Test
    public void startMatch_shouldAddMatchToBoard() {
        // given
        ScoreBoard scoreBoard = createScoreBoard();
        Team homeTeam = Team.of("germany");
        Team awayTeam = Team.of("poland");

        // when
        scoreBoard.startMatch(homeTeam, awayTeam);

        // then
        MatchSummary found = scoreBoard.getSummary().getMatchSummaries().getFirst();

        assertThat(found.getHomeTeamSummary().getTeam()).isEqualTo(homeTeam);
        assertThat(found.getHomeTeamSummary().getScore()).isEqualTo(0);
        assertThat(found.getHomeTeamSummary().getTeam()).isEqualTo(awayTeam);
        assertThat(found.getHomeTeamSummary().getScore()).isEqualTo(0);
    }

    @Test
    public void startMatch_shouldThrowIllegalArgumentExceptionWhenSameTeamAsHomeAndAway() {
        // given
        ScoreBoard scoreBoard = createScoreBoard();
        Team team = Team.of("germany");

        // when - then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> scoreBoard.startMatch(team, team));
    }

    @Test
    public void startMatch_shouldThrowIllegalArgumentExceptionWhenHomeTeamDuringMatch() {
        // given
        ScoreBoard scoreBoard = createScoreBoard();
        Team homeTeam = Team.of("germany");
        Team awayTeam_1 = Team.of("poland");
        Team awayTeam_2 = Team.of("france");
        scoreBoard.startMatch(homeTeam, awayTeam_1);
        assertThat(scoreBoard.getSummary().getMatchSummaries()).hasSize(1);

        // when - then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> scoreBoard.startMatch(homeTeam, awayTeam_2));
    }

    @Test
    public void startMatch_shouldThrowIllegalArgumentExceptionWhenHomeAwayDuringMatch() {
        // given
        ScoreBoard scoreBoard = createScoreBoard();
        Team homeTeam_1 = Team.of("germany");
        Team homeTeam_2 = Team.of("poland");
        Team awayTeam = Team.of("france");
        scoreBoard.startMatch(homeTeam_1, awayTeam);
        assertThat(scoreBoard.getSummary().getMatchSummaries()).hasSize(1);

        // when - then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> scoreBoard.startMatch(homeTeam_2, awayTeam));
    }

    @Test
    public void startMatch_shouldThrowIllegalArgumentExceptionWhenBothTeamDuringMatch() {
        // given
        ScoreBoard scoreBoard = createScoreBoard();
        Team homeTeam = Team.of("germany");
        Team awayTeam = Team.of("poland");
        scoreBoard.startMatch(homeTeam, awayTeam);
        assertThat(scoreBoard.getSummary().getMatchSummaries()).hasSize(1);

        // when - then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> scoreBoard.startMatch(homeTeam, awayTeam));
    }

    @Test
    public void startMatch_shouldThrowIllegalArgumentExceptionWhenBothTeamDuringMatchButHomeIsAway() {
        // given
        ScoreBoard scoreBoard = createScoreBoard();
        Team homeTeam = Team.of("germany");
        Team awayTeam = Team.of("poland");
        scoreBoard.startMatch(homeTeam, awayTeam);
        assertThat(scoreBoard.getSummary().getMatchSummaries()).hasSize(1);

        // when - then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> scoreBoard.startMatch(awayTeam, homeTeam));
    }

    @Test
    public void startMatch_shouldThrowIllegalArgumentExceptionWhenHomeNameIsNull() {
        // given
        ScoreBoard scoreBoard = createScoreBoard();
        Team homeTeam = null;
        Team awayTeam = Team.of("poland");

        // when - then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> scoreBoard.startMatch(homeTeam, awayTeam));
    }

    @Test
    public void startMatch_shouldThrowIllegalArgumentExceptionWhenAwayNameIsNull() {
        // given
        ScoreBoard scoreBoard = createScoreBoard();
        Team homeTeam = Team.of("poland");
        Team awayTeam = null;


        // when - then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> scoreBoard.startMatch(homeTeam, awayTeam));
    }

    @Test
    public void startMatch_shouldThrowIllegalArgumentExceptionWhenHomeNameIsEmpty() {
        // given
        ScoreBoard scoreBoard = createScoreBoard();
        Team homeTeam = Team.of("");
        Team awayTeam = Team.of("poland");

        // when - then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> scoreBoard.startMatch(homeTeam, awayTeam));
    }

    @Test
    public void startMatch_shouldThrowIllegalArgumentExceptionWhenAwayNameIsEmpty() {
        // given
        ScoreBoard scoreBoard = createScoreBoard();
        Team homeTeam = Team.of("poland");
        Team awayTeam = Team.of("");

        // when - then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> scoreBoard.startMatch(homeTeam, awayTeam));
    }

    @Test
    public void startMatch_shouldThrowIllegalArgumentExceptionWhenHomeNameContainsSpecialChars() {
        // given
        ScoreBoard scoreBoard = createScoreBoard();
        Team homeTeam = Team.of("\"(){}[]");
        Team awayTeam = Team.of("poland");
        // when - then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> scoreBoard.startMatch(homeTeam, awayTeam));
    }

    @Test
    public void startMatch_shouldThrowIllegalArgumentExceptionWhenAwayNameContainsSpecialChars() {
        // given
        ScoreBoard scoreBoard = createScoreBoard();
        Team homeTeam = Team.of("poland");
        Team awayTeam = Team.of("+*/=<>%^\"");
        // when - then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> scoreBoard.startMatch(homeTeam, awayTeam));
    }

    @Test
    public void startMatch_shouldThrowIllegalArgumentExceptionWhenHomeNameLongerThan15chars() {
        // given
        ScoreBoard scoreBoard = createScoreBoard();
        Team homeTeam = Team.of(RandomStringUtils.randomAlphabetic(16));
        Team awayTeam = Team.of("poland");
        // when - then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> scoreBoard.startMatch(homeTeam, awayTeam));
    }

    @Test
    public void startMatch_shouldThrowIllegalArgumentExceptionWhenAwayNameLongerThan15chars() {
        // given
        ScoreBoard scoreBoard = createScoreBoard();
        Team homeTeam = Team.of("poland");
        Team awayTeam = Team.of(RandomStringUtils.randomAlphabetic(16));
        // when - then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> scoreBoard.startMatch(homeTeam, awayTeam));
    }

    @Test
    public void finishMatch_shouldFinishMatchAndRemoveFromBoard() {
        // given
        ScoreBoard scoreBoard = createScoreBoard();
        Team homeTeam = Team.of("germany");
        Team awayTeam = Team.of("poland");
        MatchId matchId = scoreBoard.startMatch(homeTeam, awayTeam);
        assertThat(scoreBoard.getSummary().getMatchSummaries()).hasSize(1);

        // when
        scoreBoard.finishMatch(matchId);

        // then
        assertThat(scoreBoard.getSummary().getMatchSummaries()).isEmpty();
    }

    @Test
    public void finishMatch_shouldThrowIllegalArgumentExceptionWhenMatchNotFound() {
        // given
        ScoreBoard scoreBoard = createScoreBoard();
        MatchId matchId = MatchId.generateMatchId();

        // when - then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> scoreBoard.finishMatch(matchId));
    }

    @Test
    public void updateScore_shouldUpdateScore() {
        // given
        ScoreBoard scoreBoard = createScoreBoard();
        Team homeTeam = Team.of("germany");
        Team awayTeam = Team.of("poland");
        MatchId matchId = scoreBoard.startMatch(homeTeam, awayTeam);
        NewScore newScore = NewScore.of(1, 4);

        // when
        scoreBoard.updateScore(matchId, newScore);

        // then
        MatchSummary found = scoreBoard.getSummary().getMatchSummaries().getFirst();

        assertThat(found.getHomeTeamSummary().getTeam()).isEqualTo(homeTeam);
        assertThat(found.getHomeTeamSummary().getScore()).isEqualTo(1);
        assertThat(found.getHomeTeamSummary().getTeam()).isEqualTo(awayTeam);
        assertThat(found.getHomeTeamSummary().getScore()).isEqualTo(4);
    }

    @Test
    public void updateScore_shouldThrowIllegalArgumentExceptionWhenMatchNotFound() {
        // given
        ScoreBoard scoreBoard = createScoreBoard();
        MatchId matchId = MatchId.generateMatchId();
        NewScore newScore = NewScore.of(1, 4);

        // when - then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> scoreBoard.updateScore(matchId, newScore));
    }

    @Test
    public void updateScore_shouldThrowIllegalArgumentExceptionWhenNewHomeScoreNegative() {
        // given
        ScoreBoard scoreBoard = createScoreBoard();
        Team homeTeam = Team.of("germany");
        Team awayTeam = Team.of("poland");
        MatchId matchId = scoreBoard.startMatch(homeTeam, awayTeam);
        NewScore newScore = NewScore.of(-1, 4);

        // when - then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> scoreBoard.updateScore(matchId, newScore));
    }

    @Test
    public void updateScore_shouldThrowIllegalArgumentExceptionWhenNewAwayScoreNegative() {
        // given
        ScoreBoard scoreBoard = createScoreBoard();
        Team homeTeam = Team.of("germany");
        Team awayTeam = Team.of("poland");
        MatchId matchId = scoreBoard.startMatch(homeTeam, awayTeam);
        NewScore newScore = NewScore.of(1, -4);

        // when - then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> scoreBoard.updateScore(matchId, newScore));
    }

    @Test
    public void getSummary_shouldReturnEmptyBoardWhenNoMatchInProgress() {
        // given
        ScoreBoard scoreBoard = createScoreBoard();

        // when
        Summary result = scoreBoard.getSummary();

        // then
        assertThat(result.getMatchSummaries()).isEmpty();
    }

    @Test
    public void getSummary_shouldReturnCorrectScoringAndTimingOrderInSummary() {
        // given
        ScoreBoard scoreBoard = createScoreBoard();
        prepareCodingExerciseInput(scoreBoard);

        // when
        Summary result = scoreBoard.getSummary();

        // then
        List<MatchSummary> matchSummaries = result.getMatchSummaries();
        assertThat(matchSummaries).hasSize(5);
        // Uruguay 6 - Italy 6
        MatchSummary uruIta = matchSummaries.get(0);
        assertThat(uruIta.getHomeTeamSummary().getTeam().getCountry().getName()).isEqualTo("Uruguay");
        assertThat(uruIta.getHomeTeamSummary().getScore()).isEqualTo(6);
        assertThat(uruIta.getAwayTeamSummary().getTeam().getCountry().getName()).isEqualTo("Italy");
        assertThat(uruIta.getAwayTeamSummary().getScore()).isEqualTo(6);
        // Spain 10 - Brazil 2
        MatchSummary spaBra = matchSummaries.get(1);
        assertThat(spaBra.getHomeTeamSummary().getTeam().getCountry().getName()).isEqualTo("Spain");
        assertThat(spaBra.getHomeTeamSummary().getScore()).isEqualTo(10);
        assertThat(spaBra.getAwayTeamSummary().getTeam().getCountry().getName()).isEqualTo("Brazil");
        assertThat(spaBra.getAwayTeamSummary().getScore()).isEqualTo(2);
        // Mexico 0 - Canada 5
        MatchSummary mexCan = matchSummaries.get(2);
        assertThat(mexCan.getHomeTeamSummary().getTeam().getCountry().getName()).isEqualTo("Mexico");
        assertThat(mexCan.getHomeTeamSummary().getScore()).isEqualTo(0);
        assertThat(mexCan.getAwayTeamSummary().getTeam().getCountry().getName()).isEqualTo("Canada");
        assertThat(mexCan.getAwayTeamSummary().getScore()).isEqualTo(5);
        // Argentina 3 - Australia 1
        MatchSummary argAus = matchSummaries.get(3);
        assertThat(argAus.getHomeTeamSummary().getTeam().getCountry().getName()).isEqualTo("Argentina");
        assertThat(argAus.getHomeTeamSummary().getScore()).isEqualTo(3);
        assertThat(argAus.getAwayTeamSummary().getTeam().getCountry().getName()).isEqualTo("Australia");
        assertThat(argAus.getAwayTeamSummary().getScore()).isEqualTo(1);
        // Germany 2 - France 2
        MatchSummary gerFra = matchSummaries.get(4);
        assertThat(gerFra.getHomeTeamSummary().getTeam().getCountry().getName()).isEqualTo("Germany");
        assertThat(gerFra.getHomeTeamSummary().getScore()).isEqualTo(2);
        assertThat(gerFra.getAwayTeamSummary().getTeam().getCountry().getName()).isEqualTo("France");
        assertThat(gerFra.getAwayTeamSummary().getScore()).isEqualTo(2);
    }

    private void prepareCodingExerciseInput(ScoreBoard scoreBoard) {
        Team mexico = Team.of("MEXICO");
        Team spain = Team.of("SpaIN");
        Team germany = Team.of("GermaNY");
        Team uruguay = Team.of("Uruguay");
        Team argentina = Team.of("ArgenTinA");

        Team canada = Team.of("canada");
        Team brazil = Team.of("BraziL");
        Team france = Team.of("fRaNCe");
        Team italy = Team.of("itAly");
        Team australia = Team.of("AustraLIA");

        // Mexico - Canada: 0 – 5
        MatchId matchId_1 = scoreBoard.startMatch(mexico, canada);
        scoreBoard.updateScore(matchId_1, NewScore.of(0, 5));

        // Spain - Brazil: 10 – 2
        MatchId matchId_2 = scoreBoard.startMatch(spain, brazil);
        scoreBoard.updateScore(matchId_2, NewScore.of(10, 2));

        // Germany - France: 2 – 2
        MatchId matchId_3 = scoreBoard.startMatch(germany, france);
        scoreBoard.updateScore(matchId_3, NewScore.of(2, 2));

        // Uruguay - Italy: 6 – 6
        MatchId matchId_4 = scoreBoard.startMatch(uruguay, italy);
        scoreBoard.updateScore(matchId_4, NewScore.of(6, 6));

        // Argentina - Australia: 3 - 1
        MatchId matchId_5 = scoreBoard.startMatch(argentina, australia);
        scoreBoard.updateScore(matchId_5, NewScore.of(3, 1));
    }
}
