package Streams;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FlatMapExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stream<String> cats = Stream.of("Leopard", "Lynx", "Ocelot");
		Stream<String> dogs = Stream.of("Kolli", "Mops", "Dog");
		Stream.of(cats, dogs).forEach(System.out::println);
		System.out.println();
		Stream.of(cats, dogs).flatMap(s->s).forEach(System.out::println);
		System.out.println();
	}

}
