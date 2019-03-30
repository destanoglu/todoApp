package com.onur.todo.configuration;

import com.mongodb.MongoClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;

@Configuration
public class MongoConfiguration {
    @Value("${product.mongo.host}")
    private String mongoHost;

    @Value("${product.mongo.port}")
    private String mongoPort;

    @Value("${product.mongo.database}")
    private String database;

    @Bean(name = "mongoClient")
    public MongoClient mongoClient() {
        return new MongoClient(mongoHost, Integer.parseInt(mongoPort));
    }

    @Autowired
    @Bean(name= "mongoDbFactory")
    public MongoDbFactory mongoDbFactory(MongoClient mongoClient){
        return new SimpleMongoDbFactory(mongoClient, database);
    }

    @Autowired
    @Bean
    public MongoTemplate mongoTemplate(MongoClient mongoClient){
        return new MongoTemplate(mongoClient, database);
    }
}
