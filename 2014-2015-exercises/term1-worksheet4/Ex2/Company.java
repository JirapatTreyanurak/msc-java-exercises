package Ex2;

import java.util.ArrayList;

/** Worksheet 4 Exercise 2
 * 
 * This Company class describes a Company
 * using name, url, revenue, and the list of 
 * its employees.
 * It also contains a method that increases the
 * salary of all employees within the company
 * by a fixed rate.
 * 
 * @author Jirapat Treyanurak (jxt163 1214663 MSc Computer Science)
 * @version 2014-11-29
 */
public class Company implements Payable {
	
	private String name;
	private String url;
	private double revenue;
	private ArrayList<Employee> employees;
	
	/**
	 * Constructor for the Company class.
	 * 
	 * @param name Name of the company as a String.
	 * @param url Url link to the company as a String.
	 * @param revenue Revenue of the company as a double.
	 * @param employees List of employees working in the company as an ArrayList of Employee.
	 */
	public Company (String name, String url, double revenue, ArrayList<Employee> employees) {
		this.name = name;
		this.url = url;
		this.revenue = revenue;
		this.employees = employees;
	}
	
	/**
	 * Getter for the name of the company.
	 * 
	 * @return Company's name as a String.
	 */
	public String getName () {
		return this.name;
	}
	/**
	 * Getter for the url of the company.
	 * 
	 * @return Company's url as a String.
	 */
	public String getUrl () {
		return this.url;
	}
	/**
	 * Getter for the revenue of the company.
	 * 
	 * @return Company's revenue as a double.
	 */
	public double getRevenue () {
		return this.revenue;
	}
	/**
	 * Getter for the employees working in the company.
	 * 
	 * @return Company's employees in an ArrayList of Employee.
	 */
	public ArrayList<Employee> getEmployees () {
		return this.employees;
	}
	
	/**
	 * Setter for the name of the company.
	 * 
	 * @param newName Company's new name as a String.
	 */
	public void setName (String newName) {
		this.name = newName;
	}
	/**
	 * Setter for the url of the company.
	 * 
	 * @param newUrl Company's new url as a String.
	 */
	public void setUrl (String newUrl) {
		this.url = newUrl;
	}
	/**
	 * Setter for the revenue of the company.
	 * 
	 * @param newRevenue Company's new revenue as a double.
	 */
	public void setRevenue (double newRevenue) {
		this.revenue = newRevenue;
	}
	/**
	 * Setter for the employees in the company.
	 * 
	 * @param newEmployees Company's new employees as an ArrayList of Employee.
	 */
	public void setEmployees (ArrayList<Employee> newEmployees) {
		this.employees = newEmployees;
	}
	
	/**
	 * Helper method that checks whether two companies
	 * have the same employees in their ArrayLists.
	 * This check is order in-sensitive. I.e., if one
	 * company employs Alice and Bob, and another employes
	 * Bob and Alice, then this method will return true.
	 * 
	 * @param that The company that we want to compare with.
	 * @return Boolean stating whether the two companies have the same set of employees.
	 */
	public boolean sameEmployees (Company that) {
		int pairCount = 0;
		
		if (this.getEmployees().size() != that.getEmployees().size()) {
			return false;
		}
		//now we are dealing with companies that has the same number of employees.
		
		//for each employee in this company, we find a match in that company.
		//if a match is found, we increment the pairCount.
		for (Employee e1 : this.getEmployees()) {
			for (Employee e2 : that.getEmployees()) {
				if (e1.equals(e2)) {
					pairCount++;
				}
			}
		}

		
		//after counting all the pairs, if it is the same as the size of 
		//this or that company, then we've paired up all employees inside this 
		//company with an employee in that company, hence the two companies
		//have the same set of employees (recall that now both companies have
		//the same number of employees since we went pass the first check).
		if (pairCount == this.getEmployees().size()) {
			return true;
		}
		
		//otherwise, not all employees were paired up, i.e. we have a different set of employees.
		return false;
	}
	/**
	 * Equals method for the Company class.
	 * Uses the helper method sameEmployees to check
	 * whether the two companies have the same set
	 * of employees (order doesn't matter).
	 * 
	 * @param that The company we want to compare with.
	 * @return Boolean stating whether or not the two companies are the same.
	 */
	public boolean equals (Company that) {
		return this.getName().equals(that.getName())
			&& this.getUrl().equals(that.getUrl())
			&& Math.abs(this.getRevenue() - that.getRevenue()) <= 0.000001
			&& this.sameEmployees(that);
	}
	/**
	 * toString method for the Company class.
	 * 
	 * @return String describing the company in a readable format.
	 */
	@Override
	public String toString () {
		String s = "Name:\t\t" + this.getName()
				 + "\nUrl:\t\t" + this.getUrl()
				 + "\nRevenue:\t" + this.getRevenue()
				 + "\nEmployees:\t";
		
		for (int i = 0; i < this.getEmployees().size(); i++) {
			s += this.getEmployees().get(i).getName();
			if (i != this.getEmployees().size() - 1) {
				s += ", ";
			}
		}
		
		return s;
	}
	
	/**
	 * Determines the fee the company is subjected to.
	 * The fee depends on the company's revenue.
	 * 
	 * @return Fee as a double.
	 */
	public double fee () {
		if (this.getRevenue() <= 500000) {
			return 2000;
		}
		if (this.getRevenue() <= 1000000) {
			return 0.005 * this.getRevenue();
		}
		return 0.004 * this.getRevenue();
	}
	/**
	 * Determines the payment amount the company is subjected to.
	 * In this case, this is just the fee.
	 * 
	 * @return The payment amount in double.
	 */
	public double paymentAmount () {
		return this.fee();
	}
	/**
	 * Determines the date that the payment should be made.
	 * 
	 * @return An integer describing the day of month that the payment should be made.
	 */
	public int dueDate () {
		return 28;
	}
	/**
	 * Compute the total payment amount of all the companies inside the list.
	 * 
	 * @param companies List of companies we want to sum up the payment amount of.
	 * @return Total payment amount in double.
	 */
	public static double charges (Company[] companies) {
		double result = 0;
		for (Company company : companies) {
			result += company.paymentAmount();
		}
		return result;
	}
	/**
	 * Increases the salary of all the employees in the company by a fixed rate.
	 * 
	 * @param rate The rate the salaries should be increased by in double.
	 */
	public void increaseSalaries (double rate) {
		for (Employee e : this.getEmployees()) {
			e.increaseSalary(rate);
		}
	}
	
}