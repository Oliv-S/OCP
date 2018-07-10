package DatesTimesAndLocalization;

import java.util.*;
public class Localisation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Locale locale = Locale.getDefault();
		System.out.println(locale);
//		for (Locale l:Locale.getAvailableLocales()) {
//			System.out.println(l);
//		}
//
//		for (String l:Locale.getISOCountries()) {
//			System.out.println(l);
//		}
//
//		for (String l:Locale.getISOLanguages()) {
//			System.out.println(l);
//		}
		
		Locale localeBuilder = new Locale.Builder()
				.setLanguage("ru")
				.setRegion("US")
				.build();
		System.out.println(localeBuilder);
		
		localeBuilder = new Locale.Builder()
				.setRegion("US")
				.build();

		System.out.println(localeBuilder);

	}

}
