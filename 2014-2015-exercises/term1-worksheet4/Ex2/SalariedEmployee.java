package Ex2;

/** Worksheet 4 Exercise 2
 * 
 * This SalariedEmployee class extends Employee
 * and implements the increase salary method. 
 * 
 * @author Jirapat Treyanurak (jxt163 1214663 MSc Computer Science)
 * @version 2014-11-29
 */
public class SalariedEmployee extends Employee implements Holiday {
	
	private double salary;
	private int daysOfHolidays;
	
	/**
	 * Constructor for the SalariedEmployee class.
	 * 
	 * @param firstName Employee's first name as a String.
	 * @param lastName Employee's last name as a String.
	 * @param nI Employee's national id as a String.
	 * @param dayOfPayment Employee's date of payment as an integer.
	 * @param salary Employee's salary as a double.
	 * @param daysOfHolidays Employee's days of holidays as an integer.
	 */
	public SalariedEmployee (String firstName, String lastName, String nI, int dayOfPayment, double salary, int daysOfHolidays) {
		super(firstName, lastName, nI, dayOfPayment);
		this.salary = salary;
		this.daysOfHolidays = daysOfHolidays;
	}
	
	/**
	 * Getter for the Employee's salary.
	 * 
	 * @return Employee's salary as a double.
	 */
	public double getSalary () {
		return this.salary;
	}
	/**
	 * Getter for the Employee's days of holidays.
	 * 
	 * @return Employee's days of holidays as an integer.
	 */
	public int getDaysOfHolidays () {
		return this.daysOfHolidays;
	}
	
	/**
	 * Setter for the Employee's salary.
	 * 
	 * @param newSalary Employee's new salary as a double.
	 */
	public void setSalary (double newSalary) {
		this.salary = newSalary;
	}
	/**
	 * Setter for the Employee's days of holidays.
	 * 
	 * @param newDaysOfHolidays Employee's new days of holidays as an integer.
	 */
	public void setDaysOfHolidays (int newDaysOfHolidays) {
		this.daysOfHolidays = newDaysOfHolidays;
	}
	
	/**
	 * Equals method for the SalariedEmployee class.
	 * 
	 * @param that The employee we want to compare to.
	 * @return Boolean stating whether or not the two employees are equal.
	 */
	public boolean equals (SalariedEmployee that) {
		return super.equals(that)
			&& Math.abs(this.getSalary() - that.getSalary()) <= 0.000001
			&& this.getDaysOfHolidays() == that.getDaysOfHolidays();
	}
	/**
	 * toString method for the SalariedEmployee class.
	 * 
	 * @return String describing the employee in a readable format.
	 */
	@Override
	public String toString () {
		return super.toString()
			 + "\nSalary:\t\t" + this.getSalary()
			 + "\nHolidays:\t" + this.getDaysOfHolidays();
	}
	
	/**
	 * Methods that takes the number of holidays the employee
	 * will have left according to the number of holidays he/she
	 * will be taking.
	 * 
	 * @param days The number of holidays the employee is taking as an integer.
	 */
	public void takeHolidays (int days) {
		if (days > this.getDaysOfHolidays()) {
			throw new IllegalArgumentException("Cannot take holidays longer than daysOfHolidays.");
		}
		this.setDaysOfHolidays(this.getDaysOfHolidays() - days);
	}
	/**
	 * Computes the payment amount for the employee.
	 * 
	 * @return The employee's payment amount.
	 */
	@Override
	public double paymentAmount () {
		return this.getSalary();
	}
	/**
	 * Increase salary method that increases the salary
	 * of the employee by a certain rate.
	 * 
	 * @param rate The rate the salary is going to be increased by as a double.
	 */
	@Override
	public void increaseSalary (double rate) {
		this.setSalary(this.getSalary() * (1 + rate));
	}
	
}