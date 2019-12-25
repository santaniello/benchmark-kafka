package com.example.benchmarkkafkaconsumermultithread.configs;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

@Configuration
@EnableMongoAuditing
@EnableReactiveMongoRepositories(basePackages = "com.example.benchmarkkafkaconsumermultithread.repositories")
public class MongoConfig {
}
