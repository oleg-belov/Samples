package com.oleg.belov.javase.functional.programming.process;

import static java.util.stream.Collectors.toList;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

import com.oleg.belov.javase.functional.programming.data.Album;
import com.oleg.belov.javase.functional.programming.utils.SampleDataUtils;

public class MapExample {

	public static void run() {
		System.out.println(">>>>>>>>>>>>>>>>MapExample<<<<<<<<<<<<<<<<<<<<<<<");
		
		List<Album> albums = SampleDataUtils.getAllAlbumsList();
		
		findingLongTraksDoubleForEach(albums);
		findingLongTraksFlatMap(albums);
		showMuziciansNamesAndOrigins(albums);
		
		System.out.println("--------------------------------------------------------\n");
	}

	private static void findingLongTraksDoubleForEach(List<Album> albums) {
		System.out.println("------------------------findingLongTraksDoubleForEach(map-example)--------------------------------\n");
		
		Set<String> trackNames = new HashSet<>();
		
		albums.stream().forEach(album -> {
			album.getTracks()
				.filter(track -> track.getLength() > 60)
				.map(track -> track.getName())
				.forEach(name -> trackNames.add(name));
		});
		
		trackNames.forEach(System.out::println);
	}

	private static void findingLongTraksFlatMap(List<Album> albums) {
		System.out.println("------------------------findingLongTraksFlatMap(flatMap-example)--------------------------------\n");
		
		Set<String> trackNames = new HashSet<>();
		
		albums.stream()
					.flatMap(album -> album.getTracks())
					.filter(track -> track.getLength() > 60)
					.map(track -> track.getName())
					.forEach(name -> trackNames.add(name));
		
		trackNames.forEach(System.out::println);
	}

	private static void showMuziciansNamesAndOrigins(List<Album> albums) {
		System.out.println("------------------------showMuziciansNamesAndOrigins(flatMap-example)--------------------------------\n");
		
		List<String> namesAndOrigins = albums.stream()
					.flatMap(album -> album.getMusicians())
					.flatMap(artist -> Stream.of(artist.getName(), artist.getNationality()))
					.collect(toList());
		
		namesAndOrigins.forEach(System.out::println);
	}
}