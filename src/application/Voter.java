package application;

public class Voter {
	private String CNIC, Name, Contact, Address;
	private int Age;
	
	public Voter(String cnic, String name, String contact, String add, int age) {
		CNIC = cnic;
		Name = name;
		Contact = contact;
		Address = add;
		Age = age;
	}

	public String getCNIC() {
		return CNIC;
	}

	public void setCNIC(String cNIC) {
		CNIC = cNIC;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getContact() {
		return Contact;
	}

	public void setContact(String contact) {
		Contact = contact;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public int getAge() {
		return Age;
	}

	public void setAge(int age) {
		Age = age;
	}
}
