package Java8.array;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Sort_Using_Descending_Order {

	public static void sortingDescendingWay1(int[] arr) {
		Object[] sortedArrayDesc = Arrays.stream(arr).boxed().sorted(Collections.reverseOrder()).toArray();
		System.out.println(Arrays.toString(sortedArrayDesc));
	}

	public static void sortingDescendingWay2(int[] arr) {
		int[] sortedArrayDesc = Arrays.stream(arr).boxed().sorted(Collections.reverseOrder()).mapToInt(Integer::intValue).toArray();
		System.out.println(Arrays.toString(sortedArrayDesc));
	}

	public static void sortingDescendingWay3(int[] arr) {
		int[] sortedArray = Arrays.stream(arr).boxed().sorted(Collections.reverseOrder(Integer::compareTo)).mapToInt(Integer::intValue).toArray();
		System.out.println(Arrays.toString(sortedArray));
	}

	public static void sortingDescendingWay4(int[] arr) {
		List<Integer> arrList = Arrays.stream(arr).boxed().collect(Collectors.toList());
		Integer[] integerArray = Arrays.stream(arr).boxed().toArray(Integer[]::new);
		
		Arrays.sort(integerArray,Collections.reverseOrder());
		System.out.println(Arrays.toString(integerArray));
	}

	public static void main(String[] args) {
		int[] arr = {23,54,12,87,33};
		sortingDescendingWay1(arr);
		sortingDescendingWay2(arr);
		sortingDescendingWay3(arr);
		sortingDescendingWay4(arr);
	}
/**
	 * Which One to Use?
✅ For arrays → Arrays.sort(arr) (Most efficient)
✅ For lists → list.sort(Integer::compareTo) or list.stream().sorted()
	 */
}
