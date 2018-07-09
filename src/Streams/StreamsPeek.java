package Streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamsPeek {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<String> stringList = Arrays.asList("One", "Two", "Three", "Four", "Five", "Six", "Seven");
		stringList.stream().forEach(System.out::println);
		System.out.println("******");
		stringList.stream().peek(System.out::println).map(String::length).forEach(System.out::println);
		System.out.println("******");
		System.out.println(stringList.stream().map(String::length).collect(Collectors.toList()));


	}

}
