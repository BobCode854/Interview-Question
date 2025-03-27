package Java8.string;

public class String_Contain_Only_Digit_Check {

	public static void main(String[] args) 
	{
	String string1 = "1234";
	boolean isOnlyDigit = string1.chars().allMatch(Character::isDigit);
	System.out.println(isOnlyDigit);
	boolean isOnlyDigit2= string1.matches("\\d+"); 
	System.out.println(isOnlyDigit2);
	}

}
