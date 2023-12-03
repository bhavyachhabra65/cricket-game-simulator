package com.tekion.cricketgamesimulator.model;

import com.tekion.cricketgamesimulator.enums.PlayerRole;

public class Player {
    private int playerId;
    private String playerName;
    private PlayerRole playerRole;
    private boolean isCaptain;

    public Player() {
    }

    public Player(int playerId, String playerName, PlayerRole playerRole, boolean isCaptain) {
        this.playerId = playerId;
        this.playerName = playerName;
        this.playerRole = playerRole;
        this.isCaptain = isCaptain;
    }

    public int getPlayerId() {
        return playerId;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public PlayerRole getPlayerRole() {
        return playerRole;
    }

    public void setPlayerRole(PlayerRole playerRole) {
        this.playerRole = playerRole;
    }

    public boolean isCaptain() {
        return isCaptain;
    }

    public void setCaptain(boolean captain) {
        isCaptain = captain;
    }

    @Override
    public String toString() {
        return "Player{" +
                "playerId='" + playerId + '\'' +
                ", playerName='" + playerName + '\'' +
                ", playerRole=" + playerRole +
                ", isCaptain=" + isCaptain +
                '}';
    }
}
