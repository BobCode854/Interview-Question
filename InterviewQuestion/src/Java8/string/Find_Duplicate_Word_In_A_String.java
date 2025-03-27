package Java8.string;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 *  Print all duplicate words
 */
public class Find_Duplicate_Word_In_A_String
{
	public static void main(String[] args) 
	{
		String string = "This is a test. This test is easy.";
		String[] stringarr = string.split("\\W");
		HashSet<String> uniqueWord = new HashSet<>();
		Set<String> duplicateWords = Arrays.stream(stringarr).filter(word -> !uniqueWord.add(word))
				.collect(Collectors.toSet());
		System.out.println(duplicateWords);
	}

}
