package Java8.array;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PrimitveArray_To_Integer_List {

	public static void main(String[] args) {
		int[] arr = {23,54,12,87,33};
		List<Integer> arrList = Arrays.stream(arr).boxed().collect(Collectors.toList());
		System.out.println(arrList);
	}

}
