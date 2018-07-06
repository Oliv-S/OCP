package FunctionalProgramming;

import java.util.Optional;

public class OptionalTest {
	
	public static Optional<Integer> checkForAverage(Integer[] values){
		if (values==null || values.length==0)
			return Optional.empty();
		int count=0;
		int sum=0;
		for (Integer integer : values) {
			sum+=integer;
			count++;
		}
		return Optional.of(sum/count);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer[] arr1 = {1, 34, 54, 2, 4, 75, 19, 0, 34};
		Integer[] arr2 = null;
		Integer[] arr3 = {100};
		Integer[] arr4 = {};

		Optional<Integer> average = checkForAverage(arr1);
		if (average.isPresent()) System.out.println("Average for: "+ arr1.toString()+ " is: " + average.get());
		else System.out.println("The is no average for: "+ arr1.toString());

		average = checkForAverage(arr2);
		if (average.isPresent()) System.out.println("Average for: "+ arr1.toString()+ " is: " + average.get());
		else System.out.println("The is no average for: "+ arr1.toString());

		average = checkForAverage(arr3);
		if (average.isPresent()) System.out.println("Average for: "+ arr1.toString()+ " is: " + average.get());
		else System.out.println("The is no average for: "+ arr1.toString());
		
		average = checkForAverage(arr4);
		if (average.isPresent()) System.out.println("Average for: "+ arr1.toString()+ " is: " + average.get());
		else System.out.println("The is no average for: "+ arr1.toString());
		
		Integer i1 = null;
		Integer i2 = 100;
		Optional<Integer> op1 = (i1==null)?Optional.empty():Optional.of(i1);
		Optional<Integer> op2 = Optional.ofNullable(i2);
		
		op1.ifPresent(System.out::println);
		op2.ifPresent(System.out::println);
		
		
	}

}
