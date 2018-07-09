package Streams;

import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Stream;

public class StreamsCollect {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> lst = Arrays.asList(1,2,3,4,7,5,3,8,9,0,5,4,5,6,7,8,56,4,3,2);

		System.out.println("\n\n collect");
		String[] str = {"W", "o", "l", "f", "!"};
		StringBuilder strB = Stream.of(str).collect(StringBuilder::new, StringBuilder::append, StringBuilder::append);
		System.out.println(strB);		
		
		System.out.println(lst.stream().collect(StringBuilder::new,(a,b)->a.append(b.toString()+"+"), StringBuilder::append));
		
		TreeSet<String> treeSet = Stream.of(str).collect(TreeSet::new,TreeSet::add,TreeSet::addAll);
		System.out.println(treeSet);
		System.out.println("**********");
	}

}
