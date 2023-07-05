package com.driver;

import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class MovieService {
    MovieRepository movieRepository = new MovieRepository();

    public void addMovie(Movie movie) {
        movieRepository.addMovie(movie);
    }

    public void addDirector(Director director) {
        movieRepository.addDirector(director);
    }

    public void addMovieDirectorPair(String movie, String director) {
        movieRepository.addMovieDirectorPair(movie,director);
    }

    public Movie getMovieByName(String name) {
        return movieRepository.getMovieByName(name);
    }

    public Director getDirectorByName(String name) {
        return movieRepository.getDirectorByName(name);
    }

    public ArrayList<String> getMoviesByDirectorName(String director) {
        return movieRepository.getMoviesByDirectorName(director);
    }

    public ArrayList<String> findAllMovies() {
        return movieRepository.findAllMovies();
    }

    public void deleteDirectorByName(String director) {
        ArrayList<String> movies = movieRepository.getMoviesByDirectorName(director);
        movieRepository.deleteDirectorByName(director);
        for(String movi : movies){
            movieRepository.deleteMovie(movi);
        }
    }

    public void deleteAllDirectors() {
        ArrayList<String>directors = movieRepository.getAllDirector();
        for(String director : directors){
            deleteDirectorByName(director);
        }
    }
}
