package Java8;

import java.util.function.Function;

public class FunctionJava8 {

	public static void main(String[] args) {
	   Function<Integer,Integer> squareOfNumber = (number) -> number * number;
	   int number =squareOfNumber.apply(4);
	   System.out.println(number);
	}

}
