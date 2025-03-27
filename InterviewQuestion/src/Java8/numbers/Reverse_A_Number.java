package Java8.numbers;

public class Reverse_A_Number {

	public static void main(String[] args) 
	{
	int number = 4529;
	
	int reversed =Integer.parseInt(new StringBuilder(String.valueOf(number)).reverse().toString());
	System.out.println(reversed);

	}

}
