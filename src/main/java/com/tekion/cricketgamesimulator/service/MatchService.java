package com.tekion.cricketgamesimulator.service;

import com.tekion.cricketgamesimulator.model.*;
import com.tekion.cricketgamesimulator.repository.MatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MatchService {

    private final MatchRepository matchRepository;

    @Autowired
    private PlayerService playerService;


    @Autowired
    public MatchService(MatchRepository matchRepository) {
        this.matchRepository = matchRepository;
    }

    public Match saveMatch(Match match) {
        return matchRepository.save(match);
    }

    public List<Match> getAllMatches() {
        return matchRepository.findAll();
    }

    public Match getMatchById(String matchId) {
        return matchRepository.findById(matchId).orElse(null);
    }


    public Match startMatch(Team teamA, Team teamB, int overs) {
        // Initialize match details
        Match match = new Match();
        match.setOvers(overs);
        //Toss
        int result = random.nextInt(2);
        if(result == 0){
            match.setBattingTeam(teamA);
        }
        else{
            match.setBowlingTeam(teamB);
        }




        return match;
    }

    public List<Match> startSeries(SeriesRequest seriesRequest) {
        List<Match> matches = new ArrayList<>();

        for (int i = 0; i < seriesRequest.getNumberOfMatches(); i++) {
            // Start each match in the series
            MatchRequest matchRequest = new MatchRequest();
            matchRequest.setTeamA(seriesRequest.getTeamA());
            matchRequest.setTeamB(seriesRequest.getTeamB());
            matchRequest.setOvers(seriesRequest.getOversPerMatch());

            Match match = startMatch(matchRequest);
            matches.add(match);
        }

        // You may add more business logic for starting a series

        return matches;
    }

    public ScoreBoard getMatchScoreboard(Long matchId) {
        // Retrieve the match details from the database
        Match match = matchRepository.findById(matchId)
                .orElseThrow(() -> new IllegalArgumentException("Match not found with id: " + matchId));

        // You may add more business logic for generating the scoreboard

        // Simplified scoreboard creation
        ScoreBoard scoreboard = new ScoreBoard();
        scoreboard.setMatch(match);
        // Populate scoreboard details based on match, players, and other information

        return scoreboard;
    }


    // For example:
    public void deleteMatchById(String matchId) {
        matchRepository.deleteById(matchId);
    }
}
