package Java8.string;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Find_All_permutation_Of_String {

	public static List<String> getPermutationsUsingJava8(String str) {
		if (str.isEmpty()) {
			return List.of("");
		}
		return IntStream.range(0, str.length()).boxed()
				.flatMap(i -> getPermutationsUsingJava8(str.substring(0, i) + str.substring(i + 1)).stream()
						.map(s -> str.charAt(i) + s))
				.collect(Collectors.toList());
	}

	public static void findPermutationsUsingJava7(String str, String prefix) {
		if (str.isEmpty()) {
			// Base case: If the string is empty, print the prefix
			System.out.println(prefix);
		} else {
			for (int i = 0; i < str.length(); i++) {
				// Choose the character at index i
				char ch = str.charAt(i);

				// Form the remaining string after removing the character at index i
				String remaining = str.substring(0, i) + str.substring(i + 1);
				// Recurse with the remaining string and the prefix updated with the chosen
				// character
				findPermutationsUsingJava7(remaining, prefix + ch);
			}
		}
	}
	public static void main(String[] args) {
	
		String string = "ABC";
		//findPermutationsUsingJava7(string,"");
		List<String> permutations = getPermutationsUsingJava8(string);
        permutations.forEach(System.out::println);

	}

}
