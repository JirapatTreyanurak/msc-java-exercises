package Ex1;

import java.util.Calendar;

/** Worksheet 4 Exercise 1 (a)
 * 
 * This Patient class contains the name,
 * date of birth, and gender field variables.
 * It has the usual getters and setters, 
 * toString, equals, as well as a check whether
 * the gender is "M" or "F".
 * The date of birth is represented as a 
 * Calendar object.
 * 
 * For details about the Calendar class, see
 * https://docs.oracle.com/javase/7/docs/api/java/util/Calendar.html
 * 
 * @author Jirapat Treyanurak (jxt163 1214663 MSc Computer Science)
 * @version 2014-11-27
 */
public class Patient {
	
	private String name;
	private Calendar dateOfBirth;
	private String gender;
	
	/**
	 * Constructor for the Patient class.
	 * It first checks if the gender is valid 
	 * ("M" or "F") before initialising the
	 * field variables.
	 * If the gender is invalid, an
	 * IllegalArgumentException is thrown.
	 * 
	 * @param name Name of the patient as a string.
	 * @param dateOfBirth Patient's date of birth as a Calendar object.
	 * @param gender Gender of the patient, a string "M" or "F".
	 */
	public Patient (String name, Calendar dateOfBirth, String gender) {
		checkGender(gender);
		this.name = name;
		this.dateOfBirth = dateOfBirth;
		this.gender = gender;
	}
	
	/**
	 * Getter for the name of the patient.
	 * 
	 * @return Patient's name as a string.
	 */
	public String getName () {
		return this.name;
	}
	/**
	 * Getter for the date of birth of the patient.
	 * 
	 * @return Patient's date of birth as a Calendar object.
	 */
	public Calendar getDateOfBirth () {
		return this.dateOfBirth;
	}
	/**
	 * Getter for the gender of the patient.
	 * 
	 * @return Patient's gender, a string "M" or "F".
	 */
	public String getGender () {
		return this.gender;
	}
	
	/**
	 * Setter for the name of the patient.
	 * 
	 * @param newName Patient's new name as a string.
	 */
	public void setName (String newName) {
		this.name = newName;
	}
	/**
	 * Setter for the date of birth of the patient.
	 * 
	 * @param newDateOfBirth Patient's new date of birth as a Calendar object.
	 */
	public void setDateOfBirth (Calendar newDateOfBirth) {
		this.dateOfBirth = newDateOfBirth;
	}
	/**
	 * Setter for the gender of the patient.
	 * This methods also checks whether the new
	 * gender is a string "M" or "F".
	 * If the input is invalid, an 
	 * IllegalArgumentException will be thrown.
	 * 
	 * @param newGender Patient's new gender as a string.
	 */
	public void setGender (String newGender) {
		checkGender(newGender);
		this.gender = newGender;
	}
	
	/**
	 * Helper method to check whether a string
	 * representing a gender is "M" or "F".
	 * If the string is not "M" or "F", this method
	 * will throw an IllegalArgumentException.
	 * This method will be used in the constructor and
	 * the getter (for the gender).
	 * 
	 * @param gender String representing a gender.
	 */
	public static void checkGender (String gender) {
		if (!(gender.equals("M") || gender.equals("F"))) {
			throw new IllegalArgumentException();
		}
	}
	
	/**
	 * Method converting the Patient
	 * object to a string presenting the name,
	 * date of birth, and gender in a readable
	 * format.
	 */
	@Override
	public String toString () {
		Calendar c = this.getDateOfBirth();
		return "Name:\t\t" + this.getName()
			 + "\nDate of birth:\t"
			 + c.get(Calendar.DAY_OF_MONTH) + "/" 
			 + (int)(c.get(Calendar.MONTH) + 1) + "/"
			 + c.get(Calendar.YEAR)
			 + "\nGender:\t\t" + this.getGender();
	}
	
	/**
	 * Method to compare whether two
	 * patients are the same.
	 * 
	 * @param that The other patient that we will compare to.
	 * @return Boolean stating whether the two patients are the same or not.
	 */
	public boolean equals (Patient that) {
		return this.getName().equals(that.getName())
			&& this.getDateOfBirth().equals(that.getDateOfBirth())
			&& this.getGender().equals(that.getGender());
	}
	
}