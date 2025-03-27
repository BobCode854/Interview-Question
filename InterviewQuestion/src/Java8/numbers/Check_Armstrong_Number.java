package Java8.numbers;

/**
 * Armstrong number is a number that is equal to the sum of its own digits,
 * , each raised to the power of the number of digits.
 */
public class Check_Armstrong_Number {

	public static void main(String[] args)
	{
		int number = 153; // 3 digit
		String numberInString = String.valueOf(number);
		int length = numberInString.length();
		int digitSum = numberInString.chars()
				                  .map(Character::getNumericValue)
				                  .map(numb -> (int) Math.pow(numb, length))
				                   .sum();

		if (digitSum == number) {
			System.out.println(number + " is  armstrong");
		} else {
			System.out.println(number + " is  not armstrong");
		}
			
	}

}
