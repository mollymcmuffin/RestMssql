package com.projects.RestApiMssql.service;

import com.projects.RestApiMssql.entity.Movie;
import com.projects.RestApiMssql.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class MovieService {

    private MovieRepository movieRepository;

    @Autowired
    public MovieService (MovieRepository movieRepository){
        this.movieRepository = movieRepository;
    }

    public List<Movie> getMovies(){
        return movieRepository.findAll();
    }

    public void addNewMovie(Movie movie){
        Optional<Movie> movieOptional = movieRepository.findById(movie.getId());
        if (movieOptional.isPresent()){
            throw new IllegalStateException("Name taken");
        }
        movieRepository.save(movie);
    }

    public void deleteMovie(Long movieId){
        boolean exists = movieRepository.existsById(movieId);
        if (!exists){
            throw new IllegalStateException("Movie with Id " + movieId + " does not exist!");
        }

        movieRepository.deleteById(movieId);
    }

    @Transactional
    public void updateMovie(Long movieId, String name){
        Movie movie = movieRepository.findById(movieId).orElseThrow(()-> new IllegalStateException("Movie does not exist!"));
        if (name != null && name.length()>0 && !Objects.equals(movie , name)){
            movie.setName(name);
        }
    }
}
