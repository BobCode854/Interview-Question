package Java8.numbers;

import java.util.Scanner;

public class Largest_Of_Three_Number {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the three number to check for the largest");
		int number1 = sc.nextInt();
		int number2 = sc.nextInt();
		int number3 = sc.nextInt();
		
		int largest = number1 > number2 && number1 > number3 ? number1
				: number2 > number1 && number2 > number3 ? number2 : number3; 

				System.out.println(largest);

	}

}
