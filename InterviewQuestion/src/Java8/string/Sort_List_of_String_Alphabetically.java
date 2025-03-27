package Java8.string;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Sort_List_of_String_Alphabetically {

	public static void main(String[] args) {
		 List<String> strings = Arrays.asList("Java", "Python", "C++", "JavaScript", "Ruby");
		 System.out.println("Ascending order of alphabet sorting");
		 strings= strings.stream().sorted(String::compareTo).collect(Collectors.toList());
		 System.out.println(strings);
		 System.out.println();
		 System.out.println("Descending order of alphabet sorting");
		 strings= strings.stream().sorted(Collections.reverseOrder(String::compareTo)).collect(Collectors.toList());
		 System.out.println(strings);
	}

}