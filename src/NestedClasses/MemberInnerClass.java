package NestedClasses;

public class MemberInnerClass {
	
	private String greeting = "This is ClassWithNested Class!!!";
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//First type of use Inner
		MemberInnerClass outer = new MemberInnerClass();
		outer.CallInnerClass();
		
		//Second type of use Inner
		MemberInnerClass.InnerClass inner = outer.new InnerClass();
		inner.printGreeting();
		//System.out.println("This is ClassWithNested Class!!!");

	}
	
	protected class InnerClass{
		public void printGreeting() {
			System.out.println(greeting);			
		}
	}
	
	public void CallInnerClass() {
		InnerClass inner = new InnerClass();
		inner.printGreeting();
	}

}
