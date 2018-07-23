package functional_programming;

import java.time.LocalDate;

public class Person {
	private String name;
	private LocalDate birthday;
	private boolean female;
	
	
		// TODO Auto-generated method stub

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the birthday
	 */
	public LocalDate getBirthday() {
		return birthday;
	}

	/**
	 * @return the female
	 */
	public boolean isFemale() {
		return female;
	}


	public Person(String name, LocalDate birthday, boolean female) {
		super();
		this.name = name;
		this.birthday = birthday;
		this.female = female;
	}



	public Person() {
		// TODO Auto-generated constructor stub
	}

}
