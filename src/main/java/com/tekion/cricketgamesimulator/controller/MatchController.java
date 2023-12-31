package com.tekion.cricketgamesimulator.controller;

import com.tekion.cricketgamesimulator.model.*;
import com.tekion.cricketgamesimulator.service.EventNameElasticSearchService;
import com.tekion.cricketgamesimulator.service.KafkaProducerService;
import com.tekion.cricketgamesimulator.service.MatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/matches")
public class MatchController {

    @Autowired
    private MatchService matchService;

    @Autowired
    private KafkaProducerService kafkaProducerService;

    @Autowired
    private EventNameElasticSearchService elasticSearchService;

    @PostMapping("/start")
    public ResponseEntity<String> startMatch(@RequestBody MatchRequest matchRequest) {
        Match matchOutcome = matchService.startMatch(matchRequest);
        kafkaProducerService.printMatch(matchOutcome);
        elasticSearchService.save(matchOutcome.getEventName());
        return ResponseEntity.ok("Match completed with event ID: " + matchOutcome.getEventId() + " printed results using kafka");
    }

    @PostMapping("/start-series")
    public ResponseEntity<String> startSeries(@RequestBody SeriesRequest seriesRequest) {
        List<Match> seriesOutcome = matchService.startSeries(seriesRequest);
        kafkaProducerService.printSeries(seriesOutcome);
        elasticSearchService.save(seriesOutcome.get(0).getEventName());
        return ResponseEntity.ok("Series completed with event ID: " + seriesOutcome.get(0).getEventId() + " printed results using kafka");
    }

    @GetMapping("/contains/{eventName}")
    public ResponseEntity<Iterable<EventNameElasticSearch>> getEventNameContainingStringInElasticsearch(@PathVariable String eventName) {
        return ResponseEntity.ok(elasticSearchService.findByEventNameContaining(eventName));
    }

    @GetMapping("/{eventId}")
    public ResponseEntity<List<Match>> getMatchDetails(@PathVariable long eventId) {
        return ResponseEntity.ok(matchService.getMatchByEventId(eventId));
    }

    @GetMapping("/all")
    public ResponseEntity<List<Match>> getAllMatches() {
        return ResponseEntity.ok(matchService.getAllMatches());
    }

}