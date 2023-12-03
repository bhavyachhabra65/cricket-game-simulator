package com.tekion.cricketgamesimulator.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {

    @KafkaListener(topics = "cricket-game-simulator", groupId = "my-group")
    public void consume(String outcome) {
        // Process the received message
        System.out.println("Event outcome: " + outcome);
    }
}