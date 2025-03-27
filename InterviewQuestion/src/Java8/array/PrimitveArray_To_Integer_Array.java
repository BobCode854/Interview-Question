package Java8.array;

import java.util.Arrays;

public class PrimitveArray_To_Integer_Array {

	public static void main(String[] args) {
		int[] arr = {23,54,12,87,33};
		Integer[] integerArray = Arrays.stream(arr).boxed().toArray(Integer[]::new);
		System.out.println(Arrays.toString(integerArray));
	}

}
