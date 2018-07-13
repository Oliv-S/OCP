package concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorExample {

	public static void main(String[] args) {
		
		ExecutorService executorService =null;
		try {
			executorService = Executors.newSingleThreadExecutor();
			System.out.println("Beginn");
			
			executorService.execute(()->System.out.println("Printing"));
			executorService.execute(() -> {
				for (int i = 0; i < 10; i++) {
					System.out.println("Printing record: " + i);
				}
			});
			executorService.execute(()->System.out.println("Printing"));
//			if (executorService!=null)executorService.shutdownNow();
			System.out.println("End");
			
		} finally {
			// TODO: handle finally clause
			if (executorService!=null)executorService.shutdown();
			
		}

	}

}
