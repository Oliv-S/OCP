package concurrency;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class WaitingAllTasksToFinisch {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		ExecutorService service = null;
		try {
			service = Executors.newSingleThreadExecutor();
			Random rnd = new Random();
			for (int i=0; i<10;i++) {
				final int j = i;
				service.submit(()->{Thread.sleep(rnd.nextInt(150));System.out.println("Task "+j);return null;});
			}
		} finally {
			// TODO: handle finally clause
			if (service!=null) service.shutdown();
		}
		if (service!=null) {
			service.awaitTermination(500, TimeUnit.MILLISECONDS);
			if (service.isTerminated()) {
				System.out.println("All tasks finished!!");
			}else {
				System.out.println("NOT all tasks finished!!");
//				service.shutdownNow();
			}
		}

	}

}
