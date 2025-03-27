package Java8.numbers;

import java.util.stream.Stream;

public class Find_Fibonacci_Series {

	public static void Java7Way() {
		     int n = 10;
	        int a = 0, b = 1;
	        System.out.println("Fibonacci Series:");
	        for (int i = 0; i < n; i++) {
	            System.out.println(a);
	            int next = a + b;
	            a = b;
	            b = next;
	        }
	}
	public static void Java8Way() {
		System.out.println("Java8 way");
		 Stream.iterate(new int[]{0, 1}, f -> new int[]{f[1], f[0] + f[1]})
         .limit(10)
         .map(f -> f[0]) 
         .forEach(System.out::println); 
	}
	public static void main(String[] args) 
	{
		Java7Way();
		Java8Way();
	}

}
