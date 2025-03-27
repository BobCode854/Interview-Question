package Java8.array;

import java.util.Arrays;
import java.util.Collections;

public class Find_Second_Largest_Number {

	public static void main(String[] args) {
		int[] arr = { 24, 65, 55, 34, 87, 87 };

		int secondLargestNumber = Arrays.stream(arr).boxed().sorted(Collections.reverseOrder()).distinct().skip(1)
				.findFirst().orElseGet(null);
		
		System.out.println(secondLargestNumber);
	}

}
