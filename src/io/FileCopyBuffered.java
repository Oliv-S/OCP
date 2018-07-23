package io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class FileCopyBuffered {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String fileSourceName = "target\\classes\\io\\test.txt";
		String fileTargetName = "target\\classes\\io\\test_out_buff.txt";
		File fileSource = new File (fileSourceName);
		File fileTarget= new File (fileTargetName);
		System.out.println("Source: " + fileSource.getAbsolutePath()+ "\n" + 
							"Destination:" + fileTarget.getAbsolutePath());
		try(InputStream inputStream = new BufferedInputStream(new FileInputStream(fileSource));
			OutputStream outputStream = new BufferedOutputStream(new FileOutputStream(fileTarget))){
			byte[] buff = new byte[5];
			int lenghtRead;
			while ((lenghtRead = inputStream.read(buff))>0){
				outputStream.write(buff,0,lenghtRead);
				outputStream.flush();
				System.out.println("Bytes writted: " + lenghtRead);
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
