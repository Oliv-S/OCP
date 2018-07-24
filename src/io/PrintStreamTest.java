package io;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class PrintStreamTest {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		for (int i=0; i<255; i++)
			System.out.write(i);
		
		PrintWriter out = new PrintWriter("target\\classes\\io\\PrintWriter.txt");
		
		out.println(5);
		out.write(String.valueOf(5));
		out.println();
		
		out.println(2.0);
		out.write(String.valueOf(2.0));
		out.println();
		
		out.println(out);
		out.write(out.toString());
		out.println();
		
		out.format("The is %1$s. String with %2$s parametrs", 1, 2);
		out.println();
	
		out.format("The is %1$s String with %2$s parametrs", "2.", 2);
		out.println();
		
		out.close();
	}

}
