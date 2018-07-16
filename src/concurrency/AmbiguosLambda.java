package concurrency;

import java.io.IOException;
import java.util.concurrent.Callable;
import java.util.function.Supplier;

public class AmbiguosLambda {
	
	public static void useCallable(Callable<Integer> expr) {System.out.println("Callable");};
	public static void useSupplier(Supplier<Integer> expr) {System.out.println("Supplier");};
	
	public static void use(Supplier<Integer> expr) {useSupplier(expr);}
	public static void use(Callable<Integer> expr) {useCallable(expr);}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		useCallable(()->{throw new IOException();});
//		useSupplier(()->{throw new IOException();});
		use((Callable<Integer>)()->{throw new IOException();});
		
	}

}
