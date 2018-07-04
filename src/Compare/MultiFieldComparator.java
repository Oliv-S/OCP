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
	
	public static final Comparator<Squirrel> compareByAllFields(Squirrel o1, Squirrel o2) {
		// TODO Auto-generated method stub
		return new Comparator<Squirrel>() {
			public int compare(Squirrel o1, Squirrel o2) {
				// TODO Auto-generated method stub
				int result = o1.getAge()-o2.getAge();
				if (result != 0) return result;
				
				result = o1.getWeight()-o2.getWeight();
				if (result != 0) return result;
				
				return o1.getName().compareTo(o2.getName());
			}
		};
	}
}
