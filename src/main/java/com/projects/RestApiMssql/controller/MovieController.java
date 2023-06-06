package com.projects.RestApiMssql.controller;

import com.projects.RestApiMssql.entity.Movie;
import com.projects.RestApiMssql.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/movies")
public class MovieController {

    private final MovieService movieService;

    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping
    public List<Movie> getMovies(){
        return movieService.getMovies();
    }

    @PostMapping
    public void addNewMovie(@RequestBody Movie movie){
        movieService.addNewMovie(movie);
    }


    @DeleteMapping(path = "/{movieId}")
    public void deleteMovie(@PathVariable("movieId") Long movieId){
        movieService.deleteMovie(movieId);
    }

    @PutMapping(path = "/{movieId}")
    public void updateMovie(@PathVariable("movieId") Long movieId, @RequestParam(required = false) String name, @RequestParam(required = false) String genre){
        movieService.updateMovie(movieId, name,genre);
    }

}
