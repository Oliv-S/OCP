package concurrency;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class SynchronizedCollections {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> list = new ArrayList<>(Arrays.asList("A", "B", "C"));
		List<String> listSync = Collections.synchronizedList(list);
		List<String> listConc = new CopyOnWriteArrayList<>(list);
		System.out.println("Collections.synchronizedList");
		
		//Collections.synchronizedList synchronize access only to the data elements with
		//set(); and get();
		//they don't synchronize access on iterators
		synchronized (listSync) {
			for (String string : listSync) {
				System.out.println(string);
//				listSync.remove(0);//Exception in thread "main" java.util.ConcurrentModificationException
			}
		}
		
		
		
		System.out.println("CopyOnWriteArrayList");
		for (String string : listConc) {
			System.out.println(string);
			listConc.remove(0);
		}
		System.out.println("CopyOnWriteArrayList After remove");
		System.out.println(listConc);
		
		
		
		

	}

}
