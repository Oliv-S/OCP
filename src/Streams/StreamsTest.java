package Streams;

import java.util.stream.Stream;

public class StreamsTest {

	public static void main(String[] args) {
		Stream<String> stream = Stream.iterate("",s->s+"1");
		stream.limit(2).map(x->x+"2").forEach(System.out::println);;

	}

}
