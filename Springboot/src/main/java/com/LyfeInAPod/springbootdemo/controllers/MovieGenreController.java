package com.LyfeInAPod.springbootdemo.controllers;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.LyfeInAPod.springbootdemo.models.MovieGenre;
import com.LyfeInAPod.springbootdemo.service.MovieGenreService;
import com.LyfeInAPod.springbootdemo.utils.MovieGenreException;

@Controller
public class MovieGenreController {

    Logger LOG = LoggerFactory.getLogger(MovieGenreController.class);

    @Autowired
    private MovieGenreService service;

    @GetMapping("/")
    public String index(Model model) {
        LOG.info("Initiating home page");
        LOG.info("Fetching all movie genres");
        List<MovieGenre> movies = service.getAllMovieGenre();
        model.addAttribute("moviegenres", movies);
        return "home";
    }

    @GetMapping("/moviegenre/add/form")
    public String getGenreAddForm(MovieGenre moviegenre, Model model) {
        LOG.info("Fetching add form");
        model.addAttribute("moviegenre", new MovieGenre());
        return "add-form";
    }

    @PostMapping("/moviegenre/add")
    public String addMovieGenre(@Valid @ModelAttribute("moviegenre") MovieGenre moviegenre, BindingResult result, Model model) {
        try {
            if (result.hasErrors()) {
                return "add-form";
            }

            LOG.info("Adding movie genre");
            service.addMovieGenre(moviegenre);

            model.addAttribute("moviegenres", service.getAllMovieGenre());

        } catch (MovieGenreException e) {
            LOG.error("Failed to add movie genre");
            LOG.error(e.getErrorMessage());
            model.addAttribute("error", e.getErrorMessage());
        }
        return "home";
    }

    @GetMapping("/moviegenre/update/form/{id}")
    public String getGenreUpdateForm(@PathVariable("id") Long id, Model model) {
        LOG.info("Fetching update form for Id: " + id);
        MovieGenre movie = service.getMovieGenreById(id);
        model.addAttribute("moviegenre", movie);
        return "update-form";
    }

    @PostMapping("/moviegenre/update/{id}")
    public String updateMovieGenre(@PathVariable("id") Long id, @Valid @ModelAttribute("moviegenre") MovieGenre moviegenre, BindingResult result, Model model) {
        try {
            LOG.info("updating movie genre");
            if (result.hasErrors()) {
                moviegenre.setId(id);
                return "update-form";
            }
            service.updateMovieGenre(moviegenre);

            model.addAttribute("moviegenres", service.getAllMovieGenre());

        } catch (MovieGenreException e) {
            LOG.error("Failed to update movie genre");
            LOG.error(e.getErrorMessage());
            model.addAttribute("error", e.getErrorMessage());
        }
        return "home";
    }

    @GetMapping("/moviegenre/delete/{id}")
    public String deleteMovieGenre(@PathVariable("id") Long id, Model model) {
        LOG.info("Deleting movie genre for id: " + id);
        service.deleteMovieGenre(id);
        model.addAttribute("moviegenres", service.getAllMovieGenre());
        return "home";

    }

}
