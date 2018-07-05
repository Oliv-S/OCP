package Collections;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;

public class MapAPIs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<String, String> favorites = new HashMap<>();
		favorites.put("One", "One");
		favorites.put("Two", "Two");
		favorites.put("Three", "Three");
		favorites.put("Four", "Four");
		favorites.put("Five", "Five");
		favorites.put("Null", null);
		
		System.out.println(favorites);
		
		//putIfAbsent
		favorites.putIfAbsent("Four", "4");
		favorites.putIfAbsent("Six", "6");

		System.out.println(favorites);
		
		//merge
		BiFunction<String, String, String> mapper = (v1,v2) -> v1+v2;
		favorites.merge("Three", "3", mapper);
		System.out.println(favorites);
		favorites.merge("Null", "*NULL*", mapper);
		System.out.println(favorites);
		
		favorites.merge("123", "123", mapper);
		System.out.println(favorites);

		favorites.computeIfPresent("321", mapper);
		System.out.println(favorites);

		favorites.computeIfPresent("123", mapper);
		System.out.println(favorites);

		Function<String, String> function = s -> s;
		favorites.computeIfAbsent("543", function);
		System.out.println(favorites);

	}

}
