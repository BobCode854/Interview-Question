package Java8.string;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Find_Duplicate_Character_In_A_String {

	public static void main(String[] args) {
		String string = "Karan Raj Sinha";
		HashSet<String> hashset = new HashSet<>();
		
		Set<String> duplicateCharacterSet = Arrays.stream(string.replace(" ", "").split(""))
				.filter(word -> !hashset.add(word)).collect(Collectors.toSet());
		
		System.out.println(duplicateCharacterSet);

	}

}
