package Java8.array;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class Swap_The_Array {

	public static void main(String[] args) {
	
		int arr[] = {1,2,3,4,5};
         int max = arr.length;       
         IntStream.range(0, arr.length/2).forEach(index->{
        	 int temp = arr[index];
        	 arr[index]=arr[max-1-index];
        	 arr[max-1-index] = temp;
         });
         
         System.out.println(Arrays.toString(arr));
	}

}
