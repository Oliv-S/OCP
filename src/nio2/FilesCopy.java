package nio2;


import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.*;

public class FilesCopy {

	public static void main(String[] args) {
		// The are 3 overloaded version of Files.copy()
		
		System.out.println("Current working folder: " + Paths.get(".").toAbsolutePath());
		String sourcePath = "target\\classes\\io\\multiline_text.txt";
		String targetPath1 = "target\\classes\\nio2\\multiline_text1.txt";
		String targetPath2 = "target\\classes\\nio2\\multiline_text2.txt";
		String targetPath3 = "target\\classes\\nio2\\multiline_text3.txt";
		String targetPath4 = "target\\classes\\nio2\\multiline_text4.txt";
		Path pathSource = Paths.get(sourcePath);
		Path pathTarget1 = Paths.get(targetPath1);
		Path pathTarget2 = Paths.get(targetPath2);
		Path pathTarget3 = Paths.get(targetPath3);
		Path pathTarget4 = Paths.get(targetPath4);
		
		//1. Files.copy(InputStream, Path);
		try {
			InputStream is = new BufferedInputStream(new FileInputStream(pathSource.toFile()));
			Files.copy(is, pathTarget1,StandardCopyOption.REPLACE_EXISTING);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		// 2. Files.copy(Path, OutputStream);
		try (OutputStream os = new BufferedOutputStream(new FileOutputStream(pathTarget2.toFile()))) {
			Files.copy(pathSource, os);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// 3. Files.copy(Path, Path);
		try {
			Files.copy(pathSource, pathTarget3,StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		//Moving File or Folder
		try {
			Files.move(pathTarget3, pathTarget4,StandardCopyOption.REPLACE_EXISTING,StandardCopyOption.ATOMIC_MOVE);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Exception: "+e.getMessage());
//			e.printStackTrace();
		}
		
		//Deleting File or EMPTY Folder
		try {
			Files.delete(pathTarget1);
			Files.delete(pathTarget2);
			Files.deleteIfExists(pathTarget3);
			Files.delete(pathTarget4);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		System.out.println("Done");

	}

}
