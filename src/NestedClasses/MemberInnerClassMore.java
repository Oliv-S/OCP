package NestedClasses;

public class MemberInnerClassMore {

	private int var=100;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MemberInnerClassMore member = new MemberInnerClassMore();
		MemberInnerClassMore.A a = member.new A();
		MemberInnerClassMore.A.B b = a.new B();
		MemberInnerClassMore.A.B.C c = b.new C();
		
		c.printAllVarValues();

	}
	
	class A{
		private int var=200;
		class B{
			private int var=300;
			class C{
				private int var=400;
				public void printAllVarValues() {
					System.out.println(var);
					System.out.println(this.var);
					System.out.println(MemberInnerClassMore.this.var);
					System.out.println(A.this.var);
					System.out.println(B.this.var);
					System.out.println(C.this.var);

				}
			}			
		}
	}
}
