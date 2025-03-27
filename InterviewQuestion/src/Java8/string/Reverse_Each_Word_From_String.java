package Java8.string;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Reverse_Each_Word_From_String {

	public static void main(String[] args) {
		String input = "Java is great and fun";
		String finalOutput = Arrays.stream(input.split(" ")).map(word -> new StringBuilder(word).reverse())
				.collect(Collectors.joining(" "));
		
		System.out.println("finalOutput : "+finalOutput);
	}

}
