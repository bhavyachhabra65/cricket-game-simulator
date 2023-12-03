package com.tekion.cricketgamesimulator.model;

import com.tekion.cricketgamesimulator.enums.WicketType;

public class BallOutcome {
    private int runsScored;
    private boolean isWicket;
    private WicketType wicketType;
    private boolean isWide;
    private boolean isNoBall;
    private Player batsman;

    public BallOutcome() {
    }

    public BallOutcome(int runsScored, boolean isWicket, WicketType wicketType, boolean isWide, boolean isNoBall, Player batsman) {
        this.runsScored = runsScored;
        this.isWicket = isWicket;
        this.wicketType = wicketType;
        this.isWide = isWide;
        this.isNoBall = isNoBall;
        this.batsman = batsman;
    }

    public int getRunsScored() {
        return runsScored;
    }

    public void setRunsScored(int runsScored) {
        this.runsScored = runsScored;
    }

    public boolean isWicket() {
        return isWicket;
    }

    public void setWicket(boolean wicket) {
        isWicket = wicket;
    }

    public WicketType getWicketType() {
        return wicketType;
    }

    public void setWicketType(WicketType wicketType) {
        this.wicketType = wicketType;
    }

    public boolean isWide() {
        return isWide;
    }

    public void setWide(boolean wide) {
        isWide = wide;
    }

    public boolean isNoBall() {
        return isNoBall;
    }

    public void setNoBall(boolean noBall) {
        isNoBall = noBall;
    }

    public Player getBatsman() {
        return batsman;
    }

    public void setBatsman(Player batsman) {
        this.batsman = batsman;
    }

    @Override
    public String toString() {
        return "BallOutcome{" +
                "runsScored=" + runsScored +
                ", isWicket=" + isWicket +
                ", wicketType=" + wicketType +
                ", isWide=" + isWide +
                ", isNoBall=" + isNoBall +
                ", batsman=" + batsman +
                '}';
    }
}
