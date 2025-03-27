package tricky;

import java.util.HashMap;
import java.util.Map;

class Test
{
	@Override
	public int hashCode() {
		return 1;
	}
	@Override
	public boolean equals(Object test) {
		return true;
	}
}
public class Tricky2 {

	public static void main(String[] args)
	{
	Map<Test,String> map = new HashMap<>();
	 Test t1 = new Test();
	 Test t2 = new Test();
	 map.put(t1,"hi");
	 map.put(t2,"hello");
	 
	 System.out.println( map.get(t1)); 
	 System.out.println( map.get(t2));


	}

}
