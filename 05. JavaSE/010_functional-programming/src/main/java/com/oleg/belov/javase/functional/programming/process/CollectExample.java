package com.oleg.belov.javase.functional.programming.process;

import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;
import static java.util.stream.Collectors.toCollection;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.oleg.belov.javase.functional.programming.collectors.StringCollector;
import com.oleg.belov.javase.functional.programming.data.Album;
import com.oleg.belov.javase.functional.programming.data.Artist;
import com.oleg.belov.javase.functional.programming.utils.SampleDataUtils;

public class CollectExample {

	public static void run() {
		System.out.println(">>>>>>>>>>>>>>>>CollectExample<<<<<<<<<<<<<<<<<<<<<<<");
		
		List<Album> albums = SampleDataUtils.getAllAlbumsList();
		
		findingLongTraks(albums);
		findArtistsInTheGroups(albums);
		findArtistsInTheGroupsToLinkedList(albums);
		showArtistNames(albums);
		showArtistNamesJoiningWith3Parameters(albums);
		showArtistNamesWithOwnCollector(albums);
		
		System.out.println("--------------------------------------------------------\n");
	}

	private static void findingLongTraks(List<Album> albums) {
		System.out.println("------------------------findingLongTraks(collect-toSet-example)--------------------------------\n");
		
		Set<String> trackNames = albums.stream()
						.flatMap(album -> album.getTracks())
						.filter(track -> track.getLength() > 60)
						.map(track -> track.getName())
						.collect(toSet());
		
		trackNames.forEach(System.out::println);
	}

	private static void findArtistsInTheGroups(List<Album> albums) {
		System.out.println("------------------------findArtistsInTheGroups(collect-toList-example)--------------------------------\n");
		
		List<Artist> artistss = albums.stream().flatMap(album -> album.getMusicians())
		                .filter(artist -> artist.getName().startsWith("The"))
		                .map(group -> group.getMembers())
		                .flatMap(artist -> artist)
		                .collect(toList());
		
		artistss.forEach(System.out::println);
	}
	
	private static void findArtistsInTheGroupsToLinkedList(List<Album> albums) {
		System.out.println("------------------------findArtistsInTheGroupsToLinkedList(collect-toCollection-example)--------------------------------\n");
		
		List<Artist> artistss = albums.stream().flatMap(album -> album.getMusicians())
		                .filter(artist -> artist.getName().startsWith("The"))
		                .map(group -> group.getMembers())
		                .flatMap(artist -> artist)
		                .collect(toCollection(LinkedList<Artist>::new));
		
		artistss.forEach(System.out::println);
	}
	
	private static void showArtistNames(List<Album> albums) {
		System.out.println("------------------------showArtistNames(collect-joining-example)--------------------------------\n");
		
		String artistNames = albums.stream().flatMap(album -> album.getMusicians())
						.map(artist -> artist.getName())
						.distinct()
		                .collect(Collectors.joining(", "));
		
		System.out.println(artistNames);
	}
	
	private static void showArtistNamesJoiningWith3Parameters(List<Album> albums) {
		System.out.println("------------------------showArtistNamesJoiningWith3Parameters(collect-joining-with-3-parameters-example)--------------------------------\n");
		
		String artistNames = albums.stream().flatMap(album -> album.getMusicians())
						.map(artist -> artist.getName())
						.distinct()
		                .collect(Collectors.joining(", ", "[ ", " ]"));
		
		System.out.println(artistNames);
	}
	
    public static void showArtistNamesWithOwnCollector(List<Album> albums) {
    	System.out.println("------------------------showArtistNamesWithOwnCollector(collect-joining-manual-example)--------------------------------\n");
    	
    	String artistNames = albums.stream().flatMap(album -> album.getMusicians())
						.map(artist -> artist.getName())
						.distinct()
				        .collect(new StringCollector(", ", "[", "]"));
    	
    	System.out.println(artistNames);
    }
}

