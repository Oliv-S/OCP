package NestedClasses;

public class StaticNestedClass {

	static class Nested{
		private int var1 = 100;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Nested nested = new Nested();
		System.out.println(nested.var1);
		
	}

}
