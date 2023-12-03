package com.tekion.cricketgamesimulator.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "teams")
public class Team {

    @Indexed(unique = true)
    private String name;
    private List<Player> players;

    private ScoreBoard scoreBoard;

    public Team() {
    }

    public Team(String name, List<Player> players, ScoreBoard scoreBoard) {
        this.name = name;
        this.players = players;
        this.scoreBoard = scoreBoard;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public ScoreBoard getScoreBoard() {
        return scoreBoard;
    }

    public void setScoreBoard(ScoreBoard scoreBoard) {
        this.scoreBoard = scoreBoard;
    }

    @Override
    public String toString() {
        return "Team{" +
                ", name='" + name + '\'' +
                ", players=" + players +
                ", scoreBoard=" + scoreBoard +
                '}';
    }
}