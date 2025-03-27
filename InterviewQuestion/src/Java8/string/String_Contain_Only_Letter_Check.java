package Java8.string;

public class String_Contain_Only_Letter_Check 
{
	public static void main(String[] args) 
	{
	String string = "hello";
	boolean isAlphabet =  string.trim().chars().allMatch(Character::isAlphabetic);
	System.out.println(isAlphabet);
	
	boolean isAlphabet2 =string.matches("[a-zA-z]+");
	System.out.println(isAlphabet2);
	}
}

