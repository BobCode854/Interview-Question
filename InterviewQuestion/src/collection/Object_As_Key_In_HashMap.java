package collection;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 *   *************************************** When Object is used as HashMap Key *****************************************
 *   
 *     **) hashCode : We override the hashCode() method using Objects.hash(name, age), 
 *                                which combines the name and age fields into a hash code. 
 *                                This ensures that Person objects with the same name and age will have the same hash code.

        **) equals      :     We override the equals() method to compare name and age fields of Person objects. 
                                      If two Person objects have the same name and age, they are considered equal.

	                Using Person as a Key in the Map:
	
	                **)   When we add person1 to the Map, 
	                        the hashCode() of person1 is computed and used to determine its position in the internal hash table.
	                        
	               **)   When we add person3 (which has the same name and age as person1), 
	                        the equals() method is used to check if person1 and person3 are equal. 
	                        Since they are equal, the existing entry for person1 is replaced with person3 in the Map.
	                        
	               **) The map contains two entries: one for Bob and one for Alice. 
	                      Even though person1 and person3 are different objects in memory, 
	                      they are considered equal because their name and age fields are the same.
	                      
	              **) When person3 is added to the map, 
	                     It replaces the previous entry for person1 because they are considered equal according to the equals() and hashCode() methods.
	                     
	             **)  If you don’t override hashCode() and equals(), 
	                    the HashMap will use the default hashCode() and equals() implementations from the Object class.
                    
             **) The hashCode() method will return a hash code based on the memory address,
                    which is likely different for different instances of the same Person even if they have the same name and age.
                    
             **) The equals() method will compare object references, not their content, 
                   which means two Person objects with the same name and age would not be considered equal.
                   
            **) When using custom objects as keys in a Map (like HashMap), 
                   you must override both the hashCode() and equals() methods to ensure correct behavior.
             
 */
class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Override hashCode and equals to ensure proper functioning in a Map
    @Override
    public int hashCode() {
        return Objects.hash(name, age);  // Generate a hash based on name and age
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true; // Check if the objects are the same
        if (obj == null || getClass() != obj.getClass()) return false;
        Person person = (Person) obj;
        return age == person.age && Objects.equals(name, person.name);  // Check equality of fields
    }

    @Override
    public String toString() {
        return "Person{name='" + name + "', age=" + age + "}";
    }
}
public class Object_As_Key_In_HashMap {
	public static void main(String[] args) {
        // Create a map to store Person objects as keys
        Map<Person, String> personMap = new HashMap<>();

        // Create Person objects as keys
        Person person1 = new Person("Alice", 30);
        Person person2 = new Person("Bob", 25);
        Person person3 = new Person("Alice", 30); // Same name and age as person1

        // Add Person objects to the map
        personMap.put(person1, "Engineer");
        personMap.put(person2, "Doctor");

        // Use the same Person object (person1 and person3 are equal)
        personMap.put(person3, "Artist"); // This should replace the entry for person1 because they are considered equal

        // Output the map
        System.out.println(personMap);

        // Check if two different references are equal (person1 and person3 should be equal)
        System.out.println("person1 equals person3: " + person1.equals(person3));
    }
}
