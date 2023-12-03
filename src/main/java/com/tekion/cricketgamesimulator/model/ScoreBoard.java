package com.tekion.cricketgamesimulator.model;

import java.util.List;

public class ScoreBoard {
    private int totalRuns;
    private int totalWickets;
    private int oversBowled;
    private List<OverDetails> overDetailsList;

    public ScoreBoard() {
    }

    public ScoreBoard(int totalRuns, int totalWickets, int oversBowled, List<OverDetails> overDetailsList) {
        this.totalRuns = totalRuns;
        this.totalWickets = totalWickets;
        this.oversBowled = oversBowled;
        this.overDetailsList = overDetailsList;
    }

    public int getTotalRuns() {
        return totalRuns;
    }

    public void setTotalRuns(int totalRuns) {
        this.totalRuns = totalRuns;
    }

    public int getTotalWickets() {
        return totalWickets;
    }

    public void setTotalWickets(int totalWickets) {
        this.totalWickets = totalWickets;
    }

    public int getOversBowled() {
        return oversBowled;
    }

    public void setOversBowled(int oversBowled) {
        this.oversBowled = oversBowled;
    }

    public List<OverDetails> getOverDetailsList() {
        return overDetailsList;
    }

    public void setOverDetailsList(List<OverDetails> overDetailsList) {
        this.overDetailsList = overDetailsList;
    }

    @Override
    public String toString() {
        return "ScoreBoard{" +
                "totalRuns=" + totalRuns +
                ", totalWickets=" + totalWickets +
                ", oversBowled=" + oversBowled +
                ", overDetailsList=" + overDetailsList +
                '}';
    }
}
