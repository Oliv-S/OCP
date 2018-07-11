package DatesTimesAndLocalization;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

public class ParsingNumbers {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		String price = "123,45";
		
		NumberFormat us = NumberFormat.getInstance(Locale.US);
		System.out.println(us.parse(price));
		System.out.println();

		NumberFormat de = NumberFormat.getInstance(Locale.GERMANY);
		System.out.println(de.parse(price));
		System.out.println(de.parse("34534afsdasdfas"));
		System.out.println();
		System.out.println(de.parse("-23,45-45er-df"));
		System.out.println();
//		System.out.println(de.parse("a345345"));
		System.out.println();

	}

}
