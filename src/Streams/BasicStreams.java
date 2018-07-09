package Streams;

import static org.junit.jupiter.api.DynamicTest.stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BasicStreams {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> lst = Arrays.asList(1,2,3,4,7,5,3,8,9,0,5,4,5,6,7,8,56,4,3,2);
		Stream<Integer> streamOfInt = lst.stream();
		System.out.println(streamOfInt.count());

		System.out.println("\nMax");
		System.out.println(lst.stream().max(Comparator.naturalOrder()));

		System.out.println("\nMin");
		System.out.println(lst.stream().max(Comparator.reverseOrder()));

		System.out.println("\nfindAny");
		System.out.println(lst.stream().findAny());

		System.out.println("\nfindFirst");
		System.out.println(lst.stream().findFirst());
		//System.out.println(lst.stream().findFirst());//java.lang.IllegalStateException:

		System.out.println("\nallMatch");
		System.out.println(lst.stream().allMatch(i -> i<5));

		System.out.println("\n anyMatch");
		System.out.println(lst.stream().anyMatch(i -> i<5));

		System.out.println("\n noneMatch");
		System.out.println(lst.stream().noneMatch(i -> i<5));

		System.out.println("\n forEach");
		lst.stream().forEach(System.out::print);
		
		//Reduce
		System.out.println("\n\nReduce");
		System.out.println(lst.stream().reduce(Integer::max));
		System.out.println(lst.stream().reduce(Integer::min));
		System.out.println(lst.stream().reduce((i1,i2)->i1+i2));
		System.out.println(lst.stream().reduce(0,(i1,i2)->i1+i2));
		
		
		System.out.println();
		List<String> stringList = Arrays.asList("One", "Two", "Three", "Four", "Five", "Six", "Seven");
		System.out.println(stringList);
		System.out.println(stringList.stream().reduce(String::concat));
		System.out.println(stringList.stream().reduce("",String::concat));
		stringList.stream().map(String::length).forEach(System.out::println);
		System.out.println(stringList.stream().map(String::length).reduce(0,Integer::sum));
		System.out.println(stringList.stream().collect(Collectors.toList()));

		
		//Collect
		System.out.println("\n\nCollect");
		System.out.println(lst.stream().collect(Collectors.toList()));
		
		String[] str = {"W", "o", "l", "f", "!"};
		StringBuilder strB = Stream.of(str).collect(StringBuilder::new, StringBuilder::append, StringBuilder::append);
		System.out.println(strB);
		
		String strS = Stream.of(str).collect(String::new, String::concat, String::concat);
		System.out.println(strS);//!!!!!!!!!!
		
		TreeSet<String> treeSet = Stream.of(str).collect(TreeSet::new,TreeSet::add,TreeSet::addAll);
		System.out.println(treeSet);
				
	
		System.out.println("*******");
		String strToReverse = "ASDVOSDFGKQOWEFKALSDFKALSDFSKLLLLLL";
		Stream.of(strToReverse.toCharArray()).map(c->c.toString()+"-").forEach(System.out::println);
		
	}

}
