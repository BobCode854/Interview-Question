package _01_Java_Core;

class Person
{
	private String name;
	private Address address;
	
	public Person(String name, Address address) {
		super();
		this.name = name;
		this.address = address;
	}
	
	/**
	 *  Shallow copy constructor
	 */
	public Person(Person originalPerson) {
		this.name  = originalPerson.name;
		this.address=originalPerson.address;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", address=" + address + "]";
	}
	
	
	
	
}
class Address
{
	private String street;
	public Address(String street) {
		super();
		this.street = street;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	@Override
	public String toString() {
		return "Address [street=" + street + "]";
	}
	
	
}

public class ShallowCopyExample {
    public static void main(String[] args) {
        // Original object
        Person originalPerson = new Person("John", new Address("123 Main St"));

        // Shallow copy using copy constructor
        Person shallowCopyPerson = new Person(originalPerson);
        System.out.println("shallowCopy Person : "+shallowCopyPerson);
        // Modifying the shallow copy
        shallowCopyPerson.setName("Jane");
        shallowCopyPerson.getAddress().setStreet("456 Side St");
        System.out.println("Shallow copy after modification : "+shallowCopyPerson);
        // Original object remains unchanged
        System.out.println("Original Person: " + originalPerson);
        System.out.println("Shallow Copy Person: " + shallowCopyPerson);
    }
}
