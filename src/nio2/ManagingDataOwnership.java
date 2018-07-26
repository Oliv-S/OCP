package nio2;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.UserPrincipal;

public class ManagingDataOwnership {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	
		Path path = Paths.get("target/classes/test.txt");
		try {
			UserPrincipal owner = Files.getOwner(path);
			System.out.println(owner.getName());
			path = Paths.get("c:/windows");
			owner = Files.getOwner(path);
			System.out.println(owner.getName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
