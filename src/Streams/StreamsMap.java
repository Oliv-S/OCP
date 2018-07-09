package Streams;

import java.util.Arrays;
import java.util.List;

public class StreamsMap {

	public static void main(String[] args) {
		
		List<String> stringList = Arrays.asList("One", "Two", "Three", "Four", "Five", "Six", "Seven");
		System.out.println(stringList);

		stringList.stream().map(String::length).forEach(System.out::println);
		System.out.println("*****");
		stringList.stream()
			.map(String::length)
			.distinct()
			.sorted()
			.forEach(System.out::println);

	}

}
