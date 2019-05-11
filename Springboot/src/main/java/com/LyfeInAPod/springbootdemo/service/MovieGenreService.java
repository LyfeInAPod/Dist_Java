package com.LyfeInAPod.springbootdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.LyfeInAPod.springbootdemo.jparepo.MovieGenreJPARepository;
import com.LyfeInAPod.springbootdemo.models.MovieGenre;
import com.LyfeInAPod.springbootdemo.utils.AppConstants;
import com.LyfeInAPod.springbootdemo.utils.MovieGenreException;

/**
 * Service layer for interaction between JPA Repo and controllers. 
 * All business logic will be a part of this class
 * @author ""
 *
 */
@Service
public class MovieGenreService {

    @Autowired
    private MovieGenreJPARepository repository;

    /**
     * Creates a new entry into the database
     * @param movieGenre
     * @return
     * @throws MovieGenreException
     */
    public MovieGenre addMovieGenre(MovieGenre movieGenre) throws MovieGenreException {
        movieGenre = repository.save(movieGenre);
        return movieGenre;

    }

    /**
     * Updates an existing entry
     * @param movieGenre
     * @return
     * @throws MovieGenreException
     */
    public MovieGenre updateMovieGenre(MovieGenre movieGenre) throws MovieGenreException {
        movieGenre = repository.save(movieGenre);
        return movieGenre;

    }

    /**
     * Fetches all movie genre details 
     * @return
     */
    public List<MovieGenre> getAllMovieGenre() {

        List<MovieGenre> movies = (List<MovieGenre>) repository.findAll();
        return movies;
    }

    /**
     * Fetches a single entity by the given id
     * @param id
     * @return
     */
    public MovieGenre getMovieGenreById(Long id) {
        MovieGenre movie = repository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException(AppConstants.ERROR_FIELD_INVALID_ID + id));
        return movie;

    }

    /**
     * Deletes the movie genre with the given id
     * @param id
     */
    public void deleteMovieGenre(Long id) {
        repository.deleteById(id);
    }

}
