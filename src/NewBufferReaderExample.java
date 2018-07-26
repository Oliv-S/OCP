import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class NewBufferReaderExample {
	public static void main(String[] args) {
		try {
			BufferedReader reader = Files.newBufferedReader(Paths.get("test.txt"));
			String currentLine = null;
			while ((currentLine=reader.readLine())!=null)
				System.out.println(currentLine);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
