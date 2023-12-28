package com.example.mdbvectorsearch.config;

import org.bson.codecs.configuration.CodecRegistries;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.reactivestreams.client.MongoClient;
import com.mongodb.reactivestreams.client.MongoClients;
import com.mongodb.reactivestreams.client.MongoDatabase;

@Configuration
@PropertySource("classpath:application.properties")
public class MongodbConfig {

    @Value("${mongodb.uri}")
    private String MONGODB_URI;

    @Value("${mongodb.database}")
    private String MONGODB_DATABASE;

    @Bean
    public MongoClient mongoClient() {
        CodecRegistry pojoCodecRegistry = CodecRegistries.fromRegistries(
            MongoClientSettings.getDefaultCodecRegistry(),
            CodecRegistries.fromProviders(
                PojoCodecProvider.builder().automatic(true).build()
            )
        );

        MongoClientSettings settings = MongoClientSettings.builder()
            .applyConnectionString(new ConnectionString(MONGODB_URI))
            .codecRegistry(pojoCodecRegistry)
            .build();

        return MongoClients.create(settings);
    }
    @Bean
    public MongoDatabase mongoDatabase(MongoClient mongoClient) {
        return mongoClient.getDatabase(MONGODB_DATABASE); 
    }
}