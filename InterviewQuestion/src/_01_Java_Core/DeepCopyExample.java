package _01_Java_Core;

class Person1 {
	private String name;
	private Address1 address;

	public Person1(String name, Address1 address) {
		super();
		this.name = name;
		this.address = address;
	}

	/**
	 * Deep Copy Constructor
	 */

	public Person1(Person1 originalPerson) {
		this.name = originalPerson.name;
		this.address = new Address1(originalPerson.address.getStreet());
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Address1 getAddress() {
		return address;
	}

	public void setAddress(Address1 address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", address=" + address + "]";
	}

}

class Address1 {
	private String street;

	public Address1(String street) {
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

public class DeepCopyExample {
	public static void main(String args[]) {
		// Original object
		Person1 originalPerson = new Person1("John", new Address1("123 Main St"));

		// Deep copy using copy constructor
		Person1 deepCopyPerson = new Person1(originalPerson);
		System.out.println("deepCopy Person : " + deepCopyPerson);
		// Modifying the shallow copy
		deepCopyPerson.setName("Jane");
		deepCopyPerson.getAddress().setStreet("456 Side St");
		System.out.println("Deep copy after modification : " + deepCopyPerson);
		// Original object remains unchanged
		System.out.println("Original Person: " + originalPerson);
		System.out.println("Deep Copy Person: " + deepCopyPerson);
	}
}
