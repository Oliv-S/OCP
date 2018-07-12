package Exceptions;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.DateTimeParseException;
import java.time.format.FormatStyle;
import java.util.Locale;

public class ExceptionsBasic {

	public static void main(String[] args) throws MyTestException, URISyntaxException {

		//		try {
//			//			throw new MyTestException();
//			//			throw new MyTestException("Test1");
//			//			throw new MyTestException(new RuntimeException());
//			throw new MyTestException(new RuntimeException("Test2"));
//		} catch (MyTestException e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		} catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		}
		
		try {
			ClassLoader loader = ExceptionsBasic.class.getClassLoader();
			Path path = Paths.get(loader.getResource("Exceptions/testdata.txt").toURI());
			String text = new String(Files.readAllBytes(path));
//			System.out.println(LocalDate.now());
//			Locale.setDefault(new Locale("ru", "RU"));
//			System.out.println(ZonedDateTime.now().format(DateTimeFormatter.ISO_ZONED_DATE_TIME));
//			System.out.println(LocalDate.now().format(DateTimeFormatter.ofPattern("dd.MM.yyyy")));
			LocalDate localDate = LocalDate.parse(text,DateTimeFormatter.ofPattern("dd.MM.yyyy"));
			System.out.println(localDate);
		} catch (DateTimeParseException e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new RuntimeException();
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new RuntimeException();
		} catch (Error | Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
			
		}

	}

}
