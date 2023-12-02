package com.tekion.cricketgamesimulator.repository;

import com.tekion.cricketgamesimulator.model.Match;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MatchRepository extends MongoRepository<Match, String> {
    // You can define custom queries or use the default CRUD methods provided by MongoRepository
}
