package DatesTimesAndLocalization;

import java.text.MessageFormat;
import java.util.Arrays;
import java.util.ListResourceBundle;
import java.util.ResourceBundle;

public class JavaClassResourceBundle extends ListResourceBundle {

	@Override
	protected Object[][] getContents() {
		return new Object[][] { 
			{ "hello", "Hello"}, 
			{ "open", "The zoo is open" }, 
			{ "param1", "param1, {0}" }, 
			{ "param2", new String[] {"123","234","345"} }, 
		};
	}
	
	public static void main(String... arg0) {
		System.out.println("test");
		ResourceBundle resourceBundle = ResourceBundle.getBundle("DatesTimesAndLocalization.JavaClassResourceBundle");
		System.out.println(resourceBundle.getString("hello"));
		System.out.println(resourceBundle.getString("open"));
		System.out.println(MessageFormat.format(resourceBundle.getString("param1"),"par1"));
		System.out.println(Arrays.asList((String[])(resourceBundle.getObject("param2"))));
	}
}
