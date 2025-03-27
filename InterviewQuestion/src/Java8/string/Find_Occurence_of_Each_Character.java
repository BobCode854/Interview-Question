package Java8.string;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Find_Occurence_of_Each_Character {

	public static void main(String[] args) {
		String string = "This is a test.This test is easy";

		Map<String, Long> characterAndItsCount = Arrays.stream(string.replace(" ", "").split(""))
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		System.out.println("elementAndItsCount : " + characterAndItsCount);

		/**
		 * Find Maximum occurence of Character
		 */

		String maximumNumberOfRepeatedChaarcterInAString = characterAndItsCount.entrySet().stream()
				.sorted((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue())).map(Map.Entry::getKey)
				.findFirst().get();

		System.out.println("maximumNumberOfRepeatedChaarcterInAString : " + maximumNumberOfRepeatedChaarcterInAString);
	}

}
