package com.tekion.cricketgamesimulator.controller;

import com.tekion.cricketgamesimulator.model.Match;
import com.tekion.cricketgamesimulator.model.MatchRequest;
import com.tekion.cricketgamesimulator.model.ScoreBoard;
import com.tekion.cricketgamesimulator.model.SeriesRequest;
import com.tekion.cricketgamesimulator.service.MatchService;
import com.tekion.cricketgamesimulator.model.Team;
import com.tekion.cricketgamesimulator.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/matches")
public class MatchController {

    @Autowired
    private MatchService matchService;

    @Autowired
    private TeamService teamService;

    @PostMapping("/start")
    public Match startMatch(@RequestBody MatchRequest matchRequest) {
        // Assuming MatchRequest is a DTO class containing necessary details for starting a match
        Team teamA = teamService.getTeamByTeamName(matchRequest.getTeamA());
        Team teamB = teamService.getTeamByTeamName(matchRequest.getTeamB());
        return matchService.startMatch(teamA, teamB, matchRequest.getOvers());
    }

    @PostMapping("/start-series")
    public List<Match> startSeries(@RequestBody SeriesRequest seriesRequest) {
        // Assuming SeriesRequest is a DTO class containing necessary details for starting a series
        return matchService.startSeries(seriesRequest);
    }

    @GetMapping("/{matchId}")
    public Match getMatchDetails(@PathVariable String matchId) {
        return matchService.getMatchById(matchId);
    }

    @GetMapping("/all")
    public List<Match> getAllMatches() {
        return matchService.getAllMatches();
    }

    @GetMapping("/scoreboard/{matchId}")
    public ScoreBoard getMatchScoreboard(@PathVariable Long matchId) {
        return matchService.getMatchScoreboard(matchId);
    }
}
