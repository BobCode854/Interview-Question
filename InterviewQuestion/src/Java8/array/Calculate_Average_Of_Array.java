package Java8.array;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Calculate_Average_Of_Array {

	public static void getAverage(int[] arr) {
		double d1 = Arrays.stream(arr).average().orElse(0);
		System.out.println("Average from way1 : "+d1);
	}
	public static void getAverageWay2(int[] arr) {
		double d2= Arrays.stream(arr).boxed().mapToInt(a->a).average().orElse(0);
		System.out.println("Double from way2  : "+d2);
	}
	public static void getAverageWay3(int[] arr) {
		double d3= Arrays.stream(arr).boxed()
	            .collect(Collectors.averagingDouble(Integer::doubleValue));
		System.out.println("Double from way2  : "+d3);
	}
	public static void main(String[] args)
	{
		int arr1[] = { 1, 2, 3, 4, 3, 2, 25 };
		
		/**
		 *  Average of array
		 */
		 getAverage(arr1);
	     getAverageWay2(arr1);
	     getAverageWay3(arr1);

	}

}
