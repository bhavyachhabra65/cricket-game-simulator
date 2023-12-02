package com.tekion.cricketgamesimulator.model;

public class SeriesRequest {
    private Team teamA;
    private Team teamB;
    private int oversPerMatch;
    private int numberOfMatches;

    // getters and setters

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

    public int getOversPerMatch() {
        return oversPerMatch;
    }

    public void setOversPerMatch(int oversPerMatch) {
        this.oversPerMatch = oversPerMatch;
    }

    public int getNumberOfMatches() {
        return numberOfMatches;
    }

    public void setNumberOfMatches(int numberOfMatches) {
        this.numberOfMatches = numberOfMatches;
    }
}
