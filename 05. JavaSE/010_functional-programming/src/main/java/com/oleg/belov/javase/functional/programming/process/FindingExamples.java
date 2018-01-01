package com.oleg.belov.javase.functional.programming.process;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import com.oleg.belov.javase.functional.programming.data.Album;
import com.oleg.belov.javase.functional.programming.utils.SampleDataUtils;

public class FindingExamples {

	public static void run() {
		System.out.println(">>>>>>>>>>>>>>>>FindingExamples<<<<<<<<<<<<<<<<<<<<<<<");
		
		List<Album> albums = SampleDataUtils.getAllAlbumsList();
		
		Optional<Album> firstAlbum = findFirstBigAlbum(albums);
		
		System.out.println(firstAlbum.get() + "\r\n Is not Beatles Album: " + isNotBeatlesAlbum(firstAlbum));
		System.out.println("Are Beatles Albums: " + areBeatlesAlbums(albums));
		System.out.println("Is Present same Beatles Albums? : " + areAnyBeatlesAlbums(albums));
		
        System.out.println("--------------------------------------------------------");
	}

	private static Optional<Album> findFirstBigAlbum(List<Album> albums) {
		System.out.println("------------------------findFirstBigAlbum(findFirst-example)--------------------------------\n");
		
		return albums.stream().filter(album -> album.getTrackList().size() > 4).findFirst();
	}
	
	private static boolean isNotBeatlesAlbum(Optional<Album> firstAlbum) {
		System.out.println("------------------------isNotBeatlesAlbum(noneMatch-example)--------------------------------\n");
		
		return Stream.of(firstAlbum.get()).noneMatch(album -> album.getMainMusician().getName().equals("The Beatles"));
	}

	private static boolean areBeatlesAlbums(List<Album> albums) {
		System.out.println("------------------------areBeatlesAlbums(allMatch-example)--------------------------------\n");
		
		return albums.stream().allMatch(album -> album.getMainMusician().getName().equals("The Beatles"));
	}
	
	private static boolean areAnyBeatlesAlbums(List<Album> albums) {
		System.out.println("------------------------areAnyBeatlesAlbums(anyMatch-example)--------------------------------\n");
		
		return albums.stream().anyMatch(album -> album.getMainMusician().getName().equals("The Beatles"));
	}
}