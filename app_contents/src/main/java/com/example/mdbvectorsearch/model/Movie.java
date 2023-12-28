package com.example.mdbvectorsearch.model;
import org.bson.types.ObjectId;
import org.bson.codecs.pojo.annotations.BsonProperty;

import java.util.Date;
import java.util.List;
import java.util.*;

public class Movie {
    public static class Imdb {

        private double rating;
        private int votes;
        private int id;
    
        // Getters and setters for Imdb fields
    
    }
    public static class Tomatoes {

        private Viewer viewer;
        private Date lastUpdated;
    
        // Getters and setters for Tomatoes fields
    }
    public static class Viewer {

        private double rating;
        private int numReviews; 
    
        // Getters and setters for Viewer fields
    
    }

    @BsonProperty("_id")
    private ObjectId Id;
    private String title;
    private int year;
    private int runtime;
    private Date released;
    private String poster;
    private String plot;
    private String fullplot;
    private String lastupdated;
    private String type;
    private List<String> directors;
    private Imdb imdb;
    private List<String> cast;
    private List<String> countries;
    private List<String> genres;
    private Tomatoes tomatoes;
    private int num_mflix_comments;
    private String plot_embeddings;

    // Getters and setters for Movie fields

}
