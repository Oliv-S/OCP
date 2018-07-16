package concurrency;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableVsRunnableExecutor {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		// TODO Auto-generated method stub
		ExecutorService service = null;
		try {
			service = Executors.newSingleThreadExecutor();
			Future<Integer> result = service.submit(()->31*34);
			System.out.println(result.get());
			result = service.submit(()->{Thread.sleep(100);return null;});
			System.out.println(result.get());
//			Does't compile
//			result = service.submit(()->{Thread.sleep(100);});
//			System.out.println(result.get());
			
		} finally {
			if (service!=null) service.shutdown();
			// TODO: handle finally clause
		} 

	}

}
