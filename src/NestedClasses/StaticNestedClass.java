package NestedClasses;

public class StaticNestedClass {

	static class Nested{
		private int var1 = 100;
	}

	static class Browser{
		public void printName() {
			System.out.println("Browser");;
		}
	}

	static class FireFox extends Browser{
		public void printName() {
			System.out.println("FirFox");;
		}
	}

	static class IE extends Browser{
		@Override public void printName() {
			System.out.println("IE");;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Nested nested = new Nested();
		System.out.println(nested.var1);
		
		Browser browser = new FireFox();
		browser.printName();
		
		FireFox ff = (FireFox) browser;
		ff.printName();
		
		try {
		IE ie = (IE) browser;
		ie.printName();
		}
		catch (ClassCastException e) {
			// TODO: handle exception
			System.out.println("Can't convert FF to IE");
		}
		
	}

}
