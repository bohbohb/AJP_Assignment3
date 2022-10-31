package ch.usi.inf.ajp22;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Album {

    private List<Track> tracks;
    private Artist artist;
    private String title;

    private static Comparator<Track> byDuration = Comparator.comparingInt(Track::getLength);

    public Album(List<Track> songs, Artist artist, String title) {
        this.tracks = songs;
        this.artist = artist;
        this.title = title;
    }

    public List<Track> getTracks() {
        return tracks;
    }

    public void setTracks(List<Track> tracks) {
        this.tracks = tracks;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 3 Points
     * TODO: create a public Optional<Track> method called "searchLongestSong" that
     *       return the longest Track in the album.
     *       input: void
     *       output: an Optional<Track>
     */
    public Optional<Track> searchLongestSong() {
        return tracks.stream().max(byDuration);
    }

    /**
     * 3 Points
     * TODO: create a public List<Track> method called "orderSongByTitle" that
     *       return the track list ordered lexicographically using the title field.
     *       input: void
     *       output: a List<Track>
     */
    public List<Track> orderSongByTitle() {
        return tracks.stream().sorted(Comparator.comparing(Track::getTitle)).toList();
    }
    @Override
    public String toString() {
        return "ch.usi.inf.ajp22.Album{" +
                "tracks=" + tracks +
                ", artist='" + artist.getName() + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}
