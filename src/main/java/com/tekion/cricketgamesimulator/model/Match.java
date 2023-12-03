package com.tekion.cricketgamesimulator.model;

import com.tekion.cricketgamesimulator.enums.MatchResult;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "match")
public class Match {
    @Id
    private long matchId;
    private int overs;
    private Team battingTeam;
    private Team bowlingTeam;
    private MatchResult matchResult;
    private int target;
    private long eventId;
    private String eventName;

    public Match() {
    }

    public Match(long matchId, int overs, Team battingTeam, Team bowlingTeam, MatchResult matchResult, int target, long eventId, String eventName) {
        this.matchId = matchId;
        this.overs = overs;
        this.battingTeam = battingTeam;
        this.bowlingTeam = bowlingTeam;
        this.matchResult = matchResult;
        this.target = target;
        this.eventId = eventId;
        this.eventName = eventName;
    }

    public long getMatchId() {
        return matchId;
    }

    public void setMatchId(long matchId) {
        this.matchId = matchId;
    }

    public int getOvers() {
        return overs;
    }

    public void setOvers(int overs) {
        this.overs = overs;
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

    public MatchResult getMatchResult() {
        return matchResult;
    }

    public void setMatchResult(MatchResult matchResult) {
        this.matchResult = matchResult;
    }

    public int getTarget() {
        return target;
    }

    public void setTarget(int target) {
        this.target = target;
    }

    public long getEventId() {
        return eventId;
    }

    public void setEventId(long eventId) {
        this.eventId = eventId;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    @Override
    public String toString() {
        return "Match{" +
                "matchId=" + matchId +
                ", overs=" + overs +
                ", battingTeam=" + battingTeam +
                ", bowlingTeam=" + bowlingTeam +
                ", matchResult=" + matchResult +
                ", target=" + target +
                ", eventId=" + eventId +
                ", eventName='" + eventName + '\'' +
                '}';
    }
}
