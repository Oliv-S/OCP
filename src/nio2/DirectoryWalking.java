package nio2;

import java.io.IOException;
import java.nio.file.*;

public class DirectoryWalking {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Path path = Paths.get("C:","windows","system32");
		path = Paths.get(".").toAbsolutePath().normalize();

		try {
			//count of Folders
			System.out.println(Files.walk(path).count());
			
			//Printing all *.java files
			Files.walk(path)
				.filter(p->p.toString().endsWith("java"))
				.map(p->p.getFileName())
				.forEach(System.out::println);
			System.out.println("****************");
			
			//Printing 20 first Folders 
			Files.walk(path)
				.filter(p->Files.isDirectory(p))
				.map(p->p.getFileName())
				.limit(20)
				.forEach(System.out::println);
			
			//List of top level Folders
			Files.list(path.resolve("target/Classes"))
				.filter(p->Files.isDirectory(p))
				.forEach(System.out::println);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
