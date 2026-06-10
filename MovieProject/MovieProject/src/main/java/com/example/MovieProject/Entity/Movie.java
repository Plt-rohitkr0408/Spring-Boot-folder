package com.example.MovieProject.Entity;

public class Movie {
    private Long id;
    private String movieName;
    private Integer movieYear;
    private Double movieRating;
    private String genre;
    private String Director;

    public Movie(){}
    public Movie(Long id, String movieName, Integer movieYear, Double movieRating, String genre , String Director) {
        this.id = id;
        this.movieName = movieName;
        this.movieYear = movieYear;
        this.movieRating = movieRating;
        this.genre = genre;
        this.Director = Director;
    }

    public String getDirector() {
        return Director;
    }
    public void setDirector(String Director) {
        this.Director = Director;
    }

    public String getGenre() {
        return genre;
    }

    public Double getMovieRating() {
        return movieRating;
    }

    public Integer getMovieYear() {
        return movieYear;
    }

    public String getMovieName() {
        return movieName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setMovieRating(Double movieRating) {
        this.movieRating = movieRating;
    }

    public void setMovieYear(Integer movieYear) {
        this.movieYear = movieYear;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    @Override
    public String toString() {
        return "id" +" -> " + id + "," + "movieName" +" -> " + movieName + "," + "movieYear" +" -> " + movieYear + ","+ "movieRating" +" -> " + movieRating + "," + "genre" +" -> " + genre;
    }
}
