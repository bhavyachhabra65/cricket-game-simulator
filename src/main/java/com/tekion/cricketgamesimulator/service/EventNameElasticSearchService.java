package com.tekion.cricketgamesimulator.service;

import com.tekion.cricketgamesimulator.model.EventNameElasticSearch;
import com.tekion.cricketgamesimulator.model.Match;
import com.tekion.cricketgamesimulator.repository.EventNameElasticSearchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventNameElasticSearchService {

    @Autowired
    private EventNameElasticSearchRepository eventNameRepository;
    public Iterable<EventNameElasticSearch> findByEventNameContaining(String eventName){
        return eventNameRepository.findByEventNameContaining(eventName);
    }

    public void save(String eventName){
        EventNameElasticSearch eventNameElasticSearch = new EventNameElasticSearch();
        eventNameElasticSearch.setId(eventNameRepository.count());
        eventNameElasticSearch.setEventName(eventName);
        eventNameRepository.save(eventNameElasticSearch);
    }
    public List<EventNameElasticSearch> getAllMatches() {
        return eventNameRepository.findAll();
    }

}
