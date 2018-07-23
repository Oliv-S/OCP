package functional_programming;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.function.*;
public class SupplierInterface {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Supplier<LocalDateTime> s1 = LocalDateTime::now;
		Supplier<LocalDateTime> s2 = () -> LocalDateTime.now();
		
		LocalDateTime dt1 = s1.get();
		LocalDateTime dt2 = s2.get();
		
		System.out.println(dt1);
		System.out.println(dt2);
		
		Supplier<ArrayList<String>> s3 = ArrayList<String>::new;
		                            s3 = () -> new ArrayList<String>();
		s3.get().add("1");
		s3.get().add("2");
		s3.get().add("3");	
		System.out.println(s3);
		System.out.println(s3.get());
		
		ArrayList<String> al = s3.get();
		al.add("1");
		al.add("3");
		al.add("2");
		System.out.println(al);
		
	}

}
