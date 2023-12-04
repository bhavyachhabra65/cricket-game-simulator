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

    //Team batting in first innings
    private Team chasingChampions;

    //Team batting in second inning
    private Team defendingDynamos;
    private MatchResult matchResult;
    private int target;
    private long eventId;
    private String eventName;

    public Match() {
    }

    public Match(long matchId, int overs, Team chasingChampions, Team defendingDynamos, MatchResult matchResult, int target, long eventId, String eventName) {
        this.matchId = matchId;
        this.overs = overs;
        this.chasingChampions = chasingChampions;
        this.defendingDynamos = defendingDynamos;
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

    public Team getChasingChampions() {
        return chasingChampions;
    }

    public void setChasingChampions(Team chasingChampions) {
        this.chasingChampions = chasingChampions;
    }

    public Team getDefendingDynamos() {
        return defendingDynamos;
    }

    public void setDefendingDynamos(Team defendingDynamos) {
        this.defendingDynamos = defendingDynamos;
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
                ", chasingChampions=" + chasingChampions +
                ", defendingDynamos=" + defendingDynamos +
                ", matchResult=" + matchResult +
                ", target=" + target +
                ", eventId=" + eventId +
                ", eventName='" + eventName + '\'' +
                '}';
    }
}
