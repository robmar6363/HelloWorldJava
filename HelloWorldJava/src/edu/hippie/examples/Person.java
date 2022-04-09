package edu.hippie.examples;

import java.util.Date;
import java.util.Objects;

/**
 * First class and object definition for domain model: person.
 * This example illustrates using:
 * -  data (fields)
 * - constructor methods 
 * - overridden methods from Object class
 * - accessor and mutator methods (get/set)
 * 
 * A list of people is in People example.
 * @author Robert Marciniak
 *
 */
public class Person {
	
	private String firstName;
	private String lastName;
	private Date birthDate;

	public Person(String firstName, String lastName, Date birthDate) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthDate = birthDate;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public Date getBirthDate() {
		return birthDate;
	}


	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}


	public String getInitials(){
		
		return firstName.substring(0,1)+lastName.substring(0,1);
	}


	@Override
	public int hashCode() {
		return Objects.hash(birthDate, firstName, lastName);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		return Objects.equals(birthDate, other.birthDate) && Objects.equals(firstName, other.firstName)
				&& Objects.equals(lastName, other.lastName);
	}


	@Override
	public String toString() {
		return "Person [firstName=" + firstName + ", lastName=" + lastName + ", birthDate=" + birthDate + "]";
	}
	
	

}
