package Compare;

import java.util.Comparator;

public class Squirrel implements Comparable<Squirrel>{
	private String name;
	private int age;
	private int weight;
	public Squirrel(String name, int age, int weight) {
		super();
		if (name==null || name.trim().length()==0) throw new IllegalArgumentException("Name of Squirrel can not be null or empty.");
		this.name = name;
		this.age = age;
		this.weight = weight;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}
	/**
	 * @return the weight
	 */
	public int getWeight() {
		return weight;
	}
	
	public int compare(Squirrel o1, Squirrel o2) {
		// TODO Auto-generated method stub
		Comparator<Squirrel> comparator = Comparator.comparing(s->s.getAge());
		comparator = comparator.thenComparing(s->getWeight());
		comparator = comparator.thenComparing(s->getName());
		return comparator.compare(o1, o2);
	}
	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(Squirrel o) {
		// TODO Auto-generated method stub
		int result = age-o.age;
		if (result != 0) return result;
		
		result = weight-o.weight;
		if (result != 0) return result;
		
		return name.compareTo(o.name);
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Squirrel [name=" + name + ", age=" + age + ", weight=" + weight + "]";
	}
	
	
	
	
	
	

}
