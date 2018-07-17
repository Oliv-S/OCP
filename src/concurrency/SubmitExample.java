package concurrency;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class SubmitExample {
	
	public  static long counter = 0;

	public static void main(String[] args) throws InterruptedException {
		
		ExecutorService executorService = null;
		try {
			executorService =Executors.newSingleThreadExecutor();
			Future<?> result = executorService.submit(()->{
				for (int i = 0; i < 5000000; i++) counter*=i%13;
				});
			result.get(100,TimeUnit.MILLISECONDS);
			System.out.println("Reached!");
			
		} catch (TimeoutException e) {
			// TODO: handle exception
			System.out.println("Not reached in time!");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			if(executorService!=null) executorService.shutdown();
		}

		
	}

}
