package Ex2;

/** Worksheet 4 Exercise 2
 * 
 * This Employee class implements Payable and
 * contains an abstract method to increase the salary
 * of the employee.
 * 
 * @author Jirapat Treyanurak (jxt163 1214663 MSc Computer Science)
 * @version 2014-11-29
 */
public abstract class Employee implements Payable {
	
	private String firstName;
	private String lastName;
	private String nI;
	private int dayOfPayment;
	
	/**
	 * Constructor for the Employee class.
	 * 
	 * @param firstName First name of the Employee as a String.
	 * @param lastName Last name of the Employee as a String.
	 * @param nI National ID of the Employee as a String.
	 * @param dayOfPayment Date of payment for the Employee as an integer.
	 */
	public Employee (String firstName, String lastName, String nI, int dayOfPayment) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.nI = nI;
		this.dayOfPayment = dayOfPayment;
	}
	
	/**
	 * Getter for the Employee's first name.
	 * 
	 * @return Employee's first name as a String.
	 */
	public String getFirstName () {
		return this.firstName;
	}
	/**
	 * Getter for the Employee's last name.
	 * 
	 * @return Employee's last name as a String.
	 */
	public String getLastName () {
		return this.lastName;
	}
	/**
	 * Getter for the Employee's national ID.
	 * 
	 * @return Employee's NI as a String.
	 */
	public String getNI () {
		return this.nI;
	}
	/**
	 * Getter for the Employee's date of payment.
	 * 
	 * @return Employee's date of payment as an integer.
	 */
	public int getDayOfPayment () {
		return this.dayOfPayment;
	}
	/**
	 * Getter for Employee's name (includes first name and last name separated by a space).
	 * 
	 * @return Employee's name as a String.
	 */
	public String getName () {
		return this.getFirstName() + " " + this.getLastName();
	}
	
	/**
	 * Setter for the Employee's first name.
	 * 
	 * @param newFirstName Employee's new first name as a String.
	 */
	public void setFirstName (String newFirstName) {
		this.firstName = newFirstName;
	}
	/**
	 * Setter for the Employee's last name.
	 * 
	 * @param newLastName Employee's new last name as a String.
	 */
	public void setLastName (String newLastName) {
		this.lastName = newLastName;
	}
	/**
	 * Setter for the Employee's national ID.
	 * 
	 * @param newNI Employee's new national ID as a String.
	 */
	public void setNI (String newNI) {
		this.nI = newNI;
	}
	/**
	 * Setter for the Employee's date of payment.
	 * 
	 * @param newDayOfPayment Employee's new date of payment as an integer.
	 */
	public void setDayOfPayment (int newDayOfPayment) {
		this.dayOfPayment = newDayOfPayment;
	}
	
	/**
	 * Equals method for the Employee class.
	 * 
	 * @param that The employee that we want to compare to.
	 * @return Boolean stating whether or not the two employees are equal.
	 */
	public boolean equals (Employee that) {
		return this.getFirstName().equals(that.getFirstName())
			&& this.getLastName().equals(that.getLastName())
			&& this.getNI().equals(that.getNI())
			&& this.getDayOfPayment() == that.getDayOfPayment();
	}
	/**
	 * toString method for the Employee class.
	 * 
	 * @return String describing the Employee in a readable format.
	 */
	@Override
	public String toString () {
		return "Name:\t\t" + this.getName()
			 + "\nnI:\t\t" + this.getNI()
			 + "\nDay of payment:\t" + this.getDayOfPayment();
	}
	
	/**
	 * Abstract payment amount method. The implementation 
	 * depends on the type of the employees (hourly or salaried).
	 * 
	 * @return Payment amount of the Employee as a double.
	 */
	public abstract double paymentAmount ();
	/**
	 * This method obtains the date that the payment
	 * for the Employee is due.
	 * 
	 * @return Date the payment is due as an integer.
	 */
	public int dueDate () {
		return this.getDayOfPayment();
	}
	/**
	 * Abstract increase salary method. The implementation
	 * depends on the type of the employees (hourly or salaried).
	 * 
	 * @param rate The rate the salary should be increased by as a double.
	 */
	public abstract void increaseSalary (double rate);
	
}