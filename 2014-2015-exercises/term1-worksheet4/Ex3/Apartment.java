package Ex3;

/** Worksheet 4 Exercise 3
 * 
 * This Apartment class extends Property and
 * implements its own toHtml method that 
 * converts an Apartment object into a valid 
 * HTML table row element.
 * To distinguish houses from apartments, apartments
 * also have a flat number.
 * 
 * @author Jirapat Treyanurak (jxt163 1214663 MSc Computer Science)
 * @version 2014-11-30
 */
public class Apartment extends Property {
	
	private int flatNumber;
	
	/**
	 * Constructor for the Apartment class.
	 * 
	 * @param name Apartment's name as a String.
	 * @param address Apartment's address as a String.
	 * @param numberOfBedrooms Apartment's number of bedrooms as an integer.
	 * @param pictureUrl Apartment's link to the picture as a String.
	 * @param description Apartment's descrition as a String.
	 * @param price Apartment's price as an integer.
	 * @param forSale Apartment's for-sale status as a boolean.
	 * @param flatNumber Apartment's flat number as an integer.
	 */
	public Apartment (String name, String address, int numberOfBedrooms, String pictureUrl, String description, int price, boolean forSale, int flatNumber) {
		super(name, address, numberOfBedrooms, pictureUrl, description, price, forSale);
		this.flatNumber = flatNumber;
	}
	
	/**
	 * Getter for the Apartment's flat number.
	 * 
	 * @return Apartment's flat number as an integer.
	 */
	public int getFlatNumber () {
		return this.flatNumber;
	}
	
	/**
	 * Setter for the Apartment's flat number.
	 * 
	 * @param newFlatNumber Apartment's new flat number as an integer.
	 */
	public void setFlatNumber (int newFlatNumber) {
		this.flatNumber = newFlatNumber;
	}
	
	/**
	 * Equals method for the Apartment class.
	 * 
	 * @param that The apartment that we want to compare to.
	 * @return Boolean stating whether or not the two apartments are equal.
	 */
	public boolean equals (Apartment that) {
		return super.equals(that)
			&& this.getFlatNumber() == that.getFlatNumber();
	}
	/**
	 * toString method for the Apartment class.
	 * 
	 * @return String describing the apartment in a readable format.
	 */
	@Override
	public String toString () {
		return super.toString()
			 + "\nFlat No.:\t" + this.getFlatNumber();
	}
	
	/**
	 * toHtml method for the Apartment class.
	 * This method converts the Apartment object 
	 * into a valid HTML table row for presentation purpose.
	 * 
	 * Here the flat number is displayed in the same table cell
	 * as the apartment's name so as to keep the formatting
	 * consistent across houses and apartments.
	 * 
	 * @return String representing a HTML table row describing the Apartment.
	 */
	public String toHtml () {
		String[] details = {
				"#" + this.getFlatNumber() + " " + this.getName(),
				this.getAddress(),
				(this.getNumberOfBedrooms() + ""),
				Html.generateImage(this.getPictureUrl()),
				this.getDescription(),
				(this.getPrice() + "")
			};
			
			return Html.generateTableRow(details);
	}
	
}