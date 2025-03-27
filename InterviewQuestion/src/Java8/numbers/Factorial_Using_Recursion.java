package Java8.numbers;

public class Factorial_Using_Recursion {

	public static int factorial(int number) 
	{
		if(number==0 || number ==1) {
			return 1;
		}
	   return number *factorial(number-1);

		 
	}
	public static void main(String[] args) {
	   int number = 5;
	   System.out.println(factorial(5));
	}

}
