package com.example.benchmarkkafkareactive.properties;

import lombok.Data;
import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Data
@Configuration
@EnableConfigurationProperties
@ConfigurationProperties("benchmark.kafka")
public class KafkaProperties {
    private String bootstrapServers;
    private String groupId;
    private String autoOffsetReset;
    private String keyDeserializer;
    private String valueDeserializer;
    private List<TopicProperties> topics = new ArrayList<>();

    private List<TopicProperties> getTopics(){
        return Collections.unmodifiableList(this.topics);
    }

    public List<TopicProperties> getTopicsEnabled(){
        return this.topics.stream()
                   .filter(t-> t.enabled == true)
                   .collect(Collectors.toList());
    }

    public Optional<TopicProperties> findTopicByName(String topicName){
        return topics.stream()
               .filter(t-> t.getName().equals(topicName))
               .findFirst();
    }

    @Data
    public static class TopicProperties {
        private String name;
        private String mapClass;
        private boolean enabled;
    }
}
