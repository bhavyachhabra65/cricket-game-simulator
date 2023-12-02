package com.tekion.cricketgamesimulator.service;

import com.tekion.cricketgamesimulator.model.Player;
import com.tekion.cricketgamesimulator.model.Team;
import com.tekion.cricketgamesimulator.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class PlayerService {

    @Autowired
    private PlayerRepository playerRepository;

    public Player savePlayer(Player player) {
        // You can add additional logic before saving, if needed
        return playerRepository.save(player);
    }

    public List<Player> getAllPlayers() {
        return playerRepository.findAll();
    }

    public Player getPlayerById(String playerId) {
        return playerRepository.findById(playerId).orElse(null);
    }

    public void initializePlayers() {
        // Create teams
        Team teamA = new Team("TeamA");
        Team teamB = new Team("TeamB");

        // Save teams
        // Assuming you have a TeamRepository for saving teams
        teamRepository.saveAll(Arrays.asList(teamA, teamB));

        // Create players and assign them to teams
        Player player1 = new Player("Player1", "Batsman");
        Player player2 = new Player("Player2", "Bowler");

        // Save players
        playerRepository.saveAll(Arrays.asList(player1, player2));
    }


    // Add more methods as needed based on your business logic

    // For example:
    public void deletePlayerById(String playerId) {
        playerRepository.deleteById(playerId);
    }
}
