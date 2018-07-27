package nio2;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * 
 * @author User
 * Creating SymLinks in Windows
 *  
 * For Folders:
 * mklink /D hl_to_folder nio2\target_folder
 * 
 * For Files:
 * mklink hl_to_file.txt nio2\target_file.txt
 *
 */
public class SymLinksExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Current folder: " + Paths.get(".").toAbsolutePath());
		
		List<Path> paths = new ArrayList<>();
		paths.add(Paths.get("target", "classes", "nio2", "target_file.txt"));
		paths.add(Paths.get("target", "classes", "nio2", "target_folder"));

		paths.add(Paths.get("target", "classes", "hl_to_file.txt"));
		paths.add(Paths.get("target", "classes", "hl_to_folder"));
		
		paths.add(Paths.get("target", "classes", "NO_REAL_PATH"));
		
		for (Path path : paths) {
			System.out.println(path.toString());
			System.out.println(Files.isDirectory(path)?"Is a Directory":"Is not a Directory");
			System.out.println(Files.isRegularFile(path)?"Is a File":"Is not a File");
			System.out.println(Files.isSymbolicLink(path)?"Is a SymLink":"Is not a SymLink");
			System.out.println();
		}

		
	}

}
