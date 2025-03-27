package Java8.string;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Reverse_A_String {

	public static void main(String[] args) {
	
		 String string = "Karan Raj Sinha";
			String reversedString = Stream.of(string).map(word -> new StringBuilder(word).reverse())
					.collect(Collectors.joining(""));
         System.out.println(reversedString);
	}

}
