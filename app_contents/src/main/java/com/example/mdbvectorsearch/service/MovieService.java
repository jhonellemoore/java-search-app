
package com.example.mdbvectorsearch.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import java.util.List;

import com.example.mdbvectorsearch.model.Movie;
import com.example.mdbvectorsearch.repository.MovieRepository;

@Service
public class MovieService {

    private final MovieRepository movieRepository;
    private final OpenAIService embedder;

    @Autowired
    public MovieService(MovieRepository movieRepository, OpenAIService embedder) {
        this.movieRepository = movieRepository;
        this.embedder = embedder;
    }

    public Mono<List<Movie>> getMoviesSemanticSearch(String plotDescription) {
        return embedder.createEmbedding(plotDescription)
                .flatMapMany(movieRepository::findMoviesByVector)
                .collectList();
    }
}