package _01_Java_Core;


public class SingeltonDesignPattern 
{
/**
 *   **) The preceding implementation works fine and provides thread-safety.
 *   **) But it reduces the performance because of the cost associated with the synchronized method.
 *   **) Although we need it only for the first few threads that might create separate instances. 
 *   **) To avoid this extra overhead every time, double-checked locking principle is used. 
 *   **) In this approach, the synchronized block is used inside the if condition with an additional 
 *         check to ensure that only one instance of a singleton class is created. 
 *         The following code snippet provides the double-checked locking implementation: 
 * 
 */
	
	private static volatile SingeltonDesignPattern instance = null;
	private SingeltonDesignPattern() {}
	
	/**
	 * 
	 *  Singelton With Thread safety
	 */
	public static  SingeltonDesignPattern getInstance() {
		if (instance == null) {
			synchronized (SingeltonDesignPattern.class) {
				if (instance == null) {
					instance = new SingeltonDesignPattern();
				}
			}
		}
		return instance;
	}
	
	public static void main(String[] args) 
	{
		SingeltonDesignPattern instance = SingeltonDesignPattern.getInstance();
        System.out.println(instance);
        instance = SingeltonDesignPattern.getInstance();
        System.out.println(instance);
	}

}

