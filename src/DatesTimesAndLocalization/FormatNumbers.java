package DatesTimesAndLocalization;

import java.text.*;
import java.util.*;

public class FormatNumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Locale.setDefault(new Locale("ru", "RU"));
		
		int valuePerYear = 3_200_000;
		int valuePerMonth = valuePerYear/12;
		double price = 1_348_345.12;
		
		NumberFormat us = NumberFormat.getInstance(Locale.US);
		System.out.println(us.format(valuePerYear));
		System.out.println(us.format(valuePerMonth));
		us = NumberFormat.getCurrencyInstance(Locale.US);
		System.out.println(us.format(price));
		System.out.println();

		NumberFormat de = NumberFormat.getInstance(Locale.GERMANY);
		System.out.println(de.format(valuePerYear));
		System.out.println(de.format(valuePerMonth));
		de = NumberFormat.getCurrencyInstance(Locale.GERMANY);
		System.out.println(de.format(price));
		System.out.println();

		NumberFormat ca = NumberFormat.getInstance(Locale.CANADA_FRENCH);
		System.out.println(ca.format(valuePerYear));
		System.out.println(ca.format(valuePerMonth));
		ca = NumberFormat.getCurrencyInstance(Locale.CANADA_FRENCH);
		System.out.println(ca.format(price));
		System.out.println();

		NumberFormat ru = NumberFormat.getInstance(new Locale("ru", "RU"));
		System.out.println(ru.format(valuePerYear));
		System.out.println(ru.format(valuePerMonth));
		ru = NumberFormat.getCurrencyInstance(new Locale("ru", "RU"));
		System.out.println(ru.format(price));
		System.out.println();

	}

}
