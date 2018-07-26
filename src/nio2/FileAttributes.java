package nio2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.time.LocalDateTime;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class FileAttributes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Path path = Paths.get("target/classes/test.txt");
		try {
			BasicFileAttributes fileAttributes = Files.readAttributes(path, BasicFileAttributes.class);
			//System.out.println(fileAttributes.lastAccessTime());
			
			BasicFileAttributeView fileAttributeView = Files.getFileAttributeView(path, BasicFileAttributeView.class);
			fileAttributes = fileAttributeView.readAttributes();

			

			System.out.println(ToStringBuilder.reflectionToString(fileAttributes, ToStringStyle.MULTI_LINE_STYLE));
			fileAttributeView.setTimes(FileTime.fromMillis(System.currentTimeMillis()), null, null);
			fileAttributes = fileAttributeView.readAttributes();
			
			System.out.println(ToStringBuilder.reflectionToString(fileAttributes, ToStringStyle.MULTI_LINE_STYLE));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
