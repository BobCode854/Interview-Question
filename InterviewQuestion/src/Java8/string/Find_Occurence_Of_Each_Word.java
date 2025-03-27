package Java8.string;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Find_Occurence_Of_Each_Word {

	public static void main(String[] args)
	{
		String string = "This is a test.This test is easy";
		Map<String, Long> elementAndItsCount = Arrays.stream(string.split("\\W"))
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		System.out.println("elementAndItsCount : "+elementAndItsCount);
	}

}
