package Compare;

import java.util.Comparator;

public class MultiFieldComparator implements Comparator<Squirrel> {

	@Override
	public int compare(Squirrel o1, Squirrel o2) {
		// TODO Auto-generated method stub
		int result = o1.getAge()-o2.getAge();
		if (result != 0) return result;
		
		result = o1.getWeight()-o2.getWeight();
		if (result != 0) return result;
		
		return o1.getName().compareTo(o2.getName());
	}
	
	public static Comparator<Squirrel> orderByAge() {
		// TODO Auto-generated method stub
		return (s1,s2)->s1.getAge()-s2.getAge();		
	}
	public static Comparator<Squirrel> orderByWeight() {
		// TODO Auto-generated method stub
		return (s1,s2)->s1.getWeight()-s2.getWeight();		
	}
	public static Comparator<Squirrel> orderByAgeReverse() {
		// TODO Auto-generated method stub
		return (s1,s2)->s2.getAge()-s1.getAge();		
	}
	public static Comparator<Squirrel> orderByWeightReverse() {
		return (s1,s2)->s2.getWeight()-s1.getWeight();}
	
	public static int compareByAge(Squirrel s1, Squirrel s2) {
		// TODO Auto-generated method stub
		return s1.getAge()-s2.getAge();		
	}
	
}
