package com.tekion.cricketgamesimulator.service;

import com.tekion.cricketgamesimulator.model.Match;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KafkaProducerService {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void printSeries(List<Match> seriesOutcome) {
        // Send the message to Kafka
        kafkaTemplate.send("cricket-game-simulator", seriesOutcome.toString());
    }

    public void printMatch(Match matchOutcome) {
        // Send the message to Kafka
        kafkaTemplate.send("cricket-game-simulator", matchOutcome.toString());
    }


}