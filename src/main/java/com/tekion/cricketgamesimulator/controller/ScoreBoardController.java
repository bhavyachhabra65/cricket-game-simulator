package com.tekion.cricketgamesimulator.controller;

import com.tekion.cricketgamesimulator.model.Match;
import com.tekion.cricketgamesimulator.model.ScoreBoard;
import com.tekion.cricketgamesimulator.service.MatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

public class ScoreBoardController {
    @Autowired
    private MatchService matchService;

    @GetMapping("/{matchId}")
    public List<ScoreBoard> getScoreBoardDetails(@PathVariable String matchId) {
        ScoreBoard scoreBoardChasingTeam = matchService.getMatchById(matchId).getChasingChampions().getScoreBoard();
        ScoreBoard scoreBoardDefendingTeam = matchService.getMatchById(matchId).getDefendingDynamos().getScoreBoard();
        List<ScoreBoard> scoreBoards = new ArrayList<>();
        scoreBoards.add(scoreBoardChasingTeam);
        scoreBoards.add(scoreBoardDefendingTeam);
        return scoreBoards;
    }
}