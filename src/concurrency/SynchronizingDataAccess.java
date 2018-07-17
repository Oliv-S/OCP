package concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class SynchronizingDataAccess {
	
	private int sheepCount =0;
	private AtomicInteger sheepCountAtomic = new AtomicInteger(0);
	
	//1. solution
	synchronized private void incrementSheepCountSync() {
		System.out.println((++sheepCount) + " ");
	}

	//2. solution
	private void incrementSheepCountSync2() {
		synchronized (sheepCountAtomic) {
			System.out.println((++sheepCount) + " ");
		}
	}

	//3. solution
	private void incrementSheepCountAtomic() {
		System.out.println(sheepCountAtomic.incrementAndGet() + " ");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ExecutorService service = null;
		try {
			service = Executors.newFixedThreadPool(200);
			SynchronizingDataAccess data = new SynchronizingDataAccess();
			for (int i=0; i<200; i++) {
				service.submit(()->data.incrementSheepCountSync2());
			}
			
		} finally {
			if (service!=null) service.shutdown();
			// TODO: handle finally clause
		}

	}

}
