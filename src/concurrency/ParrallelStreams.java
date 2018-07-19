package concurrency;

import java.util.*;
import java.util.stream.Collector.Characteristics;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;


public class ParrallelStreams {

	public static void main(String[] args) {
		
		

		Stream<Integer> stream = Arrays.asList(10,20,30,40,50).stream();
		
		//1. method 
		Stream<Integer> streamParallel1 = stream.parallel();

		//2. method
		Stream<Integer> streamParallel2 = Arrays.asList(10,20,30,40,50).parallelStream();
		
		IntStream intStream = null;

		//Processing task in serial
		System.out.println("Processing task in serial");
		intStream = IntStream.range(0, 20);
		intStream.forEach((i)->System.out.print(i + " "));
		System.out.println();
		
		//Processing task in parallel
		System.out.println("Processing task in parallel");
		intStream = IntStream.range(0, 20);
		intStream.parallel().forEach((i)->System.out.print(i + " "));
		System.out.println();

		//Processing task in parallel with serial output
		System.out.println("Processing task in parallel with serial output");
		intStream = IntStream.range(0, 20);
		intStream.parallel().map(i->i+4).forEachOrdered((i)->System.out.print(i + " "));
		System.out.println();
		System.out.println();
		
		//Comparison between serial and parallel processing
		System.out.println("Current count of CPU's: " + Runtime.getRuntime().availableProcessors());
		long startTime = System.currentTimeMillis();
		long endTime = System.currentTimeMillis();
		
		//serial
		intStream = IntStream.range(0, 100);
		intStream.map(i->incrementWithPause(i)).count();
		endTime = System.currentTimeMillis();
		System.out.println("Serial processing refomance: " + (double)((endTime-startTime)/1000)+ " sec");

		//parallel
		startTime = System.currentTimeMillis();
		intStream = IntStream.range(0, 100);
		intStream.parallel().map(i->incrementWithPause(i)).count();
		endTime = System.currentTimeMillis();
		System.out.println("Parallel processing refomance: " + ((double)(endTime-startTime))/1000+ " sec");
		System.out.println();
		
		final int streamSize = 2000;
		long res;
		//serial with ordered operations
		startTime = System.currentTimeMillis();
		intStream = IntStream.range(0, streamSize);
//		intStream.map(i->incrementWithPause(i)).skip(streamSize/4).limit(10).forEach((i)->System.out.print(i + " "));
		intStream.skip(streamSize/4).limit(10).map(i->incrementWithPause(i)).forEach((i)->System.out.print(i + " "));
		System.out.println();
		endTime = System.currentTimeMillis();
		System.out.println("Serial with ordered operations: " + ((double)(endTime-startTime))/1000+ " sec");
		System.out.println();

		//parallel with ordered operations
		startTime = System.currentTimeMillis();
		intStream = IntStream.range(0, streamSize);
		intStream.parallel().map(i->incrementWithPause(i)).skip(streamSize/4).limit(10).forEach((i)->System.out.print(i + " "));
//		intStream.parallel().skip(streamSize/4).limit(10).map(i->incrementWithPause(i)).forEach((i)->System.out.print(i + " "));
		System.out.println();
		endTime = System.currentTimeMillis();
		System.out.println("Parallel with ordered operations: " + ((double)(endTime-startTime))/1000+ " sec");
		System.out.println();

		//parallel with unordered operations
		startTime = System.currentTimeMillis();
		intStream = IntStream.range(0, streamSize);
		intStream.unordered().parallel().map(i->incrementWithPause(i)).skip(streamSize/4).limit(10).forEach((i)->System.out.print(i + " "));
//		intStream.unordered().parallel().skip(streamSize/4).limit(10).map(i->incrementWithPause(i)).forEach((i)->System.out.print(i + " "));
		System.out.println();
		endTime = System.currentTimeMillis();
		System.out.println("Parallel with unordered operations: " + ((double)(endTime-startTime))/1000+ " sec");
		System.out.println();

		
		//Combining result with reduce()
		System.out.println("Combining result with reduce()");
		System.out.println();
		List<Character> charList = new ArrayList<>();
		for (char c = 'A'; c<='z';c++) {
			charList.add(c);
		}
		System.out.println(charList);
		
		//reduce with serial
		System.out.println("reduce with serial:");
		Stream<Character> streamOfChars = charList.stream();
		String result = streamOfChars.reduce("-", (c,s)->c+s,String::concat);
//		String result = streamOfChars.reduce("-", (c,s)->c+s+"+",String::concat);
		System.out.println(result);
		System.out.println();

		//reduce with parallel
		System.out.println("reduce with parallel:");
		streamOfChars = charList.stream();
		result = streamOfChars.parallel().reduce("-", (c,s)->c+s,String::concat);
//		result = streamOfChars.parallel().reduce("-", (c,s)->c+s+"+",String::concat);
		System.out.println(result);
		System.out.println();

		//reduce with parallel unordered
		System.out.println("reduce with parallel unordered:");
		streamOfChars = charList.stream();
		result = streamOfChars.unordered().parallel().reduce("-", (c,s)->c+s,String::concat);
//		result = streamOfChars.parallel().reduce("-", (c,s)->c+s+"+",String::concat);
		System.out.println(result);
		System.out.println();

		//collect with parallel
		System.out.println("collect with parallel:");
		streamOfChars = charList.stream();
		result = streamOfChars.parallel().collect(StringBuffer::new,StringBuffer::append,StringBuffer::append).toString();
		System.out.println(result);
		System.out.println();

		//collect with parallel unordered
		System.out.println("collect with parallel unordered:");
		streamOfChars = charList.stream();
		result = streamOfChars.unordered().parallel().collect(StringBuffer::new,StringBuffer::append,StringBuffer::append).toString();
		System.out.println(result);
		System.out.println();
		
		
//		for (Characteristics c: Collectors.toConcurrentMap(null,null,null).characteristics()) {
//			System.out.println(c.toString());
//		}
		
		//collect with One Argument
		System.out.println("collect with One Argument:");
		List<String> usStates = Arrays.asList(US.values()).stream().map(US::getUnabbreviated).collect(Collectors.toList());
		System.out.println(usStates);
		System.out.println();
		
		System.out.println("Serial:");
		System.out.println(Arrays.asList(US.values()).stream().map(US::getUnabbreviated).collect(Collectors.toSet()));
		System.out.println();
		
		System.out.println("Parallel with toConcurrentMap:");
		System.out.println(Arrays.asList(US.values()).stream().map(US::getUnabbreviated).collect(Collectors.toConcurrentMap(String::length, k->k, (s1,s2)->s1 + ", " + s2 )));
		System.out.println(Arrays.asList(US.values()).stream().map(US::getUnabbreviated).collect(Collectors.toConcurrentMap(k->k,String::length)));
		System.out.println();
		
		System.out.println("Parallel with groupingByConcurrent:");
		System.out.println(Arrays.asList(US.values()).stream().map(US::getUnabbreviated).collect(Collectors.groupingByConcurrent(String::length)));
		System.out.println();
		
	}
	
	public static int incrementWithPause(int i) {
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i+1;
	}

}
