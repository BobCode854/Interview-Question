package Java8;

import java.util.Date;
import java.util.function.Supplier;

public class SupplierExample {

	public static void main(String[] args) {
		 Supplier<Date> getTheCurrentDate = () -> new Date();  
		   System.out.println(getTheCurrentDate.get());

	}

}
