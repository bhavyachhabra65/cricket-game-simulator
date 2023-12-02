package com.tekion.cricketgamesimulator.model;

import java.util.List;

public class OverDetails {
    private int overNumber;
    private List<BallOutcome> ballOutcomes;

    public OverDetails() {
    }

    public OverDetails(int overNumber, List<BallOutcome> ballOutcomes) {
        this.overNumber = overNumber;
        this.ballOutcomes = ballOutcomes;
    }

    public int getOverNumber() {
        return overNumber;
    }

    public void setOverNumber(int overNumber) {
        this.overNumber = overNumber;
    }

    public List<BallOutcome> getBallOutcomes() {
        return ballOutcomes;
    }

    public void setBallOutcomes(List<BallOutcome> ballOutcomes) {
        this.ballOutcomes = ballOutcomes;
    }

    @Override
    public String toString() {
        return "OverDetails{" +
                "overNumber=" + overNumber +
                ", ballOutcomes=" + ballOutcomes +
                '}';
    }
}
