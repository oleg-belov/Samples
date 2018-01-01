package com.oleg.belov.javase.functional.programming.process;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import com.oleg.belov.javase.functional.programming.data.Album;
import com.oleg.belov.javase.functional.programming.utils.SampleDataUtils;

public class CountMaxMinExamples {
	public static void run() {
		System.out.println(">>>>>>>>>>>>>>>>CountMaxMinExamples<<<<<<<<<<<<<<<<<<<<<<<");
		
		List<Album> albums = SampleDataUtils.getAllAlbumsList();
		
		showMusiciansFromUKCount(albums);
		showTheLongestMusicianName(albums);
		showTheShorterMusicianName(albums);
		
		
		System.out.println("--------------------------------------------------------\n");
	}

	private static void showMusiciansFromUKCount(List<Album> albums) {
		System.out.println("------------------------showMusiciansFromUKCount(count-example)--------------------------------\n");
		long count = albums.stream()
				.map(album -> album.getMusicians())
				.flatMap(artist -> artist)
				.filter(artist -> artist.getNationality().equals("UK"))
				.count();
		
		System.out.println("Musicians from UK are :" + count);
		
	}
	
	private static void showTheLongestMusicianName(List<Album> albums) {
		System.out.println("------------------------showTheLongestMusicianName(max-example)--------------------------------\n");
		Optional<String> musicianName = albums.stream()
				.map(album -> album.getMusicians())
				.flatMap(artist -> artist)
				.map(artist -> artist.getName())
				.max(Comparator.comparing(String::length));
		
		System.out.println("The longest musician name is : " + musicianName.get());
	}
	
	private static void showTheShorterMusicianName(List<Album> albums) {
		System.out.println("------------------------showTheShorterMusicianName(min-example)--------------------------------\n");
		Optional<String> musicianName = albums.stream()
				.map(album -> album.getMusicians())
				.flatMap(artist -> artist)
				.map(artist -> artist.getName())
				.min(Comparator.comparing(String::length));
		
		System.out.println("The shorter musician name is : " + musicianName.get());
	}
}