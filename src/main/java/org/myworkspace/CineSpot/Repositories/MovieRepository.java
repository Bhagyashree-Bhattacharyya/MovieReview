package org.myworkspace.CineSpot.Repositories;

import org.myworkspace.CineSpot.Entities.Genre;
import org.myworkspace.CineSpot.Entities.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MovieRepository extends JpaRepository<Movie, Long> {

    Movie findByTitle(String title);
    List<Movie> findByGenre(Genre genre);
    Optional<Movie> findByTitleAndReleaseYear(String movieTitle, Integer releaseYear);

}