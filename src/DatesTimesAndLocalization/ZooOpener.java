package DatesTimesAndLocalization;

import java.util.Locale;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.TreeSet;

public class ZooOpener {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		System.out.println(System.getProperty("user.dir"));
//		System.out.println(ZooOpener.class.getPackage().getName());
		

		Locale usLocale = new Locale("en","US");
		Locale frLocale = new Locale.Builder()
				.setLanguage("fr")
				.setRegion("FR")
				.build();

		printProperties(null);
		printProperties(frLocale);
		printProperties(usLocale);
		
	}
	
	public static void printProperties(Locale locale) {
		if (locale!=null){
			final ResourceBundle resourceBundle = ResourceBundle.getBundle(ZooOpener.class.getPackage().getName()+"/Zoo", locale);
			System.out.println(resourceBundle.getString("hello"));
			System.out.println(resourceBundle.getString("open"));
			

		}else {
			final ResourceBundle resourceBundle = ResourceBundle.getBundle(ZooOpener.class.getPackage().getName()+"/ZooOpener");
			Set<String> keySet = new TreeSet<String>(resourceBundle.keySet());
			for (String string : keySet) {
				System.out.println(string + " = " + resourceBundle.getString(string));				
			}
			
			Properties properties = new Properties();
			resourceBundle.keySet().stream().forEach(x->properties.put(x, resourceBundle.getObject(x)));
			System.out.println("notReallyProperty = " + properties.getProperty("notReallyProperty"));
			System.out.println("notReallyProperty = " + properties.getProperty("notReallyProperty", "Default value"));
		}
		System.out.println("");
	}

}
