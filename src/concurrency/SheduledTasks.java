package concurrency;

import java.util.concurrent.*;

import org.omg.Messaging.SyncScopeHelper;

public class SheduledTasks {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		// TODO Auto-generated method stub
		ScheduledExecutorService service = null;
		try {
			service = Executors.newSingleThreadScheduledExecutor();
			Runnable task1 = ()->System.out.println("Runnable");
			Callable<String> task2 = ()-> "Callable";
			Future<?> result1 = service.schedule(task1, 2, TimeUnit.SECONDS);
			Future<String> result2 = service.schedule(task2, 3, TimeUnit.SECONDS);
			System.out.println(result2.get());
			
			service.scheduleAtFixedRate(()->System.out.println("FixedRate: 1 Task pro second"), 0, 1, TimeUnit.SECONDS);
			service.scheduleWithFixedDelay(
					()->{
						System.out.println("FixedDelay: 2 Task pro second");
						try{Thread.sleep(250);} 
						catch (InterruptedException e) {e.printStackTrace();}; 
						},
					0, 
					1, 
					TimeUnit.SECONDS);
			Thread.sleep(15000);
		} finally {
			// TODO: handle finally clause
			if (service!=null) service.shutdown();
		}

	}

}
