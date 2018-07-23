package functional_programming;

@FunctionalInterface
public interface SimpleInterface {
	public static final int MAX_COUNT = 100;
	//default
	public default int getMax() {return MAX_COUNT;};
	//static
	public static void printInfo() {System.out.println("SimpleInterface");};			

	//Only one abstract method
	public abstract void doSomething();
}
