package Compare;

import java.util.*;

import javax.swing.plaf.multi.MultiListUI;

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
		
//		Comparator<Squirrel> comparator = new Comparator<Squirrel>() {
//			public int compare(Squirrel o1, Squirrel o2) {
//				// TODO Auto-generated method stub
//				int result = o2.getAge()-o1.getAge();
//				return result;
//			}
//		};
//		
//		Comparator<Squirrel> multiComparator = new MultiFieldComparator();
//		
//		Arrays.sort(squirrels, multiComparator);
//		System.out.println("***********");
//		for (Squirrel squirrel : squirrels) {
//			System.out.println(squirrel);
//		}
////		***************************************
//		Arrays.sort(squirrels, new Comparator<Squirrel>() {
//			public int compare(Squirrel s1, Squirrel s2) {
//				return s1.getWeight()-s2.getWeight();
//			}
//		});
//		
//		System.out.println("***********");
//		for (Squirrel squirrel : squirrels) {
//			System.out.println(squirrel);
//		}
//		
////		*****************************************
//		Arrays.sort(squirrels, (s1,s2)->s1.getName().compareTo(s2.getName()));
//		
//		System.out.println("***********");
//		for (Squirrel squirrel : squirrels) {
//			System.out.println(squirrel);
//		}
		
//		*****************************************
		//Arrays.sort(squirrels, MultiFieldComparator.orderByAgeReverse());
		Arrays.sort(squirrels, MultiFieldComparator::compareByAge);
		//Arrays.sort(squirrels, Comparator.reverseOrder());
		
		System.out.println("***********");
		for (Squirrel squirrel : squirrels) {
			System.out.println(squirrel);
		}
		
		Set<Squirrel> set = new TreeSet<>((s1,s2)->s1.getAge()-s2.getAge());		

	}

}
