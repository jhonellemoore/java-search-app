package com.example.mdbvectorsearch.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;  // Import Mono

import java.util.List;

import com.example.mdbvectorsearch.model.Movie;

@RestController
public class MovieController {

	private final MovieService movieService;
	
	@Autowired
	public MovieController(MovieService movieService) {
		this.movieService = movieService;
	}
	
	@GetMapping("/movies/semantic-search")
	public Mono<List<Movie>> performSemanticSearch(@RequestParam("plotDescription") String plotDescription) {
		return movieService.getMoviesSemanticSearch(plotDescription);
	}
}