package Java8.string;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Remove_Duplicate {

	public static void main(String[] args) {
		String string = "Java is great and Java is fun and Java is powerful";
		Set<String> finalString =Arrays.stream(string.split(" ")).collect(Collectors.toCollection(LinkedHashSet::new));
        System.out.println(finalString);
	}

}
