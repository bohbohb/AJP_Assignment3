package ch.usi.inf.ajp22;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class SampleData {

    /*
     * Guns N Roses - Appetite for destruction
     */
    private static Artist gunsNroses = new Artist("Guns N' Roses", "G N' R");
    private static Track welcomeToTheJungle = new Track("Welcome to the Jungle",
            LocalDate.of(1987, 9, 28),
            Track.Genre.ROCK, 273);
    private static Track nighTrain = new Track("Nigh train",
            LocalDate.of(1989, 6, 25),
            Track.Genre.ROCK, 268);
    private static Track mrBrownstone = new Track("Mr. Brownstone",
            LocalDate.of(1987, 6, 15),
            Track.Genre.ROCK, 229);
    public static Album appetiteForDestruction = new Album(Arrays.asList(welcomeToTheJungle, nighTrain, mrBrownstone),
            gunsNroses,
            "Appetite for Destruction");

    private static Artist daftPunk = new Artist("Daft Punk");

    private static Track giveLifeBackToMusic = new Track("Give Life Back to Music",
            LocalDate.of(2014, 1, 31),
            Track.Genre.DISCO, 273);

    private static Track instantCrush = new Track("Instant Crush",
            LocalDate.of(2013, 11, 22),
            Track.Genre.DISCO, 387);

    private static Track getLucky = new Track("Get Lucky",
            LocalDate.of(2013, 4, 19),
            Track.Genre.DISCO, 247);

    public static Track oneMoreTime = new Track("One More Time",
            LocalDate.of(2000, 11, 13),
            Track.Genre.DISCO, 321);

    public static Track crescenDolls = new Track("Crescendolls",
            LocalDate.of(2001, 3, 13),
            Track.Genre.DISCO, 208);

    public static Album randomAccessMemories = new Album(Arrays.asList(giveLifeBackToMusic,
            instantCrush, getLucky), daftPunk, "Random Access Memories");

    public static Album discovery = new Album(Arrays.asList(oneMoreTime, crescenDolls), daftPunk, "Discovery");

    private static final List<Track> shuffledTrack = Arrays.asList(giveLifeBackToMusic, getLucky,
            mrBrownstone, welcomeToTheJungle, instantCrush, nighTrain);

    private static List<Album> albumList = Arrays.asList(randomAccessMemories, appetiteForDestruction, discovery);
    private static List<Artist> artistList = Arrays.asList(daftPunk, gunsNroses);


    private static List<Track> repeatedTrack = Arrays.asList(welcomeToTheJungle, welcomeToTheJungle,
            nighTrain, instantCrush, instantCrush);

    public static List<Artist> getArtistList() {
        return artistList;
    }

    public static List<Album> getAlbumList() {
        return albumList;
    }

    public static List<Track> getShuffledTrack() {
       return shuffledTrack;
    }

    public static List<Track> getRepeatedTrack() {
        return repeatedTrack;
    }
}
