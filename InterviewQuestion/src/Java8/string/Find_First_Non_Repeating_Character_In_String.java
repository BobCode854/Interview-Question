package Java8.string;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Find_First_Non_Repeating_Character_In_String 
{
	public static Character way1(String string) {
		LinkedHashMap<Character, Integer> linkedhashMap = new LinkedHashMap<>();
		string.chars().mapToObj(c -> (char) c).forEach(word -> {
			if (linkedhashMap.containsKey(word)) {
				linkedhashMap.put(word, linkedhashMap.get(word) + 1);
			} else {
				linkedhashMap.put(word, 1);
			}
		});
		Entry<Character, Integer> entryObject = linkedhashMap.entrySet().stream().filter(entry -> entry.getValue() == 1)
				.findFirst().get();
		return entryObject.getKey();
	}

	private static Character way2(String string) {
		Map<Character, Long> nonRepeatingCharacter = string.chars().mapToObj(c -> (char) c)
				.collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()));

		return nonRepeatingCharacter.entrySet().stream().filter(entry -> entry.getValue() == 1).map(Map.Entry::getKey)
				.findFirst().get();
	}

	public static void main(String[] args) {
		String string = "Karan Raj";
		Character firstNonRepeatingCharacter = way1(string);
		System.out.println(firstNonRepeatingCharacter);

		Character firstNonRepeatingCharacter2 = way2(string);
		System.out.println(firstNonRepeatingCharacter2);
	}
}
