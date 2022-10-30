package ch.usi.inf.ajp22;

import java.time.LocalDate;

public class Track {

    public enum Genre {
        ROCK, METAL, DISCO, HIP_HOP, INDIE
    }
    private String title;
    private LocalDate releasedDate;
    private Genre genre;

    private int length;

    private int rating;

    public Track(String title, LocalDate releasedDate, Genre genre, int length) {
        this.title = title;
        this.releasedDate = releasedDate;
        this.genre = genre;
        this.length = length;
    }

    public Track(String title, LocalDate releasedDate) {
        this.title = title;
        this.releasedDate = releasedDate;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getReleasedDate() {
        return releasedDate;
    }

    public void setReleasedDate(LocalDate releasedDate) {
        this.releasedDate = releasedDate;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Title: " + this.getTitle() + " Genre: " + this.genre.toString()
                + " Rate: " + this.getRating() + " Length: " +
                this.getLength();
    }
}
