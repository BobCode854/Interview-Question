package Java8.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 *   1.)  Response should be in two dimensional array.
 *   2.)  User will send connection count ,we will have to frame response
 *                a) First array contains number of connection less than connection 
 *                    count provided by client.
 *                b) Second array will contain exact number of connection  or more 
 *                     than the number of connection.
 */
public class Two_Dimensional_Array_Problem {

	public static void main(String[] args)
	{
	String[][] connectionArray = {
			{"Connected","Alice","Bob"},
			{"Disconnected","Bob","Alice"},
			{"Connected","Alice","Priya"},
			{"Connected","Mahi","Shivani"},
			{"Connected","Alice","Shivani"},
			{"Connected","Alexander","Bob"},
			{"Disconnected","Bob","Alexander"},
			{"Connected","Alice","Bob"},
			{"Connected","Alice","Faruk"},
			{"Connected","Mahi","Karan"},
			};

	int connectionCount = 3;
   String[][] connectionInformation =  mostFamousForConnection(connectionArray,connectionCount);
 
	}

	private static String[][] mostFamousForConnection(String[][] connectionArray, int connectionCount)
	{
		HashMap<String,Integer> connectionMap = new HashMap<>();
		for (int i = 0; i < connectionArray.length - 1; i++) {
			if (connectionArray[i][0].equals("Connected") && !connectionArray[i + 1][0].equals("Disconnected")) {
				String input1 = connectionArray[i][1];
				String input2 = connectionArray[i][2];
				int countforInput1 =   (!connectionMap.isEmpty() && connectionMap.containsKey(input1)) ? connectionMap.get(input1) : 0;
				int countForInput2 =  (!connectionMap.isEmpty() && connectionMap.containsKey(input2)) ? connectionMap.get(input2) : 0;
				connectionMap.put(input1, countforInput1 + 1);
				connectionMap.put(input2, countForInput2 + 1);
				
			} 
		}
	//	System.out.println("connectionMap : "+connectionMap);
		
		String[][] response = preparingArrayResponse(connectionMap,connectionCount);
		return response;
		
	}

	private static String[][] preparingArrayResponse(HashMap<String, Integer> connectionMap, int connectionCount) {
		String[] lessThanConnectionCount = new String[connectionMap.size()];
		String[] moreThanConnectionCount = new String[connectionMap.size()];
		
		String[][] finalResponse = {lessThanConnectionCount,moreThanConnectionCount};
		int counterForLessThan = 0;
		int counterForMoreThan = 0;
		for(Map.Entry<String,Integer> entryObject : connectionMap.entrySet()) {
			  if(entryObject.getValue() < connectionCount) {
				  lessThanConnectionCount[counterForLessThan++] = entryObject.getKey();
			  }
			  else {
				  moreThanConnectionCount[counterForMoreThan++] = entryObject.getKey();
			  }
		}
	  System.out.println("Less than array count : "+Arrays.toString(lessThanConnectionCount));
	  System.out.println("More than array count : "+Arrays.toString(moreThanConnectionCount));
		return finalResponse;
	}
	

	     
}
