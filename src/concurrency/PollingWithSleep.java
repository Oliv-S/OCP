package concurrency;

public class PollingWithSleep {
	public  static int counter = 0;

	public static void main(String[] args) throws InterruptedException {
		
		new Thread(() -> {
			for (int i = 0; i < 500; i++) {
				counter++;
				try {
					Thread.sleep(1);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}).start();

		while (counter<40) {
			System.out.println("Not reached yet!");
			Thread.sleep(100);
		}

		System.out.println("Reached!");
	}

}
