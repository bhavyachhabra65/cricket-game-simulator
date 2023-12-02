package com.tekion.cricketgamesimulator.repository;

import com.tekion.cricketgamesimulator.model.Team;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TeamRepository extends MongoRepository<Team, String> {
    // You can add custom queries or methods if needed
    Team findByName(String name);
}
