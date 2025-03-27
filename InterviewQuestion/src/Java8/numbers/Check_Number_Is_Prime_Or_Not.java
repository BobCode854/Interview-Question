package Java8.numbers;

import java.util.Scanner;
import java.util.stream.IntStream;

public class Check_Number_Is_Prime_Or_Not {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int number = sc.nextInt();
		boolean isPrime = IntStream.rangeClosed(2, (int)Math.sqrt(number))
				                          .allMatch(n->number%n!=0);
		System.out.println(number +" is prime : "+isPrime);

	}

}
