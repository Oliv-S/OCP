package FunctionalProgramming;

import java.util.ArrayList;
import java.util.List;
import java.util.function.*;

public class OperatorInterface {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UnaryOperator<String> unaryOperator1 = s -> String.valueOf(s.length());
		UnaryOperator<String> unaryOperator2 = String::toUpperCase;

		List<String> list = new ArrayList<String>();
		list.add("One");
		list.add("Two");
		list.add("Three");
		list.add("Four");
		list.add("Five");
		System.out.println(list);
		
		list.replaceAll(unaryOperator2);
		System.out.println(list);

		list.replaceAll(unaryOperator1);
		System.out.println(list);
		
		System.out.println();
		
		BinaryOperator<String> binaryOperator = String::concat;
		System.out.println(binaryOperator.apply("First String ", "Second String"));

	}

}
