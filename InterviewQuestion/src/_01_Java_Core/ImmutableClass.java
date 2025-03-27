package _01_Java_Core;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 *  ********** Steps to Create an Immutable Class **************************  
				
				1.	Declare the class as final.
				2.	Make all fields private and final.
				3.	Initialize all fields in the constructor.
				4.	Do not provide setter methods.
				5.	Perform defensive copying of mutable fields in the constructor and getter methods.

 */

final class Student
{
	private final String name;
    private final int regNo;
    private final Map<String, String> metadata;
    private final Date birthDate;
    
	public Student(String name, int regNo, Map<String, String> metadata, Date birthDate) {
		super();
		this.name = name;
		this.regNo = regNo;
		/**
		 *  For Map Object 
		 */
		Map<String, String> tempMap = new HashMap<>();
		metadata.entrySet().stream().forEach(entry->tempMap.put(entry.getKey(), entry.getValue()));
         this.metadata = tempMap;
       
       /**
        *  For Date Object
        */
		this.birthDate = new Date(birthDate.getTime());
	}

	public String getName() {
		return name;
	}

	public int getRegNo() {
		return regNo;
	}

	public Map<String, String> getMetadata() {
		Map<String, String> tempMap = new HashMap<>();
		metadata.entrySet().stream().forEach(entry->tempMap.put(entry.getKey(), entry.getValue()));
		return tempMap;
	}

	public Date getBirthDate() {
		  return new Date(birthDate.getTime());
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", regNo=" + regNo + ", metadata=" + metadata + ", birthDate=" + birthDate
				+ "]";
	}
   
}
public class ImmutableClass {

	public static void main(String[] args) 
	{
		Map<String, String> map = new HashMap<>();
        map.put("1", "first");
        map.put("2", "second");
        
        Student s = new Student("ABC", 101, map,new Date());
        
        System.out.println(s.getName());
        System.out.println(s.getRegNo());
        System.out.println(s.getMetadata());
       
        map.put("3", "third");
        System.out.println(s.getMetadata());
	}

}
