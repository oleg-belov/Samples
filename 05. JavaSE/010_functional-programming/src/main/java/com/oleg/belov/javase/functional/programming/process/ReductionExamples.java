package com.oleg.belov.javase.functional.programming.process;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

import com.oleg.belov.javase.functional.programming.data.Album;
import com.oleg.belov.javase.functional.programming.data.Artist;
import com.oleg.belov.javase.functional.programming.data.Track;
import com.oleg.belov.javase.functional.programming.utils.SampleDataUtils;

public class ReductionExamples {
	public static void run() {
		System.out.println(">>>>>>>>>>>>>>>>ReductionExamples<<<<<<<<<<<<<<<<<<<<<<<");
		
		List<Album> albums = SampleDataUtils.getAllAlbumsList();
		List<Artist> artists = SampleDataUtils.getThreeArtists();

		showMembersInGroups(artists);
		showGroups(artists);
		findingLongTraks(albums);
		showArtistNames(albums);
		
		
		
		System.out.println("--------------------------------------------------------\n");
	}

	private static void showMembersInGroups(List<Artist> artists) {
		System.out.println("------------------------showMembersInGroups(reduce-example)--------------------------------\n");
		
		System.out.println(
				"The total artists in groups are : "
				+ artists.stream()
                	.map(artist -> artist.getMembers().count())
                	.reduce(0L, Long::sum)
                	.intValue()
        );
	}

	private static void showGroups(List<Artist> artists) {
		System.out.println("------------------------showGroups(filter-using-reduce-example)--------------------------------\n");
		
		filterUsingReduce(artists.stream(), artist -> artist.getMembers().count() > 0).forEach(System.out::println);
	}
	
	private static <I> List<I> filterUsingReduce(Stream<I> stream, Predicate<I> predicate) {
        List<I> initial = new ArrayList<>();
        return stream.reduce(initial,
                             (List<I> acc, I x) -> {
                                if (predicate.test(x)) {
                                	// We are copying data from acc to new list instance. It is very inefficient,
                                	// but contract of Stream.reduce method requires that accumulator function does
                                	// not mutate its arguments.
                                	// Stream.collect method could be used to implement more efficient mutable reduction,
                                	// but this exercise asks to use reduce method explicitly.
                                	List<I> newAcc = new ArrayList<>(acc);
                                    newAcc.add(x);
                                    return newAcc;
                                } else {
                                	return acc;
                                }
                             },
                             ReductionExamples::combineLists);
    }

    private static <I> List<I> combineLists(List<I> left, List<I> right) {
    	// We are copying left to new list to avoid mutating it. 
    	List<I> newLeft = new ArrayList<>(left);
    	newLeft.addAll(right);
        return newLeft;
    }
    
    private static void findingLongTraks(List<Album> albums) {
		System.out.println("------------------------findingLongTraksFlatMap(map-using-reduce-example)--------------------------------\n");
		Stream<Track> tracks = albums.stream()
					.flatMap(album -> album.getTracks())
					.filter(track -> track.getLength() > 60);
		
		map(tracks, track -> track.getName()).forEach(System.out::println);
	}
    
    private static <I, O> List<O> map(Stream<I> stream, Function<I, O> mapper) {
        return stream.reduce(new ArrayList<O>(), (acc, x) -> {
        	// We are copying data from acc to new list instance. It is very inefficient,
        	// but contract of Stream.reduce method requires that accumulator function does
        	// not mutate its arguments.
        	// Stream.collect method could be used to implement more efficient mutable reduction,
        	// but this exercise asks to use reduce method.
        	List<O> newAcc = new ArrayList<>(acc);
        	newAcc.add(mapper.apply(x));
            return newAcc;
        }, (List<O> left, List<O> right) -> {
        	// We are copying left to new list to avoid mutating it. 
        	List<O> newLeft = new ArrayList<>(left);
        	newLeft.addAll(right);
            return newLeft;
        });
    }
    
    private static void showArtistNames(List<Album> albums) {
		System.out.println("------------------------showArtistNames(collect-joining--using-reduce-example)--------------------------------\n");
		
		String artistNames = albums.stream().flatMap(album -> album.getMusicians())
				.map(artist -> artist.getName())
				.distinct()
				.reduce("", (n1, n2) -> n1 
						+ (n1.isEmpty() ? "" : ", ") 
						+ n2);
		
		System.out.println(artistNames);
	}
}
