package Java8;

import java.util.function.Consumer;

public class ConsumerExample {

	public static void main(String[] args) 
	{
	
Consumer<String> consumer = (string) -> System.out.println(string);
consumer.accept("Karan");
	}

}
