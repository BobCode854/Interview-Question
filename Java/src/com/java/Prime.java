package practice1;

import java.util.Scanner;
import java.util.stream.IntStream;

public class Prime
{
      public static boolean isPrime_Java7(int number) {
    	  int checksum=2;
    	  for(int i=2;i<number;i++) {
    		  if(number==2) {
    			  return true;
    		  }
    		  else if(number%i==0) {
    			 return false;
    		  }
    		  else {
    		  checksum++;
    		  }
    	  }
    	  
    	if(checksum == number) {
    		return true;
    	}
    	return false;
      }
      public static boolean isPrime_Java8(int number) {
    	  return IntStream.range(2, number).noneMatch(i->number%i==0);
      }
	public static void main(String[] args) {
	
	   System.out.println("Enter the number");
	   Scanner sc = new Scanner(System.in);
             int number =  sc.nextInt();
             System.out.println("************* From Java 7 **************");
             System.out.println(isPrime_Java7(number));
             System.out.println("************* From Java 8 **************");
             System.out.println(isPrime_Java8(number));
	}

}
