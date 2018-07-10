package Streams;

import java.util.Optional;
import java.util.OptionalLong;

import java.util.stream.Stream;

public class StreamsTest {

	public static void main(String[] args) {
		Stream<String> stream = Stream.iterate("",s->s+"1");
<<<<<<< HEAD

		stream.limit(2).map(x->x+"2").forEach(System.out::println);;
		stream.limit(2).map(x->x+"2").forEach(System.out::println);
=======
		stream.limit(2).map(x->x+"2").forEach(System.out::println);;


		
>>>>>>> DatesTimes

	}

}
