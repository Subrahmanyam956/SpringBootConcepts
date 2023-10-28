package com.SpringbootPractice.ConnectingToMultipleMongodbDatabases.config;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.mongodb.core.MongoTemplate;

@Configuration
public class MongoDbConfig {

    @Autowired
    private Environment environment;

    @Bean
    public MongoTemplate customerMongoDb() {
        String host = environment.getProperty("mongodb.server1.host");
        String port = environment.getProperty("mongodb.server1.port");
        String database = environment.getProperty("mongodb.server1.database");
        MongoClient mongoClient = MongoClients.create(String.format("mongodb://%s:%s", host, port));
        assert database != null;
        return new MongoTemplate(mongoClient, database);
    }

    @Bean
    public MongoTemplate hotelMongoDb() {
        String host = environment.getProperty("mongodb.server2.host");
        String port = environment.getProperty("mongodb.server2.port");
        String database = environment.getProperty("mongodb.server2.database");
        MongoClient mongoClient = MongoClients.create(String.format("mongodb://%s:%s", host, port));
        assert database != null;
        return new MongoTemplate(mongoClient, database);
    }
}
