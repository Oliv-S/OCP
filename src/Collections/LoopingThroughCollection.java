package Collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class LoopingThroughCollection {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> arrayListOfIntegers = new ArrayList<>(Arrays.asList(10, 15, 17, 6, 3, 8, 19, 11, 15, 3, 7, 8, 3, 0, 4, 4, 7, 2));
		System.out.println(arrayListOfIntegers);
		System.out.println("****");
		arrayListOfIntegers.forEach(System.out::println);
		System.out.println("****");
		arrayListOfIntegers.forEach(i -> System.out.println(i));
		
		List<Integer> linkedListOfIntegers = new LinkedList<>();
		arrayListOfIntegers.forEach(linkedListOfIntegers::add);
		
		System.out.println("****");
		System.out.println(linkedListOfIntegers);
		

	}

}
