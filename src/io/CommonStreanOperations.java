package io;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import org.xml.sax.InputSource;

public class CommonStreanOperations {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String fileName = "target\\classes\\io\\test.txt";
		File file = new File (fileName);
		
		
		if (file.exists()) {
			System.out.println("File "+file.getAbsolutePath()+ " is exist!");
			
			try (InputStream inputStream = new BufferedInputStream(new FileInputStream(file))){
				System.out.print((char)inputStream.read());
				if (inputStream.markSupported()) {
					inputStream.mark(1);
					System.out.print((char)inputStream.read());
					System.out.print((char)inputStream.read());
					inputStream.reset();
				}
				System.out.print((char)inputStream.read());
				System.out.print((char)inputStream.read());
				System.out.print((char)inputStream.read());
				inputStream.skip(8);
				System.out.print((char)inputStream.read());
				inputStream.read();
				System.out.print((char)inputStream.read());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		else System.out.println("File "+file.getAbsolutePath()+ " is NOT exist!");


	}

}
