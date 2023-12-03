package com.tekion.cricketgamesimulator.model;

public class SeriesRequest {
    private String teamA;
    private String teamB;
    private int oversPerMatch;
    private int numberOfMatches;
    private String eventName;

    // getters and setters

    public String getTeamA() {
        return teamA;
    }

    public void setTeamA(String teamA) {
        this.teamA = teamA;
    }

    public String getTeamB() {
        return teamB;
    }

    public void setTeamB(String teamB) {
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

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }
}
