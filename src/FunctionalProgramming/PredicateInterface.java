package FunctionalProgramming;

import java.util.function.*;
public class PredicateInterface {

	public static void main(String[] args) {

		Predicate<String> predicate = String::isEmpty;
		System.out.println(predicate.test("Hello"));
		System.out.println(predicate.test(""));
		
		BiPredicate<String, String> biPredicate = String::startsWith;
		System.out.println(biPredicate.test("Hello World", "He"));
		System.out.println(biPredicate.test("Hello World", "Me"));
		
		Predicate<String> egg = s->s.contains("Egg");
		Predicate<String> brown = s->s.contains("Brown");
		
		Predicate<String> brownEgg = s->s.contains("Egg") && s.contains("Brown");
		Predicate<String> otherEgg = s->s.contains("Egg") && !s.contains("Brown");
		
		Predicate<String> brownEgg2 = egg.and(brown);
		Predicate<String> otherEgg2 = egg.and(brown.negate());
		
		System.out.println(egg.test("Brown Egg is good"));
		System.out.println(brown.test("Brown Egg is good"));
		System.out.println(brownEgg.test("Brown Egg is good"));
		System.out.println(brownEgg2.test("Brown Egg is good"));
		
		
		
		

	}

}
