package FunctionalProgramming;

import java.util.HashMap;
import java.util.Map;
import java.util.function.*;

public class ConsumerInterface {

	public static void main(String[] args) {

		Consumer<String> consumer1 = System.out::print;
		Consumer<String> consumer2 = x -> System.out.println(x);
		
		consumer1.accept("Hello World from Consumer1");
		consumer2.accept("Hello World from Consumer2");
		
		BiConsumer<String, Integer> biConsumer1 = (s, i) -> System.out.println(s + i);
		biConsumer1.accept("hello World + ", 123);
		
		Map<String, Integer> map = new HashMap<>();
		BiConsumer<String, Integer> biConsumer2 = map::put;
		biConsumer2.accept("Hello", 1);
		biConsumer2.accept("World", 3);
		biConsumer2.accept("One", 1);
		biConsumer2.accept("Two", 2);
		System.out.println(map);
		
		BiConsumer<String, Integer> biConsumer3 = (s, i) -> System.out.println("Map Key: " + s + ",\t Map Value: " + i);
		map.forEach(biConsumer3);

	}

}
