package Java8.numbers;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Find_Prime_Number {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number till which you want prime Number");
		int number = sc.nextInt();
		List<Integer> primeNumbers = IntStream.rangeClosed(2, 10).filter(Find_Prime_Number::isPrime).boxed()
				.collect(Collectors.toList());
		System.out.println("Prime Number till " + number + " : " + primeNumbers);
	}

	public static boolean isPrime(int number) {
		boolean isPrime = number > 1
				&& IntStream.rangeClosed(2, (int) Math.sqrt(number)).allMatch(n -> number % n != 0);
		return isPrime;
	}
}
