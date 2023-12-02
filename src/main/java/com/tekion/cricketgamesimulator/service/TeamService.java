package com.tekion.cricketgamesimulator.service;

import com.tekion.cricketgamesimulator.model.Player;
import com.tekion.cricketgamesimulator.model.Team;
import com.tekion.cricketgamesimulator.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeamService {

    @Autowired
    private TeamRepository teamRepository;

    public Team getTeamByTeamName(String teamName) {
        return teamRepository.findByName(teamName);

    }
}

