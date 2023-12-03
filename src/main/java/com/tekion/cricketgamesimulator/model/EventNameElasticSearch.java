package com.tekion.cricketgamesimulator.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "eventname")
public class EventNameElasticSearch {
    @Id
    private long id;
    private String eventName;

    public EventNameElasticSearch() {
    }

    public EventNameElasticSearch(long id, String eventName) {
        this.id = id;
        this.eventName = eventName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    @Override
    public String toString() {
        return "EventNameElasticSearch{" +
                "id='" + id + '\'' +
                ", eventName='" + eventName + '\'' +
                '}';
    }
}
