package concurrency;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ThreadPoolsVsSingle {

		public static void main(String[] args) {
			// TODO Auto-generated method stub
			ExecutorService service1 = null;
			ExecutorService service2 = null;
			try {
				//Try SingleThreadExecutor
				service1 = Executors.newSingleThreadExecutor();
				Runnable task1 = ()->{
					System.out.println("Runnable 1");
					try {
						Thread.sleep(250);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					};
				};
				Runnable task2 = ()->{
					System.out.println("Runnable 2");
					try {
						Thread.sleep(250);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					};
				};

				for (int i=0; i<30; i++) {
					service1.submit(task1);
				}
				
				

				//Wait for 1 sec
				System.out.println("*************");
//				try {
//					Thread.sleep(3000);
//				} catch (InterruptedException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				};
				int processorsNum = Runtime.getRuntime().availableProcessors();
				int threadsNum = processorsNum*2;
				System.out.println("System has " + threadsNum + " Processors.");
				//Try FixedThreadPool
				service2 = Executors.newFixedThreadPool(threadsNum);
				for (int i=0; i<30; i++) {
					service2.submit(task2);
				}
			} finally {
				// TODO: handle finally clause
				if (service2!=null) service2.shutdown();
				if (service1!=null) service1.shutdown();
			}

		}

}
