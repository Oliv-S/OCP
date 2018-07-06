package FunctionalProgramming;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.*;
public class FunctionInterface {

	public static void main(String[] args) {

		Function<String, Integer> function = String::length;
		Consumer<String> consumer = s -> System.out.println(function.apply(s));
		
		List<String> list = new ArrayList<String>();
		list.add("One");
		list.add("Two");
		list.add("Three");
		list.add("Four");
		list.add("Five");
		System.out.println(list);
		list.forEach(consumer);


		BiFunction<String, Integer, Integer> biFunction = (s, i) -> i+s.length()<6?0:i+s.length();
		Map<String, Integer> map = new HashMap<>();
		map.put("Hello", 1);
		map.put("World", 3);
		map.put("One", 1);
		map.put("Two", 2);
		System.out.println(map);
		map.replaceAll(biFunction);
		System.out.println(map);
	}

}
