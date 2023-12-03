package com.tekion.cricketgamesimulator.service;

import com.tekion.cricketgamesimulator.enums.MatchResult;
import com.tekion.cricketgamesimulator.enums.WicketType;
import com.tekion.cricketgamesimulator.model.*;
import com.tekion.cricketgamesimulator.repository.MatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class MatchService {

    @Autowired
    private MatchRepository matchRepository;

    @Autowired
    private TeamService teamService;

    public Match saveMatch(Match match) {
        return matchRepository.save(match);
    }

    public List<Match> getAllMatches() {
        return matchRepository.findAll();
    }

    public Match getMatchById(String matchId) {
        return matchRepository.findById(matchId).orElse(null);
    }

    private int getRandomBallOutcome(){
        Random random = new Random();
        int outcomeTemp = random.nextInt(10);
        int res;
        if(outcomeTemp < 9){
            res = random.nextInt(6);
        }
        else{
            res = random.nextInt(4)+6;
        }
        return res;
    }

    private int getRandomWicketType(){
        Random random = new Random();
        int res = random.nextInt(4);
        return res;
    }

    private ScoreBoard getScoreBoard(int overs, int target){
        ScoreBoard scoreBoard = new ScoreBoard();
        int totalRuns = 0;
        int totalWickets = 0;
        int oversBowled = 0;
        Random random = new Random();
        List<OverDetails> overDetailsList = new ArrayList<OverDetails>();
        outerLoop: for(int over = 0; over < overs; over++){
            OverDetails overDetails = new OverDetails();
            List<BallOutcome> ballsOutcome = new ArrayList<BallOutcome>();
            overDetails.setOverNumber(over+1);
            for(int ballNo = 0; ballNo < 6; ballNo++){
                int randomBallOutcome = getRandomBallOutcome();
                BallOutcome ballOutcome = new BallOutcome();
                //0-5 runs, 6-wide ball, 7-no ball, 8-wicket
                if(randomBallOutcome < 6) {
                    ballOutcome.setRunsScored(randomBallOutcome + 1);
                    totalRuns += randomBallOutcome + 1;
                    ballOutcome.setNoBall(false);
                    ballOutcome.setWide(false);
                    ballOutcome.setWicket(false);
                    if(totalRuns >= target){
                        ballsOutcome.add(ballOutcome);
                        overDetails.setBallOutcomes(ballsOutcome);
                        overDetailsList.add(overDetails);
                        oversBowled += 1;
                        break outerLoop;
                    }
                }
                if(randomBallOutcome == 6){
                    ballOutcome.setNoBall(false);
                    ballOutcome.setWicket(false);
                    ballOutcome.setRunsScored(1);
                    ballOutcome.setWide(true);
                    int runScored = random.nextInt(6)+1;
                    totalRuns += runScored;
                    ballOutcome.setRunsScored(runScored);
                    ballNo--;
                    if(totalRuns >= target){
                        ballsOutcome.add(ballOutcome);
                        overDetails.setBallOutcomes(ballsOutcome);
                        overDetailsList.add(overDetails);
                        oversBowled += 1;
                        break outerLoop;
                    }
                }
                if(randomBallOutcome == 7){
                    ballOutcome.setWide(false);
                    ballOutcome.setNoBall(true);
                    ballOutcome.setWicket(false);
                    int runScored = random.nextInt(6)+1;
                    totalRuns += runScored;
                    ballOutcome.setRunsScored(runScored);
                    ballNo--;
                    if(totalRuns >= target){
                        ballsOutcome.add(ballOutcome);
                        overDetails.setBallOutcomes(ballsOutcome);
                        overDetailsList.add(overDetails);
                        oversBowled += 1;
                        break outerLoop;
                    }
                }
                if(randomBallOutcome == 8){
                    totalWickets += 1;
                    ballOutcome.setRunsScored(0);
                    ballOutcome.setWicket(true);
                    ballOutcome.setNoBall(false);
                    ballOutcome.setWide(false);
                    int randomWicketType = getRandomWicketType();
                    if(randomWicketType == 0){
                        ballOutcome.setWicketType(WicketType.RUN_OUT);
                    }
                    if(randomWicketType == 1){
                        ballOutcome.setWicketType(WicketType.LBW);
                    }
                    if(randomWicketType == 2){
                        ballOutcome.setWicketType(WicketType.BOWLED);
                    }
                    if(randomWicketType == 3) {
                        ballOutcome.setWicketType(WicketType.CAUGHT);
                    }
                }
                ballsOutcome.add(ballOutcome);
                if(totalWickets >= 10){
                    ballsOutcome.add(ballOutcome);
                    overDetails.setBallOutcomes(ballsOutcome);
                    overDetailsList.add(overDetails);
                    oversBowled += 1;
                    break outerLoop;
                }
            }
            overDetails.setBallOutcomes(ballsOutcome);
            overDetailsList.add(overDetails);
            oversBowled += 1;

        }
        scoreBoard.setOverDetailsList(overDetailsList);
        scoreBoard.setTotalRuns(totalRuns);
        scoreBoard.setTotalWickets(totalWickets);
        scoreBoard.setOversBowled(oversBowled);
        return scoreBoard;
    }

    private Match playMatch(Team teamA, Team teamB, int overs, long eventId, String eventName){
        // Initialize match details
        Match match = new Match();
        match.setEventName(eventName);
        match.setMatchResult(MatchResult.ONGOING);
        match.setMatchId(matchRepository.count());
        match.setEventId(eventId);
        ScoreBoard scoreBoard = new ScoreBoard();
        match.setOvers(overs);
        //Toss
        Random random = new Random();
        int result = random.nextInt(2);
        if(result == 0){
            match.setBattingTeam(teamA);
            match.setBowlingTeam(teamB);
        }
        else{
            match.setBattingTeam(teamB);
            match.setBowlingTeam(teamA);
        }
        ScoreBoard scoreBoard1 = getScoreBoard(overs, 999999);
        ScoreBoard scoreBoard2 = getScoreBoard(overs, scoreBoard1.getTotalRuns()+1);
        match.setTarget(scoreBoard1.getTotalRuns()+1);
        Team battingTeam = match.getBattingTeam();
        battingTeam.setScoreBoard(scoreBoard1);
        match.setBattingTeam(battingTeam);
        Team bowlingTeam = match.getBowlingTeam();
        bowlingTeam.setScoreBoard(scoreBoard2);
        match.setBowlingTeam(bowlingTeam);
        if(scoreBoard1.getTotalRuns() > scoreBoard2.getTotalRuns() && result==0){
            match.setMatchResult(MatchResult.TEAM_A_WON);
        }
        else if(scoreBoard1.getTotalRuns() < scoreBoard2.getTotalRuns()){
            match.setMatchResult(MatchResult.TEAM_B_WON);
        }
        else{
            match.setMatchResult(MatchResult.DRAW);
        }
        matchRepository.save(match);
        return match;
    }

    public Match startMatch(MatchRequest matchRequest) {
        Team teamA = teamService.findTeamByName(matchRequest.getTeamA());
        Team teamB = teamService.findTeamByName(matchRequest.getTeamB());
        return playMatch(teamA, teamB, matchRequest.getOvers(), matchRepository.count(), matchRequest.getEventName());
    }

    public List<Match> startSeries(SeriesRequest seriesRequest) {
        Team teamA = teamService.findTeamByName(seriesRequest.getTeamA());
        Team teamB = teamService.findTeamByName(seriesRequest.getTeamB());
        List<Match> seriesOutcome = new ArrayList<Match>();
        long eventId = matchRepository.count();
        for(int i = 0; i < seriesRequest.getNumberOfMatches(); i++){
            seriesOutcome.add(playMatch(teamA, teamB, seriesRequest.getOversPerMatch(), eventId, seriesRequest.getEventName()));
        }
        return seriesOutcome;
    }

    public void deleteMatchById(String matchId) {
        matchRepository.deleteById(matchId);
    }
}
