package Java8.numbers;

import java.util.Scanner;
import java.util.stream.IntStream;

public class Sum_Of_Natural_Number {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number till which you want sum");
		int number = sc.nextInt();

		int sumOfNaturalNumber = IntStream.rangeClosed(0, number).reduce((num1, num2) -> num1 + num2).orElse(0);
		System.out.println("Sum Of " + number + "natural number is : " + sumOfNaturalNumber);

	}

}
