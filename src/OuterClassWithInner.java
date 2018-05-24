
public class OuterClassWithInner {
	
	private String greeting = "This is ClassWithNested Class!!!";
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		OuterClassWithInner outer = new OuterClassWithInner();
		outer.CallInnerClass();
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
