package Java8.string;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Count_The_Number_Of_Duplicate_Words 
{
	public static void main(String[] args) 
	{
		String string = "This is a test. This test is easy.";
		HashSet<String> duplicateWord = new HashSet<>();
		/**
		 *   Way 1
		 */
		long count =Arrays.stream(string.split("\\W")).filter(word->!duplicateWord.add(String.valueOf(word))).count();
		System.out.println("Count of duplicate words way1: "+count);
		
		/**
		 * Way 2
		 */
		Map<String, Long> elementsAndItsCount = Arrays.stream(string.split("\\W"))
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		long duplicateCountOfWord = elementsAndItsCount.entrySet().stream().filter(entry -> entry.getValue() > 1)
				.count();
		System.out.println("duplicateCountOfWord way 2 : " + duplicateCountOfWord);

	}

}
