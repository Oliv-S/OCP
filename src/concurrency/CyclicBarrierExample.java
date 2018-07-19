package concurrency;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CyclicBarrierExample {

	public static void main(String[] args) {
		//Solution without CyclicBarrier
		
		ExecutorService service = null;
		
		System.out.println("Solution without CyclicBarrier");
		try {
			service = Executors.newFixedThreadPool(4);
			LionCageManager manager = new CyclicBarrierExample().new LionCageManager();
			for (int i=0; i<4; i++) {
				service.submit(()->manager.perfomTasks());
			}
		} finally {
			// TODO: handle finally clause
			if (service!=null) service.shutdown();
		}
		
		//Solution with CyclicBarrier
		System.out.println();

		System.out.println("Solution with CyclicBarrier:");
		try {
			service = Executors.newFixedThreadPool(4);
			LionCageManager manager = new CyclicBarrierExample().new LionCageManager();
			CyclicBarrier cBarrier1 = new CyclicBarrier(4);
			CyclicBarrier cBarrier2 = new CyclicBarrier(4,()->System.out.println("All cages are cleaned!"));
			for (int i=0; i<4; i++) {
				service.submit(()->manager.perfomTasksWithBarrier(cBarrier1, cBarrier2));
			}
		} finally {
			// TODO: handle finally clause
			if (service!=null) service.shutdown();
		}
		

	}

	private class LionCageManager{
		private void removeAnimals() {
			System.out.println("Removing animals");
		}
		private void cleanCage() {
			System.out.println("Cleaning the Cage");
		}
		private void addAnimals() {
			System.out.println("Adding animals");
		}
		
		public void perfomTasks() {
			removeAnimals();
			cleanCage();
			addAnimals();
		}
		
		public void perfomTasksWithBarrier(CyclicBarrier barrier1, CyclicBarrier barrier2) {

			try {
				removeAnimals();
				barrier1.await();
				cleanCage();
				barrier2.await();
				addAnimals();
			} catch (InterruptedException | BrokenBarrierException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}
}
