package com.example.hash;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HashController {

    private HashService hashService;

    public HashController(HashService hashService) {
        this.hashService = hashService;
    }

    @PostMapping("/hash")
    public Movie hash(@RequestBody Movie movie) {
        final Movie moviePersistent = this.hashService.getMovie(movie);
        return moviePersistent;

    }
}
