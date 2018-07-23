package io;

import java.io.File;
import java.io.IOException;

public class IoBasic {

	public static void main(String[] args) throws IOException {
		System.out.println("Current file separator character: " + System.getProperty("file.separator"));
		System.out.println("Current file separator character: " + java.io.File.separator);
		System.out.println("Current path Separator character: " + java.io.File.pathSeparator);
		System.out.println();
		
		//Check for file exist
		String filePath = "C:\\windows\\system32\\notepad.exe";
		File file = new File(filePath);
		System.out.println("The file: \"" + filePath + "\" is exist: " + file.exists());
		filePath = "noname";
		file = new File(filePath);
		System.out.println("The file: \"" + filePath + "\" is exist: " + file.exists());

		System.out.println();
		String fileName = "calc.exe";
		String path = "C:\\windows\\system32\\";
		File parent = new File(path);
		File child = new File(parent, fileName);
		System.out.println("The file: \"" + child.getAbsolutePath() + "\" is exist: " + file.exists());
		System.out.println("The path: " + child.getPath());
		System.out.println("The CanonicalPath: " + child.getCanonicalPath());
		System.out.println("The Parent: " + child.getParent());
		System.out.println("The name: " + child.getName());
		
		
		printDirContent(new File("C:\\Utils"),0);
	}
	
	public static void printDirContent(File file, int deep) {
		//If file not exist or not a folder
		if (!file.exists() || !file.isDirectory()) return;
		File[] fileList = file.listFiles();
		
		//Folder empty?
		if (fileList == null || fileList.length==0) return;
		
		
		for (int i = 0; i < fileList.length; i++) {
			for (int j=0; j<deep;j++)System.out.print(" ");
			System.out.println(fileList[i].getName());
			if (fileList[i].isDirectory()) {
				printDirContent(fileList[i],deep+2);
			}
		}
	}

}
