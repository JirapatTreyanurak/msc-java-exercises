package Ex2;

/** Worksheet 4 Exercise 2
 * 
 * This HourlyEmployee class extends Employee
 * and implements the increase salary method. 
 * 
 * @author Jirapat Treyanurak (jxt163 1214663 MSc Computer Science)
 * @version 2014-11-29
 */
public class HourlyEmployee extends Employee {
	
	private double hourlySalary;
	private int workedHoursLastMonth;
	
	/**
	 * Constructor for the HourlyEmployee class.
	 * 
	 * @param firstName Employee's first name as a String.
	 * @param lastName Employee's last name as a String.
	 * @param nI Employee's national id as a String.
	 * @param dayOfPayment Employee's date of payment as an integer.
	 * @param hourlySalary Employee's hourly salary as a double.
	 * @param workedHoursLastMonth Employee's number of hours worked in the last month as an integer.
	 */
	public HourlyEmployee (String firstName, String lastName, String nI, int dayOfPayment, double hourlySalary, int workedHoursLastMonth) {
		super(firstName, lastName, nI, dayOfPayment);
		this.hourlySalary = hourlySalary;
		this.workedHoursLastMonth = workedHoursLastMonth;
	}
	
	/**
	 * Getter method for the Employee's hourly salary.
	 * 
	 * @return Employee's hourly salary as a double.
	 */
	public double getHourlySalary () {
		return this.hourlySalary;
	}
	/**
	 * Getter method for the Employee's number of hours worked in the last month.
	 * 
	 * @return Employee's number of hours worked in the last month as an integer.
	 */
	public int getWorkedHoursLastMonth () {
		return this.workedHoursLastMonth;
	}
	
	/**
	 * Setter method for the Employee's hourly salary.
	 * 
	 * @param newHourlySalary Employee's new hourly salary as a double.
	 */
	public void setHourlySalary (double newHourlySalary) {
		this.hourlySalary = newHourlySalary;
	}
	/**
	 * Setter method for the Employee's number of hours worked in the last month.
	 * 
	 * @param newWorkedHoursLastMonth Employee's new number of hours worked in the last month as an integer.
	 */
	public void setWorkedHoursLastMonth (int newWorkedHoursLastMonth) {
		this.workedHoursLastMonth = newWorkedHoursLastMonth;
	}
	
	/**
	 * Equals method for the HourlyEmployee class.
	 * 
	 * @param that The employee we want to compare to.
	 * @return Boolean stating whether or not the two employees are equal.
	 */
	public boolean equals (HourlyEmployee that) {
		return super.equals(that)
			&& Math.abs(this.getHourlySalary() - that.getHourlySalary()) <= 0.000001
			&& this.getWorkedHoursLastMonth() == that.getWorkedHoursLastMonth();
	}
	/**
	 * toString method for the HourlyEmployee class.
	 * 
	 * @return String describing the employee in a readable format.
	 */
	@Override
	public String toString () {
		return super.toString()
			 + "\nHourly salary:\t" + this.getHourlySalary()
			 + "\nHours worked:\t" + this.getWorkedHoursLastMonth();
	}
	
	/**
	 * Method to compute the final payment amount for the employee.
	 * This is calculated by multiplying the hourly salary with
	 * the number of hours worked in the last month.
	 * 
	 * @return The payment amount for the employee as a doubel.
	 */
	@Override
	public double paymentAmount () {
		return this.getHourlySalary() * this.getWorkedHoursLastMonth();
	}
	/**
	 * Increase salary method for the HourlyEmployee class.
	 * Increases the hourly salary by a certain rate.
	 * 
	 * @param rate The rate the salary is going to be increased by in double.
	 */
	@Override
	public void increaseSalary (double rate) {
		this.setHourlySalary(this.getHourlySalary() * (1 + rate));
	}
	
}