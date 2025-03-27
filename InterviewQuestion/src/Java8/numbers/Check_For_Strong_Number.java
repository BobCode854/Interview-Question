package Java8.numbers;

import java.util.Arrays;
import java.util.Scanner;

/**
 * --) A Number is said to be a strong number If its factorial sum is equal to the number. 
 * --) 145 = 1!+4!+5! = 1+24+120 = 145
 */
public class Check_For_Strong_Number {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int number = sc.nextInt();
		String numberAsString = String.valueOf(number);
		int sum = Arrays.stream(numberAsString.split(""))
				         .mapToInt(string -> Integer.valueOf(string))
				         .boxed()
				         .map(Check_For_Strong_Number::factorial)
				         .reduce((num1, num2) -> num1 + num2).get();
		
		if(sum == number) {
			System.out.println(number+ " is a Strong Number");
		}
		else {
			System.out.println(number+ " is not a Strong Number");
		}

	}
	public static int factorial(int number) {
		if(number==0 || number ==1)
			 return 1;
		return number*factorial(number-1);
	}

}
