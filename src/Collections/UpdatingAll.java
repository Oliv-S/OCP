package Collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.UnaryOperator;

public class UpdatingAll {

	public static void main(String[] args) {
		
		List<Integer> listOfIntegers = new ArrayList<>(Arrays.asList(10, 15, 17, 6, 3, 8, 19, 11, 15, 3, 7, 8, 3, 0, 4, 4, 7, 2));
		List<Integer> listOfIntegersCopy1 = new ArrayList<>(listOfIntegers);
		List<Integer> listOfIntegersCopy2 = new ArrayList<>(listOfIntegers);
		List<Integer> listOfIntegersCopy3 = new ArrayList<>(listOfIntegers);
		System.out.println(listOfIntegers);
		
		listOfIntegersCopy1.replaceAll(i -> i/2);;
		System.out.println(listOfIntegersCopy1);
		
		listOfIntegersCopy2.replaceAll(i -> i*i*i );
		System.out.println(listOfIntegersCopy2);

		UnaryOperator<Integer> unaryOperator = i -> 0;
		listOfIntegersCopy3.replaceAll(unaryOperator);
		System.out.println(listOfIntegersCopy3);
		

	}

}
