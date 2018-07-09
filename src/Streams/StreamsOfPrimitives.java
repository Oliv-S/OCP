package Streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamsOfPrimitives {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> lst = Arrays.asList(1,2,3,4,7,5,3,8,9,0,5,4,5,6,7,8,56,4,3,2);
		Stream<Integer> stream = lst.stream();
		System.out.println(stream.reduce(0,Integer::sum));
		
		stream = lst.stream();
		System.out.println(stream.mapToInt(x->x).sum());

		stream = Stream.of(1,2,3,4,7,5,3,8,9,0,5,4,5,6,7,8,56,4,3,2);
		System.out.println(stream.mapToInt(x->x).average().getAsDouble());

		stream = lst.stream();
		System.out.println(stream.mapToInt(x->x).max().getAsInt());


		stream = lst.stream();
		stream.mapToInt(x->x).forEach(i->System.out.print(i+" - "));

		IntStream intStream = IntStream.of(1,2,3,4,7,5,3,8,9,0,5,4,5,6,7,8,56,4,3,2);
		intStream = IntStream.range(0, 101);
		System.out.println("");
		intStream.forEach(System.out::print);
		System.out.println("");
		intStream = IntStream.generate(()->5);
		
		int[] intArray = {1,2,3,4,7,5,3,8,9,0,5,4,5,6,7,8,56,4,3,2};
		intStream = IntStream.of(intArray);
		System.out.println(intStream.average().getAsDouble());
	}

}
