package Java8.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

/**
 *  Find Duplicate In Array
 */
public class Find_Duplicate_In_Array {

	public static void main(String[] args) 
	{
		int arr[] = { 1, 2, 3, 4, 3, 2, 25 };
		HashSet<Integer> hashSet = new HashSet<>();
		/**
		 * Whenever we will add primitive data we should boxed()
		 */
		List<Integer> duplicateData = Arrays.stream(arr).boxed().filter(number -> !hashSet.add(number))
				.collect(Collectors.toList());
		System.out.println(duplicateData);
	}

}
