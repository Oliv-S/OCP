package concurrency;

import java.util.*;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.RecursiveTask;

public class ForkJoinRecursiveTask extends RecursiveTask<Integer> {
	private int start;
	private int end;
	private Integer[] weights;

	public ForkJoinRecursiveTask(int start, int end, Integer[] weights) {
		super();
		this.start = start;
		this.end = end;
		this.weights = weights;
	}
	
	protected Integer compute() {
		// TODO Auto-generated method stub
		if (end - start<4) {
			Integer sum=0;
			for (int i = start; i < end; i++) {
				weights[i]=new Random().nextInt(1000);
				System.out.println("Animal [" + i + "] weighed:"+weights[i]);
				sum+=weights[i];
			}
			return sum;
		}
		else {
			int middle = start + (end - start)/2;
			System.out.println("S="+start+"; M="+middle+"; E="+end);
			RecursiveTask<Integer> task = new ForkJoinRecursiveTask(start, middle, weights);
			task.fork();
			return new ForkJoinRecursiveTask(middle, end, weights).compute() + task.join();
		}
	}





	public static void main(String[] args) {
		Integer [] weights = new Integer[15];
		ForkJoinTask<Integer> task = new ForkJoinRecursiveTask(0, 15, weights);
		ForkJoinPool pool = new ForkJoinPool();
		Integer sum = pool.invoke(task);
		
		System.out.println();
		System.out.println("Weights:");
		Arrays.asList(weights).stream().forEach(System.out::println);
		System.out.println("=============");
		System.out.println("Sum: " + sum);

	}

}
