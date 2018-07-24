package io;

import java.io.BufferedReader;
import java.io.Console;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class ConsoleExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Hello");
		Console console = System.console();
		if (console !=null) {
			String userInput = console.readLine("Input some please: ");
			console.writer().println("You written: "+userInput);
			
		}else {
			System.out.println("The is no System console!!!");
		}

	}

}
