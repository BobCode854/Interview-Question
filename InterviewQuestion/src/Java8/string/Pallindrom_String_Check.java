package Java8.string;

import java.util.stream.IntStream;

public class Pallindrom_String_Check {

	public static void main(String[] args) {
		String string = "KaraK";
		String tempString = string.replaceAll("\\s", "").toLowerCase(); //removing spaces and converting to lowercase
		System.out.println(tempString);
		int tempStringlength = tempString.length();
		boolean isPallindrome = IntStream.range(0, tempStringlength / 2)
				.allMatch(i -> tempString.charAt(i) == tempString.charAt(tempStringlength - (i + 1)));
		System.out.println(isPallindrome);
	}

}
