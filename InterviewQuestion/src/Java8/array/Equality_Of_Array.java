package Java8.array;

import java.util.Arrays;

public class Equality_Of_Array {

	public static void main(String[] args) 
	{
		int arr1[] = { 1, 2, 3, 4, 3, 2, 25 };
		int arr2[] = {3,2,1,4,25};
		
		/**
		 *  Equality Of Array
		 */
		boolean isEqual = Arrays.stream(arr1).distinct()
				.allMatch(arr1Data -> Arrays.stream(arr2).distinct().
						anyMatch(arr2Data -> arr2Data == arr1Data));

		System.out.println("Both arrays are equal : "+isEqual);
	}

}
