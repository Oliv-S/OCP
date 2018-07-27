package nio2;

import java.io.IOException;
import java.nio.file.*;

public class PrintingFileContents {

	public static void main(String[] args) {

		String sourcePath = "target\\classes\\io\\multiline_text.txt";
		Path path = Paths.get(sourcePath);
		
		try {
			Files.lines(path).forEach(System.out::println);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
