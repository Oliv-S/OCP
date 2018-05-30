package NestedClasses;

public class LocalInnerClass {
	private int var1 = 200;

	public void calc() {
		int var2 = 500;
		class Inner{
			public void multiply() {
				System.out.println(var1*var2);
			}
		}
		Inner inner = new Inner();
		inner.multiply();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LocalInnerClass outer = new LocalInnerClass();
		outer.calc();

	}
	

}
