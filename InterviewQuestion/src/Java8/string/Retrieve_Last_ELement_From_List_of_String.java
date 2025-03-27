package Java8.string;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Retrieve_Last_ELement_From_List_of_String {

	public static void main(String[] args) {
		 List<String> strings = Arrays.asList("Java", "Python", "C++", "JavaScript", "Ruby");
		 Optional<String> lastElement = strings.stream().reduce((first,second)->second);
		 lastElement.ifPresent(element->System.out.println(element));
	}

}