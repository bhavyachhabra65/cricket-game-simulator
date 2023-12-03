package com.tekion.cricketgamesimulator.repository;

import com.tekion.cricketgamesimulator.model.EventNameElasticSearch;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface EventNameElasticSearchRepository extends ElasticsearchRepository<EventNameElasticSearch, String> {
    List<EventNameElasticSearch> findByEventNameContaining(String eventName);
    List<EventNameElasticSearch> findAll();


}
