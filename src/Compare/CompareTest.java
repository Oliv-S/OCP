package Compare;

import java.util.*;

public class CompareTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] names = {"Anna", "Alex", "John", "Peter", "Paul", "Nils", "Jona", "Martin", "Josi", "Mona"};
		Random rnd = new Random();
		
		Squirrel[] squirrels = new Squirrel[100];
		
		for (int i = 0; i < 100; i++) {
			squirrels[i]=new Squirrel(names[rnd.nextInt(names.length)], rnd.nextInt(25), rnd.nextInt(100));
		}
		
		for (Squirrel squirrel : squirrels) {
			System.out.println(squirrel);
		}
		Comparator<Squirrel> comparator = new Comparator<Squirrel>() {
			public int compare(Squirrel o1, Squirrel o2) {
				// TODO Auto-generated method stub
				int result = o2.getAge()-o1.getAge();
				return result;
			}
		};
		Arrays.sort(squirrels, comparator);
		System.out.println("***********");
		for (Squirrel squirrel : squirrels) {
			System.out.println(squirrel);
		}
		

	}

}
