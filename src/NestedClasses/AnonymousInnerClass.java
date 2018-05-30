package NestedClasses;

public class AnonymousInnerClass {
	
	abstract class Inner{
		abstract int add(int var1, int var2);
	}
	
	public int calc(int var1, int var2) {
		Inner inner = new Inner() {
			int add(int var1, int var2) {
				return var1+var2;
			}
		};
		return inner.add(var1, var2);
	}
	
	private interface InnerInterface{
		int add(int var1, int var2);
	}
	public int calcWithInterface(int var1, int var2) {
		InnerInterface inner = new InnerInterface() {
			public int add(int var1, int var2) {
				return var1+var2;
			}
		};
		return inner.add(var1, var2);
	}
	
	public int calc2(int var1, int var2) {
		return add(var1, var2,new InnerInterface() {
			public int add(int var1, int var2) {
				return var1+var2;
			};
		});		
	}
	
	public int add(int var1, int var2, InnerInterface interf) {
		return interf.add(var1, var2);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AnonymousInnerClass outer = new  AnonymousInnerClass();
		System.out.println(outer.calc(10,15));
		System.out.println(outer.calcWithInterface(10,15));
		System.out.println(outer.calc2(10,15));

	}

}
