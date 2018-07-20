package concurrency;

import java.util.*;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveAction;

public class ForkJoinRecursiveAction extends RecursiveAction {
	private int start;
	private int end;
	private Integer[] weights;

	public ForkJoinRecursiveAction(int start, int end, Integer[] weights) {
		super();
		this.start = start;
		this.end = end;
		this.weights = weights;
	}
	
	protected void compute() {
		// TODO Auto-generated method stub
		if (end - start<4) {
			for (int i = start; i < end; i++) {
				weights[i]=new Random().nextInt(1000);
				System.out.println("Animal [" + i + "] weighed:"+weights[i]);
			}
		}
		else {
			int middle = start + (end - start)/2;
			System.out.println("S="+start+"; M="+middle+"; E="+end);
			invokeAll(new ForkJoinRecursiveAction(start, middle, weights),
					  new ForkJoinRecursiveAction(middle, end, weights));
		}
	}





	public static void main(String[] args) {
		Integer [] weights = new Integer[15];
		ForkJoinTask<?> task = new ForkJoinRecursiveAction(0, 15, weights);
		ForkJoinPool pool = new ForkJoinPool();
		pool.invoke(task);
		
		System.out.println();
		System.out.println("Weights:");
		Arrays.asList(weights).stream().forEach(System.out::println);
		

	}

}
