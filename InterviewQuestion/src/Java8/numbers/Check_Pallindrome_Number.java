package Java8.numbers;

import java.util.Scanner;
import java.util.stream.IntStream;

public class Check_Pallindrome_Number {

	public static void main(String[] args) {
		System.out.println("Enter the number to check pallindrome : ");
		Scanner sc= new Scanner(System.in);
		int number = sc.nextInt();
		
		String numberAsString = String.valueOf(number);
		int length = numberAsString.length();
		
		boolean isPallindrome =IntStream
												   .rangeClosed(0, (int)length/2)
												   .allMatch(position->numberAsString.charAt(position)==numberAsString.charAt(length-1-position));
		System.out.println(number + "  is  Pallindrome : "+isPallindrome);
	}

}
