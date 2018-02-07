package ex1;
/** Worksheet 5 Exercise 1
 * 
 * This Person class contains the name,
 * gender (as "M" or "F"), and age.
 * It also throws an exception if the gender 
 * is invalid.
 * 
 * @author Jirapat Treyanurak (jxt163 1214663 MSc Computer Science)
 * @version 2014-12-01
 */
public class Person {
	
	private String name;
	private String gender;
	private int age;
	
	/**
	 * Constructor for the Person class.
	 * 
	 * @param name Person's name as a String.
	 * @param gender Person's gender as a String of "M" or "F".
	 * @param age Person's age as an integer.
	 */
	public Person (String name, String gender, int age) {
		Person.checkGender(gender);
		this.name = name;
		this.gender = gender;
		this.age = age;
	}
	
	/**
	 * Getter for the person's name.
	 * 
	 * @return Person's name as a String.
	 */
	public String getName () {
		return this.name;
	}
	/**
	 * Getter for the person's gender.
	 * 
	 * @return Person's gender as a String.
	 */
	public String getGender () {
		return this.gender;
	}
	/**
	 * Getter for the person's age.
	 * 
	 * @return Person's age as an integer.
	 */
	public int getAge () {
		return this.age;
	}
	
	/**
	 * Setter for the person's name.
	 * 
	 * @param newName Person's new name as a String.
	 */
	public void setName (String newName) {
		this.name = newName;
	}
	/**
	 * Setter for the person's gender.
	 * 
	 * @param newGender Person's new gender as a String of "M" or "F".
	 */
	public void setGender (String newGender) {
		Person.checkGender(newGender);
		this.gender = newGender;
	}
	/**
	 * Setter for the person's age.
	 * 
	 * @param newAge Person's new age as an integer.
	 */
	public void setAge (int newAge) {
		this.age = newAge;
	}
	
	/**
	 * Helper method to check whether the gender is "M" or "F".
	 * If the gender is invalid, an IllegalArgumentException
	 * is thrown.
	 * This method is used in the constructor and the setGender
	 * method.
	 * 
	 * @param gender Gender as a String.
	 */
	public static void checkGender (String gender) {
		if (!(gender.equals("M") || gender.equals("F"))) {
			throw new IllegalArgumentException("IllegalArgumentException: Gender can only be \"M\" or \"F\"");
		}
	}
	
	/**
	 * equals method for the Person class.
	 * 
	 * @param that The other person we want to compare to.
	 * @return Boolean stating whether or not the two persons are equal.
	 */
	public boolean equals (Person that) {
		return this.getName().equals(that.getName())
			&& this.getGender().equals(that.getGender())
			&& this.getAge() == that.getAge();
	}
	/**
	 * toString method for the Person class.
	 * 
	 * @return String describing the person in a readable format.
	 */
	public String toString () {
		return String.format("{%s, %d, %s}", this.getName(), this.getAge(), this.getGender());
	}
	
}