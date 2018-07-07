package Streams;

import java.util.Arrays;
import java.util.List;

public class StreamsReduce {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Reduce
		List<Integer> lst = Arrays.asList(1,2,3,4,7,5,3,8,9,0,5,4,5,6,7,8,56,4,3,2);

		System.out.println("\n\nReduce");
		System.out.println(lst.stream().reduce(Integer::max));
		System.out.println(lst.stream().reduce((i1,i2)->i1+i2));
		System.out.println(lst.stream().reduce(0,(i1,i2)->i1+i2));
		System.out.println(lst.stream().reduce(1,(i1,i2)->i1+i2));

		
		
		System.out.println();
		List<String> stringList = Arrays.asList("One", "Two", "Three", "Four", "Five", "Six", "Seven");
		System.out.println(stringList);
		System.out.println(stringList.stream().reduce(String::concat));
		System.out.println(stringList.stream().reduce("",String::concat));
		//Used in parallel computation only
		System.out.println(stringList.stream().reduce("", (s1, s2) -> s1.concat("+" + s2), (s1, s2) -> s1.concat("*" + s2)));

		
		
		stringList.stream().map(String::length).forEach(System.out::println);
		System.out.println(stringList.stream().map(String::length).reduce(0,Integer::sum));
		

		System.out.println("**********");
		
	}

}
