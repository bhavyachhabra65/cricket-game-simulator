package com.tekion.cricketgamesimulator.repository;

import com.tekion.cricketgamesimulator.model.Player;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PlayerRepository extends MongoRepository<Player, String> {
    // You can define custom queries or use the default CRUD methods provided by MongoRepository
}
