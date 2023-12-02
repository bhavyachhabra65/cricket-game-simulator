package com.tekion.cricketgamesimulator.model;

import com.tekion.cricketgamesimulator.enums.MatchResult;

import java.util.List;

public class Match {
    private String matchId;
    private int overs;
    private List<OverDetails> overDetailsList;
    private Team battingTeam;
    private Team bowlingTeam;
    private ScoreBoard scoreboard;
    private MatchResult matchResult;


    public Match() {
    }

    public Match(String matchId, int overs, List<OverDetails> overDetailsList, Team battingTeam, Team bowlingTeam, ScoreBoard scoreboard, MatchResult matchResult, Team teamA, Team teamB) {
        this.matchId = matchId;
        this.overs = overs;
        this.overDetailsList = overDetailsList;
        this.battingTeam = battingTeam;
        this.bowlingTeam = bowlingTeam;
        this.scoreboard = scoreboard;
        this.matchResult = matchResult;
        this.teamA = teamA;
        this.teamB = teamB;
    }

    public String getMatchId() {
        return matchId;
    }

    public void setMatchId(String matchId) {
        this.matchId = matchId;
    }

    public int getOvers() {
        return overs;
    }

    public void setOvers(int overs) {
        this.overs = overs;
    }

    public List<OverDetails> getOverDetailsList() {
        return overDetailsList;
    }

    public void setOverDetailsList(List<OverDetails> overDetailsList) {
        this.overDetailsList = overDetailsList;
    }

    public Team getBattingTeam() {
        return battingTeam;
    }

    public void setBattingTeam(Team battingTeam) {
        this.battingTeam = battingTeam;
    }

    public Team getBowlingTeam() {
        return bowlingTeam;
    }

    public void setBowlingTeam(Team bowlingTeam) {
        this.bowlingTeam = bowlingTeam;
    }

    public ScoreBoard getScoreboard() {
        return scoreboard;
    }

    public void setScoreboard(ScoreBoard scoreboard) {
        this.scoreboard = scoreboard;
    }

    public MatchResult getMatchResult() {
        return matchResult;
    }

    public void setMatchResult(MatchResult matchResult) {
        this.matchResult = matchResult;
    }

    public Team getTeamA() {
        return teamA;
    }

    public void setTeamA(Team teamA) {
        this.teamA = teamA;
    }

    public Team getTeamB() {
        return teamB;
    }

    public void setTeamB(Team teamB) {
        this.teamB = teamB;
    }

    @Override
    public String toString() {
        return "Match{" +
                "matchId='" + matchId + '\'' +
                ", overs=" + overs +
                ", overDetailsList=" + overDetailsList +
                ", battingTeam=" + battingTeam +
                ", bowlingTeam=" + bowlingTeam +
                ", scoreboard=" + scoreboard +
                ", matchResult=" + matchResult +
                ", teamA=" + teamA +
                ", teamB=" + teamB +
                '}';
    }
}
