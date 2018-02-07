package Ex1;

import java.util.ArrayList;
import java.util.Calendar;

/** Worksheet 4 Exercise 1 (b)
 * 
 * This PatientExtended class extends the
 * Patient class. It contains an additional 
 * date the patient was last seen, represented
 * using a Calendar object.
 * The class also contains a method that takes a 
 * list of patients and return another list
 * containing those whom the last seen date was 
 * more than a year ago.
 * 
 * @author Jirapat Treyanurak (jxt163 1214663 MSc Computer Science)
 * @version 2014-11-27
 */
public class PatientExtended extends Patient {
	
	private Calendar lastSeen;
	
	/**
	 * Constructor for the PatientExtended class.
	 * 
	 * @param name Name of the patient as a string.
	 * @param dateOfBirth Patient's date of birth as a Calendar object.
	 * @param gender Gender of the patient, a string "M" or "F".
	 * @param lastSeen Patient's last seen date as a Calendar object.
	 */
	public PatientExtended (String name, Calendar dateOfBirth, String gender, Calendar lastSeen) {
		super(name, dateOfBirth, gender);
		this.lastSeen = lastSeen;
	}
	
	/**
	 * Getter for the last seen date of the patient.
	 * 
	 * @return Patient's last seen date as a Calendar object.
	 */
	public Calendar getLastSeen () {
		return this.lastSeen;
	}
	
	/**
	 * Setter for the last seen date of the patient.
	 * 
	 * @param newLastSeen Patient's new last seen date as a Calendar object.
	 */
	public void setLastSeen (Calendar newLastSeen) {
		this.lastSeen = newLastSeen;
	}
	
	/**
	 * Method converting the PatientExtended 
	 * object to a string representing the name,
	 * date of birth, gender, and the last seen date
	 * in a readable format.
	 */
	public String toString () {
		Calendar c = this.getLastSeen();
		return super.toString()
			 + "\nLast seen:\t"
			 + c.get(Calendar.DAY_OF_MONTH) + "/" 
			 + (int)(c.get(Calendar.MONTH) + 1) + "/"
			 + c.get(Calendar.YEAR);
	}
	
	/**
	 * Method to compare whether two PatientExtended
	 * objects are the same.
	 * 
	 * @param that The other PatientExtended object that we will compare to.
	 * @return Boolean stating whether the two PatientExtended objects are the same or not.
	 */
	public boolean equals (PatientExtended that) {
		return super.equals(that) && this.getLastSeen().equals(that.getLastSeen());
	}
	
	/**
	 * Returns a list of patients that have not been
	 * seen within a year.
	 * 
	 * @param patients The list of patients as an ArrayList of PatientExtended.
	 * @return An ArrayList of PatientExtended for the patients in the input list that have not been seen within a year.
	 */
	public static ArrayList<PatientExtended> notSeenInAYear (ArrayList<PatientExtended> patients) {
		return PatientExtended.notSeenInAYearAdjustNow(patients, Calendar.getInstance());
	}
	
	/**
	 * Returns a list of patients that have not been
	 * seen within a year from an arbitrary date.
	 * This method is a helper method for the
	 * notSeenInAYear method. It will also be used 
	 * in the unit testing instead of the notSeenInAYear
	 * since the test results may change depending on the date
	 * that the test is being run.
	 * 
	 * @param patients The list of patients as an ArrayList of PatientExtended.
	 * @param now An arbitrary date as a Calendar object that we will consider as "today".
	 * @return An ArrayList of PatientExtended for the patients in the input list that have not been seen within a year from the input "today".
	 */
	public static ArrayList<PatientExtended> notSeenInAYearAdjustNow (ArrayList<PatientExtended> patients, Calendar now) {
		
		//the compareTo(..) method in the Calendar class
		//is funny, so let us use the before(..) method
		//instead (after(..) method also works).
		//but now we just need to compare the lastSeen date
		//with the date we are basing on minus 1 year.
		now.add(Calendar.YEAR, -1);
		
		//if the lastSeenDatePlusAYear is exactly today, then 
		//it's been exactly a year since the lastSeen date
		//so we'll include patients whose lastSeen is BEYOND
		//that point, hence the -1 day here.
		now.add(Calendar.DATE, -1);
		
		//ok, some times there's a difference millisecond(?)
		//when calculating (remove the following line and run
		//the test in the main method a couple of time and observe
		//that sometimes patient "Doe" is in the list, sometimes
		//not.
		now.add(Calendar.SECOND, 1);
		
		ArrayList<PatientExtended> result = new ArrayList<PatientExtended>();
		
		for (PatientExtended patient: patients) {
			if (patient.getLastSeen().before(now)) {
				result.add(patient);
			}
		}
		return result;
	}
	
	/**
	 * From a list of all patients, this method
	 * returns a string describing all the patients from
	 * the list that have not been seen within a year.
	 * 
	 * @param patients The list of patients as an ArrayList of PatientExtended.
	 * @return String describing the patients from the input list that have not been seen within a year.
	 */
	public static String notSeenInAYearToString (ArrayList<PatientExtended> patients) {
		ArrayList<PatientExtended> list = PatientExtended.notSeenInAYear(patients);
		String result = "";
		for (PatientExtended patient : list) {
			result += patient + "\n\n";
		}
		
		return result;
	}
	
	/*
	public static void main (String[] a) {
		ArrayList<PatientExtended> list = new ArrayList<PatientExtended>();
		
		// John was lastSeen exactly a year ago
		// one more day and he'll be added to the list
		Calendar c1 = Calendar.getInstance();
		c1.add(Calendar.YEAR, -1);
		list.add(new PatientExtended("John", Calendar.getInstance(), "M", c1));
		
		// Doe was lastSeen a day before John, so Doe will be added to the list
		Calendar c2 = Calendar.getInstance();
		c2.add(Calendar.YEAR, -1);
		c2.add(Calendar.DATE, -1);
		list.add(new PatientExtended("Doe", Calendar.getInstance(), "F", c2));
		
		// Foo was lastSeen a day after John, so he also won't be in the list
		Calendar c3 = Calendar.getInstance();
		c3.add(Calendar.YEAR, -1);
		c3.add(Calendar.DATE, 1);
		list.add(new PatientExtended("Foo", Calendar.getInstance(), "M", c3));
		
		System.out.println(notSeenInAYearToString(list));
	}
	*/
}