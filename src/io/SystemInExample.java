package io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SystemInExample {

	//This is The Old WAy
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			String userInput = reader.readLine();
			System.out.format("You entered: %1$s", userInput);
			
		
	}

}
