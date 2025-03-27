package Java8.string;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class String_Upper_Case {

	public static void main(String[] args) 
	{
	 String str = "Hello World";
	 String upperCaseString=Arrays.stream(str.split("")).map(String::toUpperCase).collect(Collectors.joining());
	 System.out.println("upperCaseString : "+upperCaseString);
	}

}
