package com.driver;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class MovieRepository {
    HashMap<String,Movie> movieDb = new HashMap<>();
    HashMap<String,Director> directorDb = new HashMap<>();
    HashMap<String, ArrayList<String>> movieDirectorDb = new HashMap<>();
    public void addMovie(Movie movie) {
        movieDb.put(movie.getName(), movie);
    }

    public void addDirector(Director director) {
        directorDb.put(director.getName(), director);
    }

    public void addMovieDirectorPair(String movie, String director) {
        ArrayList<String> movies = movieDirectorDb.getOrDefault(director,new ArrayList<>());
        movies.add(movie);
        movieDirectorDb.put(director, movies);
    }

    public Movie getMovieByName(String name) {
        return movieDb.get(name);
    }

    public Director getDirectorByName(String name) {
        return directorDb.get(name);
    }

    public ArrayList<String> getMoviesByDirectorName(String director) {
        return movieDirectorDb.getOrDefault(director,new ArrayList<>());
    }

    public ArrayList<String> findAllMovies() {
        return new ArrayList<>(movieDb.keySet());
    }

    public void deleteMovie(String movi) {
        movieDb.remove(movi);
    }

    public void deleteDirectorByName(String director) {
        directorDb.remove(director);
        movieDirectorDb.remove(director);
    }

    public ArrayList<String> getAllDirector() {
        return new ArrayList<>(directorDb.keySet());
    }
}
