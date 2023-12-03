package com.tekion.cricketgamesimulator.service;

import com.tekion.cricketgamesimulator.enums.PlayerRole;
import com.tekion.cricketgamesimulator.model.Player;
import com.tekion.cricketgamesimulator.model.Team;
import com.tekion.cricketgamesimulator.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class TeamService {

    @Autowired
    private TeamRepository teamRepository;

    public Team findTeamByName(String teamName) {
        return teamRepository.findByName(teamName);

    }

    private List<Player> getNewTeamPlayers(){
        List<Player> definePlayersInNewTeam = new ArrayList<>();
        for(int i = 0; i < 10; i++){
            Player playerDefine = new Player();
            playerDefine.setPlayerId(i);
            playerDefine.setPlayerName("player" + Integer.toString(i));
            if(i < 5){
                playerDefine.setPlayerRole(PlayerRole.BATSMAN);
            }
            else if(i == 5){
                playerDefine.setPlayerRole(PlayerRole.ALLROUNDER);
                playerDefine.setCaptain(true);
            }
            else{
                playerDefine.setPlayerRole(PlayerRole.BOWLER);
            }
            definePlayersInNewTeam.add(playerDefine);
        }
        return definePlayersInNewTeam;
    }

    @PostConstruct
    public void initializeData() {

        if (teamRepository.count() == 0) {
            Team defineTeamA = new Team();
            Team defineTeamB = new Team();
            defineTeamA.setName("TeamA");
            defineTeamA.setPlayers(getNewTeamPlayers());
            defineTeamB.setName("TeamB");
            defineTeamB.setPlayers(getNewTeamPlayers());
            teamRepository.save(defineTeamA);
            teamRepository.save(defineTeamB);
        }
    }

}

