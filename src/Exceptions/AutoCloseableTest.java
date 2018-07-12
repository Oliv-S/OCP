package Exceptions;

public class AutoCloseableTest implements AutoCloseable {

	public static void main(String[] args)  {
		// TODO Auto-generated method stub
		try (AutoCloseableTest autoCloseableTest = new AutoCloseableTest()) {
			autoCloseableTest.doPrint();
			//throw new RuntimeException("Illegal state from main-try");
			throw new IllegalStateException("Illegal state from main-try");
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			for(Throwable t:e.getSuppressed())
				System.out.println(t.getMessage());
			
		} 
		assert false: "test message";

	}

	/* (non-Javadoc)
	 * @see java.lang.AutoCloseable#close()
	 */
	@Override
	public void close() throws IllegalStateException {
		// TODO Auto-generated method stub
		System.out.println("I'm closing");
		throw new IllegalStateException("Illegal state from close.");
		
	}
	
	public void doPrint() {
		System.out.println("Hallo, i'm here.");
	}

}
