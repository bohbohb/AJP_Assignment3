package ch.usi.inf.ajp22;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.*;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.IntFunction;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    /**
     * 3 Points
     * TODO: create a public static Album method called "longestTitle".
     *       If the maximum is not found throw a RuntimeException.
     *       input: a list of Album
     *       output: the Album with the longest title.
     */
    public static Album longestTitle(List<Album> albums) {
        return albums
                .stream()
                .max(Comparator.comparingInt(album -> album.getTitle().length()))
                .orElseThrow(RuntimeException::new);
    }

    /**
     * 4 Points
     * TODO: create a public static int method called "sumOfRatingReduce".
     *       input: an Album instance.
     *       output: int that is the sum of all the tracks ratings in the album.
     * Use the method getTracks from the Album class to get the List of tracks.
     * You MUST use the reduce method, in the variant which takes as input an identity, an accumulator and a combiner.
     * If possible use method references.
     */
    public static int sumOfRatingReduce(Album albums) {
        return albums
                .getTracks()
                .stream()
                .reduce(0, (accumulated, track2) -> accumulated + track2.getRating(), Integer::sum);
    }

    /**
     * 4 Points
     * TODO: create a public static int method called "sumOfRatingCollection".
     *       input: an Album instance.
     *       output: int that is the sum of all the tracks ratings in the album
     * Use the method getTracks from the Album class to get the List of tracks.
     * You MUST use one variant of the collect method. If possible use method references.
     */
    public static int sumOfRatingCollection(Album album) {
        return album
                .getTracks()
                .stream()
                .collect(Collectors.summingInt(Track::getRating));
    }

    /**
     * 4 Points
     * TODO: create a public static int method called "sumOfRatingMap"
     *       input: an ch.usi.inf.ajp22.Album instance.
     *       output: int that is the sum of all the tracks ratings in the album.
     * Use the method getTracks from the Album class to get the List of tracks.
     * You MUST use the mapToInt method. If possible use method references.
     */
    public static int sumOfRatingMap(Album album) {
        return album.getTracks()
                .stream()
                .mapToInt(Track::getRating)
                .sum();
    }

    /**
     * 4 Points
     * TODO: create a public static Map<String, Long> method called "countTrackOccurrence"
     *       input: a list of Track
     *       output: a Map<String, Long> where the key is the track title and the value is, how many times
     *       the same song occurs in the list.
     *       Two songs can be considered the same if they have the same title.
     */
    public static Map<String, Long> countTrackOccurrence(List<Track> trackList) {
        return trackList
                .stream()
                .collect(Collectors.groupingBy(Track::getTitle, Collectors.counting()));
    }

    /**
     * 4 Points
     * TODO: create a public static Map<Artist, List<Album>> method called "groupAlbumByArtist".
     *       input: a list of Album
     *       output: a Map<Artist, List<Album>> where the key is an Artist and the value is a List of Album which
     *       this artist had produced.
     */

    /**
     * 4 Points
     * TODO: create a public static List<Track> method called "trackFilteredWithPredicate".
     *       input: a stream of tracks and a predicate to apply to the track stream.
     *       output: a List of Track that has been filtered according to the predicate taken as input.
     */

    /**
     * 5 Points
     * TODO: create a public static Stream<Album> method called getAlbumWithAtLeastNTracks
     *       input: a list of Album AND an int called "n"
     *       output: a List<Album> where every album in this stream has at least "n" tracks.
     */

    /**
     * 5 Points
     * TODO: create a public static void method called "printTrackStatistics".
     *       input: an Album instance
     * Print Track Statistics based on the length of the tracks of an album taken as input in the following format:
     * ===
     * "Stat for: %s\n", album.getTitle())
     * "Max: %d\nMin: %d\nAve: %f\n"
     * ===
     * Use the method getTracks from the Album class to get the List of tracks.
     * Input: an Album
     */

    /**
     * 5 Points
     * TODO: create a public static String method called "getArtistNameAndNickNameFromAlbum".
     *       Each author should appear only once.
     *       input: a list of Album
     *       output: a String in the following format:
     *       [artist1.name - artist1.nickname, artist2.name - artist2.nickname, ...]
     */

    /**
     * 5 Points
     * TODO: create a public Track method called "combineAllTrackInAlbum"
     *       input: a stream of track
     *       output: return a new ch.usi.inf.ajp22.Track with the following values:
     *               title -> "fake title"
     *               releaseDate -> LocaleDate.now()
     *               genre -> DISCO
     *               length -> the sum of all the lengths in the input track stream.
     *       The pipeline processing must be done in parallel.
     *       You MUST use the collect method, in the variant which takes as input a supplier, an accumulator and a
     *       combiner.
     */

    /**
     * 5 Points
     * TODO: create a public static Map<Artist, List<Track>> method called "groupTrackByArtist".
     *       input: a list of Album
     *       output: a Map<Artist, List<Track>> where the key is an Artist and the value is a List of Track which
     *       this artist had produced.
     */

    /**
     * 5 Bonus Points
     * TODO: create a public static <T> T[] method called "createArray".
     *       This method must create a generic array where the elements are in the same order as in the
     *       input Collection.
     *       In this function you need neither streams nor lambda.
     *       input: a Collection<T> and an IntFunction<T[]>
     *       output: an array of generic type
     */


    private static void writeToFile(String s) throws IOException {
        BufferedWriter fw = new BufferedWriter(new FileWriter("artist.txt", true));
        fw.write(s);
        fw.close();
    }

    public static void main(String[] args) {
        Random random = new Random();

        /**
         * Initializing some SampleData
         */
        SampleData.appetiteForDestruction
                        .getTracks().forEach(track ->
                        track.setRating(random.nextInt(5)));

        SampleData.randomAccessMemories
                        .getTracks().forEach(track ->
                        track.setRating(random.nextInt(5)));

        /**
         * 2 Points
         * TODO: Replace the Anonymous class below with a lambda expression.
         */
        BinaryOperator<Track> mixTrack = new BinaryOperator<>() {
            @Override
            public Track apply(Track t1, Track t2) {
                return new Track(t1.getTitle(),
                        t1.getReleasedDate(),
                        t2.getGenre(),
                        t2.getLength());
            }
        };

        /**
         * 3 Points
         * TODO: Create a stream pipeline that:
         *       1) filter all the tracks that have at least 4 as rating
         *       2) sort the filtered tracks using the title field
         *       3) print the tracks
         */

        /**
         * 4 Points
         * TODO: Print on file the artist's name, obtained with the method SampleData.getArtistList(),
         *       using the writeToFile method. Use a lambda expression and handle
         *       the throw exception from the writeToFile method. If there is an IOException you must throw a
         *       RuntimeException with the same event.
         */

        System.out.printf("Longest track in %s is %s\n",
                SampleData.appetiteForDestruction.getTitle(),
                SampleData.appetiteForDestruction.searchLongestSong().isPresent() ?
                        SampleData.appetiteForDestruction.searchLongestSong().get().getTitle() :
                        "Not found");

        System.out.printf("Ordered song in %s\n",
                SampleData.appetiteForDestruction.getTitle());
        SampleData.appetiteForDestruction.orderSongByTitle()
                .forEach(System.out::println);

        printTrackStatistics(SampleData.appetiteForDestruction);
        printTrackStatistics(SampleData.randomAccessMemories);

        SampleData.appetiteForDestruction
                .getTracks().forEach(System.out::println);
        System.out.print("Tot rating for:\n" + SampleData.appetiteForDestruction.getTitle());
        System.out.printf("\ttot rating (Reduce): %d\n", sumOfRatingReduce(SampleData.appetiteForDestruction));
        System.out.printf("\ttot rating (Collection): %d\n", sumOfRatingCollection(SampleData.appetiteForDestruction));
        System.out.printf("\ttot rating (mapToInt): %d\n", sumOfRatingMap(SampleData.appetiteForDestruction));

        System.out.println("Tot occurrence in the following list are\n");
        SampleData.getRepeatedTrack()
                .forEach(System.out::println);
        Map<String, Long> titleOccurrence = countTrackOccurrence(SampleData.getRepeatedTrack());

        for (Map.Entry<String, Long> entry : titleOccurrence.entrySet()) {
            System.out.printf("Title: %s occurrence: %d\n",
                    entry.getKey(), entry.getValue());
        }

        Map<Artist, List<Album>> artistListMap = groupAlbumByArtist(SampleData.getAlbumList());

        for (Map.Entry<Artist, List<Album>> entry : artistListMap.entrySet()) {
            System.out.println("ch.usi.inf.ajp22.Artist: " + entry.getKey().getName());
            for (Album album : entry.getValue()) {
                System.out.println("\t" + album.getTitle());
            }
        }

        Map<Artist, List<Track>> artistListMap1 = groupTrackByArtist(SampleData.getAlbumList());
        for (Map.Entry<Artist, List<Track>> entry : artistListMap1.entrySet()) {
            System.out.println("ch.usi.inf.ajp22.Artist: " + entry.getKey().getName());
            for (Track track: entry.getValue()) {
                System.out.println("\t" + track.toString());
            }
        }

        List<Track> trackPOPinGuns = trackFilteredWithPredicate(SampleData.appetiteForDestruction.getTracks().stream()
                ,(t -> !t.getGenre().equals(Track.Genre.HIP_HOP)));
        trackPOPinGuns
                .forEach(System.out::println);

        getAlbumWithAtLeastNTracks(SampleData.getAlbumList(), 3)
                .forEach(System.out::println);

        System.out.println("Getting artist name " + getArtistNameAndNickNameFromAlbum(SampleData.getAlbumList()));

        System.out.println("ch.usi.inf.ajp22.Album with the longest name is " + longestTitle(SampleData.getAlbumList()));

        Album[] albumsArray = createArray(SampleData.getAlbumList(), Album[]::new);

        System.out.println("ch.usi.inf.ajp22.Album array");
        for (int i = 0; i < albumsArray.length; i++) {
            System.out.println(albumsArray[i]);
        }

        Track combinedTrack = combineAllTrackInAlbum(SampleData.appetiteForDestruction.getTracks().stream());
        System.out.println(combinedTrack);

    }
}
