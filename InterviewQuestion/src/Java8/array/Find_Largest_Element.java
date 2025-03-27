package Java8.array;

import java.util.Arrays;

public class Find_Largest_Element {
	public static Integer way1(int[] arr) {
		 Integer max =  Arrays.stream(arr).boxed().max(Integer::compare).orElseGet(null);
		
		 return max;
	}
	public static Integer way2(int[] arr) {
		 Integer max =  Arrays.stream(arr).boxed().sorted((I1, I2)->Integer.compare(I2, I1)).findFirst().orElseGet(null);
		 return max;
	}
	public static int way3(int[] arr) {
		 int max =  Arrays.stream(arr).max().getAsInt();
		 return max;
	}
	public static void main(String[] args) 
	{
		int arr[] = { 1, 2, 3, 4, 53, 2, 25,27,51};
      Integer maxFromArrayWay1 =  way1(arr);
      System.out.println(maxFromArrayWay1);
      
      Integer maxFromArrayWay2 = way2(arr);
      System.out.println(maxFromArrayWay2);
      
      int maxFromArrayWay3 = way3(arr);
      System.out.println(maxFromArrayWay3);
	}
	

}
