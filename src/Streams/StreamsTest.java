package Streams;

<<<<<<< HEAD
=======
import java.util.Optional;
import java.util.OptionalLong;
>>>>>>> Streams
import java.util.stream.Stream;

public class StreamsTest {

	public static void main(String[] args) {
		Stream<String> stream = Stream.iterate("",s->s+"1");
<<<<<<< HEAD
		stream.limit(2).map(x->x+"2").forEach(System.out::println);;
=======
		stream.limit(2).map(x->x+"2").forEach(System.out::println);
		OptionalLong opt;
		
>>>>>>> Streams

	}

}
