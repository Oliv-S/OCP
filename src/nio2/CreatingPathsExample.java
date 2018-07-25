package nio2;

import java.io.File;
import java.net.*;
import java.nio.file.*;
import java.util.*;


public class CreatingPathsExample {

	public static void main(String[] args) throws URISyntaxException {
		// TODO Auto-generated method stub
		List<Path> pathList = new ArrayList<>(); 
		//Using Paths
		
		pathList.add(Paths.get("target/classes/nio2/CreatingPathsExample.class")); 
		pathList.add(Paths.get("C:\\Utils\\rarreg.key")); 
		pathList.add(Paths.get("C://Windows")); 

		//Using Paths and varargs
		pathList.add(Paths.get("target", "classes", "nio2", "CreatingPathsExample.class")); 
		pathList.add(Paths.get("C:", "Utils", "rarreg.key")); 
		pathList.add(Paths.get("Windows"));//!!! 

		//Using Paths and URI
		//URI must to be Absolute 
		//Use: "file:///C:/Windows"
		//Use: "file:///home/root"
		pathList.add(Paths.get(new URI("file:///target/classes/nio2/CreatingPathsExample.class"))); //!!!!!
		pathList.add(Paths.get(new URI("file:///C:/Utils/rarreg.key"))); 
		pathList.add(Paths.get(new URI("file:///C:/Windows"))); 

		//Using Paths and URI for Internet Ressources
		//Not working
//		pathList.add(Paths.get(new URI("http://ya.ru"))); 
//		pathList.add(Paths.get(new URI("https://google.com"))); 

//		for (Path path : pathList) {
//			System.out.println(path);
//			System.out.println(path.toAbsolutePath());
//			System.out.println(path.toUri());
//			System.out.println();
//		}
		
		//Using FileSystems and getPath
		pathList.add(FileSystems.getDefault().getPath("target/classes/nio2/CreatingPathsExample.class"));
		pathList.add(FileSystems.getDefault().getPath("C:", "Utils", "rarreg.key"));
		pathList.add(FileSystems.getDefault().getPath("Utils"));
		pathList.add(FileSystems.getDefault().getPath("C:/Windows"));
		
		pathList.stream().skip(9).limit(4).forEach(e->{System.out.println(e);
														System.out.println(e.toAbsolutePath());
														System.out.println(e.toUri());
														System.out.println();});

		//Using FileSystems, getFileSystem and URI
//		pathList.add(FileSystems.getFileSystem(new URI("http://ya.ru")).getPath(""));
//		
//		pathList.stream().skip(13).limit(1).forEach(e->{System.out.println(e);
//														System.out.println(e.toAbsolutePath());
//														System.out.println(e.toUri());
//														System.out.println();});

		//Converting Path <-> File
		Path path = Paths.get("C://Windows//system32//notepad.exe");
		File file = path.toFile();
		path = file.toPath();
		
		System.out.println("******************");
		path = pathList.get(0);
		System.out.println("The path name is: " + path);
		System.out.println("Are the current path and Absolute path the same?: " + (path == path.toAbsolutePath()));
		System.out.println(path.isAbsolute()?"The Path is Absolute":"The Path is Relative");
		System.out.println("The FileName name is: " + path.getFileName());
		System.out.println("The Parent name is: " + path.getParent());
		System.out.println("The Parent name is: " + path.getParent().getParent());
		System.out.println("The Parent name is: " + path.getParent().getParent().getParent());
		System.out.println("The Parent name is: " + path.getParent().getParent().getParent().getParent());
		System.out.println("The Root name is: " + path.getRoot());
		System.out.println("The path name count: " + path.getNameCount());
		for (int i = 0; i < path.getNameCount(); i++) {
			System.out.println("\t"+path.getName(i));
			
		}
		
		System.out.println("******************");
		path = path.toAbsolutePath();
		System.out.println("The path name is: " + path);
		System.out.println("Are the current path and Absolute path the same?: " + (path == path.toAbsolutePath()));
		System.out.println(path.isAbsolute()?"The Path is Absolute":"The Path is Relative");
		System.out.println("The FileName name is: " + path.getFileName());
		System.out.println("The Parent name is: " + path.getParent());
		System.out.println("The Root name is: " + path.getRoot());
		System.out.println("The path name count: " + path.getNameCount());
		for (int i = 0; i < path.getNameCount(); i++) {
			System.out.println("\t"+path.getName(i));
			
		}

		//Subpath
		System.out.println("********Subpath**********");
		System.out.println("The path name is: " + path);
		System.out.println("Subpath from 0 to 6 is:" + path.subpath(0, 5));
		System.out.println("Subpath from 2 to 4 is:" + path.subpath(2, 4));
		System.out.println("Subpath from 3 to 4 is:" + path.subpath(3, 4));
		
		//Relativize
		System.out.println("*******Relativize***********");
		Path path1 = Paths.get("alex.txt");
		Path path2 = Paths.get("john.txt");
		System.out.println("Relativize \t" + path1 + " \r\nto \t\t" + path2 + " \r\nis: \t\t" +path1.relativize(path2));
		System.out.println("Relativize \t" + path2 + " \r\nto \t\t" + path1 + " \r\nis: \t\t" +path2.relativize(path1));
		System.out.println();
		path1 = Paths.get("target/classes/nio2/CreatingPathsExample.class").toAbsolutePath();
		path2 = Paths.get("C:", "Utils", "rarreg.key");
		System.out.println("Relativize \t" + path1 + " \r\nto \t\t" + path2 + " \r\nis: \t\t" +path1.relativize(path2));
		System.out.println("Relativize \t" + path2 + " \r\nto \t\t" + path1 + " \r\nis: \t\t" +path2.relativize(path1));

		System.out.println();
		path1 = Paths.get("nio2/CreatingPathsExample.class");
		path2 = Paths.get("Utils", "rarreg.key");
		System.out.println("Relativize \t" + path1 + " \r\nto \t\t" + path2 + " \r\nis: \t\t" +path1.relativize(path2));
		System.out.println("Relativize \t" + path2 + " \r\nto \t\t" + path1 + " \r\nis: \t\t" +path2.relativize(path1));

		System.out.println();
		path1 = Paths.get("nio2/CreatingPathsExample.class");
		path2 = Paths.get("C:","Utils", "rarreg.key");
//		System.out.println("Relativize \t" + path1 + " \r\nto \t\t" + path2 + " \r\nis: \t\t" +path1.relativize(path2));
//		Exception in thread "main" java.lang.IllegalArgumentException: 'other' is different type of Path
		path1 = Paths.get("D:","Utils", "rarreg.key");
		path2 = Paths.get("C:","Utils", "rarreg.key");
//		System.out.println("Relativize \t" + path1 + " \r\nto \t\t" + path2 + " \r\nis: \t\t" +path1.relativize(path2));
//		Exception in thread "main" java.lang.IllegalArgumentException: 'other' is different type of Path
		
		//Path resolve() 
		//and normalize()
		path1 = Paths.get("nio2/CreatingPathsExample.class");
		path2 = Paths.get("C:","Utils", "rarreg.key");
		System.out.println("Resolve \t" + path1 + " \r\nto \t\t" + path2 + " \r\nis: \t\t" +path1.resolve(path2));
		System.out.println();
		path1 = Paths.get("nio2/CreatingPathsExample.class");
		path2 = Paths.get("../","Utils", "rarreg.key");
		System.out.println("Resolve \t" + path1 + " \r\nto \t\t" + path2 + " \r\nis: \t\t" +path1.resolve(path2));
		Path path3 = path1.resolve(path2);
		System.out.println("Normalize \t" + path3 + " \r\nto \t\t" + path3.normalize());
		
	}

}
