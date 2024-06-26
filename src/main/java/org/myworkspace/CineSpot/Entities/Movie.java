package org.myworkspace.CineSpot.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.myworkspace.CineSpot.DTOs.Responses.MovieResponse;
import org.myworkspace.CineSpot.Entities.enums.Genre;

import java.io.Serializable;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Movie implements Serializable {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @Enumerated(EnumType.STRING)
    private Genre genre;

    private Double rating;

    private Integer releaseYear;

    @OneToMany(mappedBy = "movie")
    private List<Review> reviews;

    public MovieResponse toMovieResponse(){
        return MovieResponse.builder().releaseYear(this.releaseYear).genre(this.genre).title(this.title)
                .rating(this.rating).reviews(Review.toReviewResponse(this.reviews)).build();
    }

}


