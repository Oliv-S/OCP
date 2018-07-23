package generics;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class GenericSupertypes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Test");
		List<? super IOException> exceptions = new ArrayList<Exception>();
		//exceptions.add(new Exception());
		exceptions.add(new IOException());
		exceptions.add(new FileNotFoundException());

	}

}
