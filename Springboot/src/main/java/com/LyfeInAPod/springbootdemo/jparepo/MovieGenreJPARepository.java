package com.LyfeInAPod.springbootdemo.jparepo;

import org.springframework.data.repository.CrudRepository;

import com.LyfeInAPod.springbootdemo.models.MovieGenre;

/**
 * This is the repository interface, spring boot jpa provides default methods to create update get and delete the entity.
 * Thus no need to implement them manually
 * @author ""
 *
 */
public interface MovieGenreJPARepository extends CrudRepository<MovieGenre, Long> {

}
