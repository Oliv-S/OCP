package concurrency;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWriteCollections {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> list = new ArrayList<>(Arrays.asList(10,20,30));
		for (Integer integer : list) {
			System.out.println(integer);
//			list.add(40);//Exception in thread "main" java.util.ConcurrentModificationException
		}
		
		System.out.println("***");
		list = new CopyOnWriteArrayList<>(Arrays.asList(10,20,30));
		for (Integer integer : list) {
			System.out.println(integer);
			list.add(40);
		}
		System.out.println("***");
		for (Integer integer : list) {
			System.out.println(integer);
		}

		

	}

}
