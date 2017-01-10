package testHelpers;

public class Waiter {
	
	public static void waitASecond()
	{
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
