package Ex3;

/** Worksheet 4 Exercise 3
 * 
 * This House class extends Property and
 * implements its own toHtml method that 
 * converts a House object into a valid 
 * HTML table row element.
 * 
 * @author Jirapat Treyanurak (jxt163 1214663 MSc Computer Science)
 * @version 2014-11-30
 */
public class House extends Property {
	
	/**
	 * Constructor for the House class.
	 * 
	 * @param name House's name as a String.
	 * @param address House's address as a String.
	 * @param numberOfBedrooms House's number of bedrooms as an integer.
	 * @param pictureUrl House's link to the picture as a String.
	 * @param description House's description as a String.
	 * @param price House's price as an integer.
	 * @param forSale House's for-sale status as a boolean.
	 */
	public House (String name, String address, int numberOfBedrooms, String pictureUrl, String description, int price, boolean forSale) {
		super(name, address, numberOfBedrooms, pictureUrl, description, price, forSale);
	}
	
	/**
	 * toHtml method for the House class.
	 * This method converts the House object 
	 * into a valid HTML table row for presentation purpose.
	 * 
	 * @return String representing a HTML table row describing the House.
	 */
	public String toHtml () {
		String[] details = {
			this.getName(),
			this.getAddress(),
			(this.getNumberOfBedrooms() + ""),
			Html.generateImage(this.getPictureUrl()),
			this.getDescription(),
			(this.getPrice() + "")
		};
		
		return Html.generateTableRow(details);
	}
	
}