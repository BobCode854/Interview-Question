package Java8.string;

import java.util.Arrays;

public class Find_Occurence_Of_Substring_In_A_String {

	public static void main(String[] args) {
		String string = "This is a test.This test is easy";
		String substring = "test";
		long numberOfOccurenceOfString = Arrays.stream(string.split("\\W+")).filter(word -> word.equals(substring))
				.count();
System.out.println("numberOfOccurenceOfString : "+numberOfOccurenceOfString);
	}

}
