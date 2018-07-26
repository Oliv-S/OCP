package nio2;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.List;

public class NioBufferedOperation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		for (String string : Charset.availableCharsets().keySet()) {
//			System.out.println(string);
//		}
		
		System.out.println("Current working folder: " + Paths.get(".").toAbsolutePath());
		Path path = Paths.get("target/classes/test.txt");
		System.out.println("File path: " + path.toAbsolutePath());

		//Reading lines with Files.newBufferedReader
		System.out.println("Reading lines with Files.newBufferedReader");
//		System.out.println(Files.exists(path));
		try (BufferedReader reader = Files.newBufferedReader(path,StandardCharsets.US_ASCII)){
			String currentLine=null;
//			reader.lines().forEach(System.out::println);
			while ((currentLine=reader.readLine())!=null);{
				System.out.println(currentLine);
			};
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Reading lines with Files.newBufferedReader
		System.out.println("Reading lines with Files.newBufferedReader");
		List<String> strings;
		try {
			strings = Files.readAllLines(path);
			for (String string : strings) {
				System.out.println(string);
				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		

	}

}
