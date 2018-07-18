package concurrency;

import java.util.Iterator;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class BlockingQueueDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("LinkedBlockingQueue");
		BlockingQueue<Integer> blockingQueue = new LinkedBlockingQueue<>();

		try {
			System.out.println(blockingQueue.offer(100));
			System.out.println(blockingQueue.offer(200, 3, TimeUnit.MILLISECONDS));
			
			System.out.println(blockingQueue.poll());
			System.out.println(blockingQueue.poll(10,TimeUnit.MILLISECONDS));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("LinkedBlockingDeque");
		BlockingDeque<Integer> blockingDeque = new LinkedBlockingDeque<>();
		try {
			System.out.println(blockingDeque.offer(100));
			System.out.println(blockingDeque.offerFirst(200, 3, TimeUnit.MILLISECONDS));
			System.out.println(blockingDeque.offerLast(300, 3, TimeUnit.MILLISECONDS));
			System.out.println(blockingDeque.offer(400, 3, TimeUnit.MILLISECONDS));
			System.out.println("***");
			for (Iterator iterator = blockingDeque.iterator(); iterator.hasNext();) {
				System.out.println((Integer) iterator.next());
			}
			System.out.println("***");
			System.out.println(blockingDeque.poll());
			System.out.println(blockingDeque.pollFirst(10,TimeUnit.MILLISECONDS));
			System.out.println(blockingDeque.pollLast(10,TimeUnit.MILLISECONDS));
			System.out.println(blockingDeque.poll(10,TimeUnit.MILLISECONDS));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
