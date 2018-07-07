package Streams;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

public class StreamsSources {

	public static void main(String[] args) {
		
		Stream<String> emptyStream = Stream.empty();
		
		Stream<String> streamFromArray = Stream.of("One", "Two", "Three");
		streamFromArray.forEach(System.out::println);
		System.out.println("***");
		
		List<String> listOfStrings = Arrays.asList("One", "Two", "Three");
		Stream<String> streamFromList = listOfStrings.stream();
		Stream<String> streamFromListParallel = listOfStrings.parallelStream();
		streamFromList.forEach(System.out::println);
		System.out.println("***");
		streamFromListParallel.forEach(System.out::println);
		System.out.println("***");

		Random rnd = new Random();
		Stream<Double> streamOfDouble = Stream.generate(rnd::nextDouble);
		streamOfDouble.limit(5).forEach(System.out::println);
		System.out.println("***");

		Stream<Integer> streamOfInteger = Stream.iterate(0, x->++x);
		streamOfInteger.limit(5).forEach(System.out::println);
		System.out.println("***");
		
		Stream<Integer> streamOfInteger2 = Stream.iterate(1, x->x*3);
		streamOfInteger2.limit(5).forEach(System.out::println);
		System.out.println("***");
		
		
	}

}
