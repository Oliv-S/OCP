package Collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class RemoovingConditionally {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> listOfIntegers = new ArrayList<>(Arrays.asList(10, 15, 17, 6, 3, 8, 19, 11, 15, 3, 7, 8, 3, 0, 4, 4, 7, 2));
		List<Integer> listOfIntegersCopy1 = new ArrayList<>(listOfIntegers);
		List<Integer> listOfIntegersCopy2 = new ArrayList<>(listOfIntegers);
		List<Integer> listOfIntegersCopy3 = new ArrayList<>(listOfIntegers);
		System.out.println(listOfIntegers);
		
		listOfIntegersCopy1.removeIf(a -> a<10 );
		System.out.println(listOfIntegersCopy1);
		
		listOfIntegersCopy2.removeIf(a -> a%3!=0 );
		System.out.println(listOfIntegersCopy2);

		Predicate<Integer> pre3 = i -> i>=10;
		listOfIntegersCopy3.removeIf(pre3);
		System.out.println(listOfIntegersCopy3);
		
		System.out.println("*************************");
		List<String> stringList = new ArrayList<>();
		stringList.add("One");
		stringList.add("Two");
		stringList.add("Three");
		stringList.add("Four");
		stringList.add("Five");
		System.out.println(stringList);
		
		stringList.removeIf(s -> s.startsWith("T"));
		System.out.println(stringList);
		
		Predicate<String> preStr = s -> s.length()>3;
		stringList.removeIf(preStr);
		System.out.println(stringList);

	}

}
