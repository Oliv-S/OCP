package FunctionalProgramming;

import java.util.function.Function;

@FunctionalInterface
public interface PersonChecker{
	public abstract boolean CheckPerson(Person person);
}
