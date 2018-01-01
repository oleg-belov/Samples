package com.oleg.belov.javase.functional.programming.process;

import java.util.List;
import java.util.function.Predicate;

import com.oleg.belov.javase.functional.programming.data.Album;
import com.oleg.belov.javase.functional.programming.utils.SampleDataUtils;

public class FilteringExamples {
	public static void run() {
		System.out.println(">>>>>>>>>>>>>>>>FilteringExample<<<<<<<<<<<<<<<<<<<<<<<");
		
		List<Album> albums = SampleDataUtils.getAllAlbumsList();
		
		filterAlbums(albums, isJohnColtaneMainMusician(), "isJohnColtaneMainMusician");
		filterAlbums(albums, isJohnColtaneMainMusician().or(isTheBeatlesMainMusician()), "(isJohnColtaneMainMusician).or(isTheBeatlesMainMusician)");
		filterAndLimitAlbums(albums, isJohnColtaneMainMusician().or(isTheBeatlesMainMusician()), 2L, "(isJohnColtaneMainMusician).or(isTheBeatlesMainMusician) limit 2");
		System.out.println("--------------------------------------------------------\n");
	}

	private static void filterAlbums(List<Album> albums, Predicate<Album> predicate, String filterName) {
		System.out.println("------------------------" + filterName + "(filter-example)--------------------------------\n");
		
		albums.stream().filter(predicate).forEach(System.out::println);
	}
	
	private static Predicate<Album> isJohnColtaneMainMusician() {
		return (x -> x.getMainMusician().getName().equals(SampleDataUtils.johnColtrane.getName()));
	}
	
	private static Predicate<Album> isTheBeatlesMainMusician() {
		return (x -> x.getMainMusician().getName().equals(SampleDataUtils.theBeatles.getName()));
	}
	
	private static void filterAndLimitAlbums(List<Album> albums, Predicate<Album> predicate, long limit,  String filterName) {
		System.out.println("------------------------" + filterName + "(limit-example)--------------------------------\n");
		
		albums.stream().filter(predicate).limit(limit).forEach(System.out::println);
	}
}
