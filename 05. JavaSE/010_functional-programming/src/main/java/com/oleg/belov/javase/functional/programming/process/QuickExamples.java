package com.oleg.belov.javase.functional.programming.process;

import static java.util.stream.Collectors.toList;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Stream;

import org.springframework.core.io.ClassPathResource;

import com.oleg.belov.javase.functional.programming.data.Album;
import com.oleg.belov.javase.functional.programming.data.Track;
import com.oleg.belov.javase.functional.programming.utils.SampleDataUtils;

public class QuickExamples {
	public static void run() throws InterruptedException {
		System.out.println(">>>>>>>>>>>>>>>>QuickExamples<<<<<<<<<<<<<<<<<<<<<<<");
		
		forEachLmbdaExample();
		forEachMetodReferenceExample();
        concurrentExamples();
        composeExample();
        optionalExamples();
        functionalInterfaceExample();
        collectionExamples();
        readLineExample();
        countLetters();
        generateSeqenceAndFilterEvensLimit5();
        generateExample();
        skipExample();
        distinctExample();
        sortExample();
        sortComparatorExample();
        
        System.out.println("--------------------------------------------------------");
	}

	private static void forEachLmbdaExample() {
    	System.out.println("------------------------showMembersInGroups(forEach-lmbda-example)--------------------------------\n");
    	
    	 Integer arr[] = {1, 2, 3, 4, 5};
    	 Consumer<Integer> print = x -> System.out.println("forEachLmbdaExample: " + x);
    	 
         Arrays.asList(arr).forEach(print);
	}
    
    private static void forEachMetodReferenceExample() {
    	System.out.println("---------forEachMetodReferenceExample(create-stream-from-array-and-metod-reference-example)---------\n");
    	
    	Integer arr[] = {1, 2, 3, 4, 5};
   	 	Function<Integer, String> concatStrings = x -> "MetodReferenceExample: " + x;
   	 
   	 	Stream.of(arr).map(concatStrings).forEach(System.out::println);
	}
    
    private static void concurrentExamples() {
    	System.out.println("---------concurrentExamples(concurency-and-paralelization-example)---------\n");
    	
        Stream<Integer> stream = Stream.of(12, 52, 32, 74, 25);
        Function<Integer, Integer> multiplyByTwo = x -> x * 2;
        
        stream.map(multiplyByTwo).forEach(System.out::println);
        
        System.out.println("---");
        
        stream = Stream.of(12, 52, 32, 74, 25);
        stream.parallel().map(multiplyByTwo).forEach(System.out::println);
    }

    private static void composeExample() {
    	System.out.println("---------composeExample(compose-and-andThen-example)---------\n");
    	
        Function<Integer, Integer> absThenNegate
                = ((Function<Integer, Integer>) Math::negateExact).compose(Math::abs);
        Function<Integer, Integer> negateThenAbs
                = ((Function<Integer, Integer>) Math::negateExact).andThen(Math::abs);

        System.out.println(absThenNegate.apply(-25));
        System.out.println(absThenNegate.apply(25));
        
        System.out.println("---");
        
        System.out.println(negateThenAbs.apply(-25));
        System.out.println(negateThenAbs.apply(25));
    }

    public static Optional<Album> findAlbumWithID(long id) {
        //...
        return Optional.empty();
    }

    private static void optionalExamples() {
        Optional<Album> optionalCustomer = findAlbumWithID(123);
        if (optionalCustomer.isPresent()) {
        	Album album = optionalCustomer.get();
        	
        	System.out.println(album);
        } else {
            // handle missing value
        }
    }

    private static void functionalInterfaceExample() throws InterruptedException {
    	System.out.println("---------functionalInterfaceExample(functional-interface-example)---------\n");
    	
        new Thread(() -> {
            new Random().ints().limit(5).sorted().forEach(x -> System.out.println("Thread-" + x));
        }).start();
        
        Thread.sleep(400);
    }

    private static void collectionExamples() {
    	System.out.println("---------collectionExamples(collection-iteration-example)---------\n");
    	
        Stream<Album> stream = SampleDataUtils.getAllAlbumsStream();
        stream.forEach(album -> System.out.println(album + " - " + album.getMusicianList().size()));
    }
    
    private static void readLineExample() {
    	System.out.println("---------readLineExample(create-stream-from-file-example)---------\n");
    	
    	try {
			Files.lines(Paths.get(new ClassPathResource("data.txt").getURI())).forEach(System.out::println);
		} catch (IOException ignore) {
			ignore.printStackTrace();
		}
    }
    
    public static void countLetters() {
    	System.out.println("---------countLetters(create-stream-from-string-example)---------\n");
    	
        long strLength =  "Lambdas".chars().count();
        
        System.out.println("\'Lambdas\' have: " + strLength + " chars..");
    }
    
    private static void generateSeqenceAndFilterEvensLimit5() {
		System.out.println("------------------------generateSeqenceAndFilterEvensLimit5(iter-limit-example)--------------------------------\n");
		
		Stream.iterate(0, x -> x + 1).filter(x -> x % 2 == 0).limit(5).forEach(System.out::println);
	}
	
	private static void generateExample() {
		System.out.println("------------------------generateExample(generate-example)--------------------------------\n");
		
		Stream.generate(() -> "hello world").limit(3).forEach(System.out::println);
	}
	
	private static void skipExample() {
		System.out.println("------------------------skipExample(skip-example)--------------------------------\n");
		
		Stream.iterate(0, x -> x + 1).skip(5).limit(5).forEach(System.out::println);
	}
	
	private static void distinctExample() {
		System.out.println("------------------------distinctExample(distinct-example)--------------------------------\n");
		
		Stream.of(1, 2, 4, 5, 4, 5, 1, 2).distinct().forEach(System.out::println);
	}
	
	private static void sortExample() {
		System.out.println("------------------------sortExample(sorted-example)--------------------------------\n");
		
		Stream.of(4, 5, 4, 5, 1, 2).sorted().forEach(System.out::println);
	}
	

	private static void sortComparatorExample() {
		System.out.println("------------------------sortComparatorExample(sorted-comparator-example)--------------------------------\n");
		
		List<Album> albums = SampleDataUtils.getAllAlbumsList();
		
		List<Track> sortedTraks = albums.stream()
				.flatMap(album -> album.getTracks())
				.sorted((t1, t2 ) -> ((Integer) t1.getLength()).compareTo((Integer) t2.getLength()))
				.collect(toList());
		
		sortedTraks.forEach(System.out::println);
	}
}
