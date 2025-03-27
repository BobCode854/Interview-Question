package Java8.array;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Sort_Using_Ascending_Order {

	public static void sortingAscendingWay1(int[] arr) {
		Object[] sortedArray = Arrays.stream(arr).boxed().sorted(Integer::compare).toArray();
		System.out.println(Arrays.toString(sortedArray));
	}

	public static void sortingAscendingWay2(int[] arr) {
		int[] sortedArray = Arrays.stream(arr).sorted().toArray();
		System.out.println(Arrays.toString(sortedArray));
	}

	public static void sortingAscendingWay3(int[] arr) {
		Arrays.sort(arr);
		System.out.println(Arrays.toString(arr));
	}

	public static void sortingAscendingWay4(int[] arr) {
		
		Arrays.stream(arr).boxed().sorted() // Sorts in ascending order
				.collect(Collectors.toList());
		System.out.println(Arrays.toString(arr));
	}
	public static void main(String[] args) {
		int[] arr = {23,54,12,87,33};
		sortingAscendingWay1(arr);
		sortingAscendingWay2(arr);
		sortingAscendingWay3(arr);
		sortingAscendingWay4(arr);
	}
/**
	 * Which One to Use?
✅ For arrays → Arrays.sort(arr) (Most efficient)
✅ For lists → list.sort(Integer::compareTo) or list.stream().sorted()
	 */
}
