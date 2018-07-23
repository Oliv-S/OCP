package io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class BinaryFileCopy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String fileSourceName = "target\\classes\\io\\test.txt";
		String fileTargetName = "target\\classes\\io\\test_out.txt";
		File fileSource = new File (fileSourceName);
		File fileTarget= new File (fileTargetName);
		System.out.println(fileSource.getAbsolutePath()+ " " + fileTarget.getAbsolutePath());
		try(InputStream inputStream = new FileInputStream(fileSource);
			OutputStream outputStream = new FileOutputStream(fileTarget)){
			int buff;
			while ((buff=inputStream.read())!=-1) {
				outputStream.write(buff);
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
