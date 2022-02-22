package com.example.hash;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class HashService {

    private WebClient webClient;

    public HashService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("http://localhost:8082").build();
    }

    public Movie getMovie(Movie movie) {
        return this.webClient
                .post()
                .uri("/movie")
                .bodyValue(movie)
                .retrieve()
                .bodyToMono(Movie.class)
                .block();
    }

}
