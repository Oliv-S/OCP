package functional_programming;

import java.time.LocalDate;
import java.util.function.Predicate;

public class FindMatchingPersons {

	public FindMatchingPersons() {
		// TODO Auto-generated constructor stub
	}
	
	private static void testPerson(Person person, PersonChecker checker) {
		if (checker.CheckPerson(person)) {
			System.out.println(person.getName());
		}
	}

	private static void testPersonWithPredikate(Person person, Predicate<Person> checker) {
		if (checker.test(person)) {
			System.out.println(person.getName());
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Person person1 = new Person("Oli", LocalDate.of(1977, 12, 25), false);
		Person person2 = new Person("Angela", LocalDate.of(1986, 9, 5), true);
		
		testPerson(person1, a->a.isFemale());
		testPerson(person2, a->a.isFemale());

		testPersonWithPredikate(person1, a->!a.isFemale());
		testPersonWithPredikate(person2, a->!a.isFemale());
		
	}

}
