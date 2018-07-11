package DatesTimesAndLocalization;

import java.util.Locale;
import java.util.ResourceBundle;

public class ZooOpener {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(System.getProperty("user.dir"));
		Locale usLocale = new Locale("en_US");
		Locale frLocale = new Locale.Builder()
				.setLanguage("fr")
				.setRegion("FR")
				.build();
		printProperties(null);
		printProperties(frLocale);
		printProperties(usLocale);

	}
	
	public static void printProperties(Locale locale) {
		ResourceBundle resourceBundle=null;
		if (locale!=null){
			resourceBundle = ResourceBundle.getBundle("Zoo", locale);
			System.out.println("Gefunden!");
		}else {
			resourceBundle = ResourceBundle.getBundle("Zoo");
			System.out.println("Gefunden!");
		}
		System.out.println(resourceBundle.getString("hello"));
		System.out.println(resourceBundle.getString("open"));
	}

}
