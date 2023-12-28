package com.example.mdbvectorsearch.repository;
import reactor.core.publisher.Flux;
import java.util.List;
import com.example.mdbvectorsearch.model.Movie;

public interface MovieRepository {
    Flux<Movie> findMoviesByVector(List<Double> embedding);
}
