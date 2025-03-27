package Java8.string;

import java.util.Arrays;
import java.util.stream.Stream;

public class Merge_Two_String_Array {

	public static void main(String[] args) 
	{
		String[] str1 = { "My", "Name", "Is" };
		String[] str2 = { "Karan", "Raj", "Sinha" };
		String[] mergedArray = Stream.concat(Arrays.stream(str1), Arrays.stream(str2)).toArray(String[]::new);
		System.out.println(Arrays.toString(mergedArray));
     
	}

}
