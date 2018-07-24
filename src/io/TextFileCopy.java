package io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.util.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class TextFileCopy {
	
	public static List<String> readFile(File sourceFile){
		List<String> data = new ArrayList<>();
		try (BufferedReader reader = new BufferedReader(new FileReader(sourceFile))){
			String s;
			while ((s=reader.readLine())!=null){
				data.add(s);				
			}
			return data;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;
	}
	
	public static void writeFile(List<String> data, File file) {
		try(BufferedWriter writer = new BufferedWriter(new FileWriter(file)) ){
			for (String string : data) {
				writer.write(string);
				writer.newLine();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String fileSourceName = "target\\classes\\io\\multiline_text.txt";
		String fileTargetName = "target\\classes\\io\\multiline_text_copy.txt";
		File fileSource = new File (fileSourceName);
		File fileTarget= new File (fileTargetName);
		System.out.println("Source: " + fileSource.getAbsolutePath()+ "\n" + 
				"Destination:" + fileTarget.getAbsolutePath());
		
		List<String> data = readFile(fileSource);
		for (String string : data) {
			System.out.println(string);
			
		}
		writeFile(readFile(fileSource), fileTarget);
		

	}

}
