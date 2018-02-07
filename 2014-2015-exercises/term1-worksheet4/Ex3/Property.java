package Ex3;

import java.util.ArrayList;

/** Worksheet 4 Exercise 3
 * 
 * This abstract Property class describes the common
 * elements between Houses and Apartments.
 * It also contains various helper method to sort an ArrayList
 * of properties by price as well as methods for extracting 
 * the properties for rent/ sale from an ArrayList of properties.
 * 
 * @author Jirapat Treyanurak (jxt163 1214663 MSc Computer Science)
 * @version 2014-11-30
 */
public abstract class Property implements HtmlElement {
	
	private String name;
	private String address;
	private int numberOfBedrooms;
	private String pictureUrl;
	private String description;
	private int price;
	public boolean forSale;
	
	/**
	 * Constructor for the Property class.
	 * 
	 * @param name Property's name as a String.
	 * @param address Property's address as a String.
	 * @param numberOfBedrooms Property's number of bedrooms as an integer.
	 * @param pictureUrl Property's link to the picture as a String.
	 * @param description Property's description as a String.
	 * @param price Property's price as an integer.
	 * @param forSale Property's status as a boolean stating whether or not it is for sale.
	 */
	public Property (String name, String address, int numberOfBedrooms, String pictureUrl, String description, int price, boolean forSale) {
		this.name = name;
		this.address = address;
		this.numberOfBedrooms = numberOfBedrooms;
		this.pictureUrl = pictureUrl;
		this.description = description;
		this.price = price;
		this.forSale = forSale;
	}
	
	/**
	 * Getter for the Property's name.
	 * 
	 * @return Property's name as a String.
	 */
	public String getName () {
		return this.name;
	}
	/**
	 * Getter for the Property's address.
	 * 
	 * @return Property's address as a String.
	 */
	public String getAddress () {
		return this.address;
	}
	/**
	 * Getter for the Property's number of bedrooms.
	 * 
	 * @return Property's number of bedrooms as an integer.
	 */
	public int getNumberOfBedrooms () {
		return this.numberOfBedrooms;
	}
	/**
	 * Getter for the Property's link to the picture.
	 * 
	 * @return Property's link to the picture as a String.
	 */
	public String getPictureUrl () {
		return this.pictureUrl;
	}
	/**
	 * Getter for the Property's description.
	 * 
	 * @return Property's description as a String.
	 */
	public String getDescription () {
		return this.description;
	}
	/**
	 * Getter for the Property's price.
	 * 
	 * @return Property's price as an integer.
	 */
	public int getPrice () {
		return this.price;
	}
	/**
	 * Getter for the Property's for-sale status.
	 * 
	 * @return Boolean stating whether or not the Property is for sale.
	 */
	public boolean getForSale () {
		return this.forSale;
	}
	/**
	 * Getter for the Property's for-rent status.
	 * 
	 * @return Boolean stating whether or not the Property is for rent.
	 */
	public boolean getForRent () {
		return !this.getForSale();
	}
	
	/**
	 * Setter for the Property's name.
	 * 
	 * @param newName Property's new name as a String.
	 */
	public void setName (String newName) {
		this.name = newName;
	}
	/**
	 * Setter for the Property's address.
	 * 
	 * @param newAddress Property's new address as a String.
	 */
	public void setAddress (String newAddress) {
		this.address = newAddress;
	}
	/**
	 * Setter for the Property's number of bedrooms.
	 * 
	 * @param newNumberOfBedrooms Property's new number of bedrooms as an integer.
	 */
	public void setNumberOfBedrooms (int newNumberOfBedrooms) {
		this.numberOfBedrooms = newNumberOfBedrooms;
	}
	/**
	 * Setter for the Property's link to the picture.
	 * 
	 * @param newPictureUrl Property's new link to the picture as a String.
	 */
	public void setPictureUrl (String newPictureUrl) {
		this.pictureUrl = newPictureUrl;
	}
	/**
	 * Setter for the Property's description.
	 * 
	 * @param newDescription Property's new description as a String.
	 */
	public void setDescription (String newDescription) {
		this.description = newDescription;
	}
	/**
	 * Setter for the Property's price.
	 * 
	 * @param newPrice Property's new price as an integer.
	 */
	public void setPrice (int newPrice) {
		this.price = newPrice;
	}
	/**
	 * Setter for the Property's for-sale status.
	 * 
	 * @param newForSale Property's new for-sale status as a boolean.
	 */
	public void setForSale (boolean newForSale) {
		this.forSale = newForSale;
	}
	/**
	 * Setter for the Property's for-rent status.
	 * 
	 * @param newForRent Property's new for-rent status as a boolean.
	 */
	public void setForRent (boolean newForRent) {
		this.setForSale(!newForRent);
	}
	
	/**
	 * Equals method for the Property class.
	 * 
	 * @param that The property that we want to compare to.
	 * @return Boolean stating whether or not the two properties are equal.
	 */
	public boolean equals (Property that) {
		return this.getName().equals(that.getName())
			&& this.getAddress().equals(that.getAddress())
			&& this.getNumberOfBedrooms() == that.getNumberOfBedrooms()
			&& this.getPictureUrl().equals(that.getPictureUrl())
			&& this.getDescription().equals(that.getDescription())
			&& this.getPrice() == that.getPrice();
	}
	/**
	 * toString method for the Property class.
	 * 
	 * @return String describing the property in a readable format.
	 */
	@Override
	public String toString () {
		return (this.getForSale() ? "For Sale:" : "For Rent:")
			 +	"Name:\t\t" + this.getName()
			 + "\nAddress:\t" + this.getAddress()
			 + "\nBedrooms:\t" + this.getNumberOfBedrooms()
			 + "\nPicture:\t" + this.getPictureUrl()
			 + "\nDescription:\t" + this.getDescription()
			 + "\nPrice:\t\t" + this.getPrice();
	}
	
	/**
	 * Method to return a String that will describe the Property
	 * as an HTML element.
	 * We push the implementation of this method to individual subclasses
	 * of the Property.
	 * 
	 * @return String describing the property as an HTML element.
	 */
	public abstract String toHtml ();
	
	/**
	 * Method that returns a new list consisting only of the properties
	 * that are for sale inside a given list of properties.
	 * 
	 * @param list ArrayList of all properties we are considering.
	 * @return ArrayList of properties containing only those for sale from the input ArrayList.
	 */
	public static ArrayList<Property> extractForSale (ArrayList<Property> list) {
		ArrayList<Property> propertiesForSale = new ArrayList<Property>();
		
		for (Property p : list) {
			if (p.getForSale()) {
				propertiesForSale.add(p);
			}
		}
		
		return propertiesForSale;
	}
	/**
	 * Method that returns a new lsit consisting only of the properties
	 * that are for rent inside a given list of properties.
	 * 
	 * @param list ArrayList of all properties we are considering.
	 * @return ArrayList of properties containing only those for rent from the input ArrayList.
	 */
	public static ArrayList<Property> extractForRent (ArrayList<Property> list) {
		ArrayList<Property> propertiesForRent = new ArrayList<Property>();
		
		for (Property p : list) {
			if (p.getForRent()) {
				propertiesForRent.add(p);
			}
		}
		
		return propertiesForRent;
	}
	/**
	 * Method that returns a list of properties sorted by their price
	 * starting from the cheapest from a given list of properties.
	 * This method uses bubblesort.
	 * 
	 * @param list The list of properties we want to sort.
	 * @return The input list of properties sorted in increasing order of price.
	 */
	public static ArrayList<Property> bubbleSort (ArrayList<Property> list) {
		
		Property tmp;
		
		for (boolean swap = true; swap; ) {
			swap = false;
			for (int j = 0; j < list.size()-1; j++) {
				if (list.get(j).getPrice() > list.get(j+1).getPrice()) {
					swap = true;
					
					tmp = list.get(j);
					list.set(j, list.get(j+1));
					list.set(j+1, tmp);
				}
			}
		}
		
		return list;
	}
	/**
	 * Method that returns a NEW list of properties sorted by price.
	 * This method simply clones the input list and use the bubblesort
	 * method above. 
	 * We are simply eliminating the need to manually input the lower
	 * and upper bounds here.
	 * 
	 * @param list ArrayList of properties we want to sort.
	 * @return Input ArrayList of properties sorted by increasing order of price.
	 */
	public static ArrayList<Property> sorted (ArrayList<Property> list) {
		ArrayList<Property> listClone = new ArrayList<Property>();
		for (Property p : list) {
			listClone.add(p);
		}
		return Property.bubbleSort(listClone);
	}
	/**
	 * Takes an ArrayList of properties and returns a HTML
	 * table containing all of the properties.
	 * This method utilises the toHtml method of each of the 
	 * individual properties.
	 * 
	 * @param list ArrayList of properties we want to put into a HTML table.
	 * @return String representing a HTML table containing all of the properties in the input list.
	 */
	public static String toHtmlTable (ArrayList<Property> list) {
		ArrayList<String> rows = new ArrayList<String>();
		String[] labels = {"Name", "Address", "Bedrooms", "Image", "Description", "Price"};
		
		rows.add(Html.generateTableHeader(labels));
		for (Property p : list) {
			rows.add(p.toHtml());
		}
		
		return Html.generateTable(rows);
	}
	
}