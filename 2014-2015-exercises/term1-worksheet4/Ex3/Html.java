package Ex3;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/** Worksheet 4 Exercise 3
 * 
 * This Html class takes care of creating Html files
 * for the Properties class.
 * 
 * It stores each direct children of the html head and body
 * inside an ArrayList and generate them on the fly when
 * getHtml mehtod is called.
 * 
 * @author Jirapat Treyanurak (jxt163 1214663 MSc Computer Science)
 * @version 2014-11-30
 */
public class Html {
	
	private String html;
	private String header;
	private ArrayList<String> headerElements;
	private String body;
	private ArrayList<String> bodyElements;
	
	/**
	 * Constructor for the Html class.
	 * We initialise everything we need here.
	 */
	public Html () {
		this.html = "<!doctype HTML>";
		this.header = "";
		this.headerElements = new ArrayList<String>();
		this.body = "";
		this.bodyElements = new ArrayList<String>();
	}
	
	/**
	 * This method returns the whole HTML page.
	 * It receives the HTML page from the generateHtml method.
	 * 
	 * @return HTML page as a String.
	 */
	public String getHtml () {
		this.generateHtml();
		return this.html;
	}
	/**
	 * This method returns the head section of the HTML page.
	 * It receives the head and its content from the generateHeader method.
	 * 
	 * @return HTML head tag for the HTML page.
	 */
	public String getHeader () {
		this.generateHeader();
		return this.header;
	}
	/**
	 * Getter for the elements inside the head tag.
	 * 
	 * @return ArrayList of Strings describing each of the elements in the head tag.
	 */
	public ArrayList<String> getHeaderElements () {
		return this.headerElements;
	}
	/**
	 * This method returns the body section of the HTML page.
	 * It receives the body and its content from the generateBody method.
	 * 
	 * @return HTML body tag for the HTML page.
	 */
	public String getBody () {
		this.generateBody();
		return this.body;
	}
	/**
	 * Getter for the elements inside the body tag.
	 * 
	 * @return ArrayList of String describing each of the elements in the body tag.
	 */
	public ArrayList<String> getBodyElements () {
		return this.bodyElements;
	}
	
	/**
	 * This method puts together the head and body tag using their getters 
	 * and surround them with the html tag.
	 */
	public void generateHtml () {
		this.html += "<html>";
			this.html += this.getHeader();
			this.html += this.getBody();
		this.html += "</html>";
	}
	/**
	 * This method puts together the elements inside the head tag from the Arraylist
	 * and surround them with the head tag.
	 */
	public void generateHeader () {
		this.header += "<head>";
		for (String element : this.getHeaderElements()) {
			this.header += element;
		}
		this.header += "</head>";
	}
	/**
	 * This method puts together the elements inside the body tag from the ArrayList
	 * and surroudn them with the body tag.
	 */
	public void generateBody () {
		this.body += "<body>";
		for (String element : this.getBodyElements()) {
			this.body += element;
		}
		this.body += "</body>";
	}
	
	/**
	 * This method adds an element to the ArrayList for the elements inside the head tag.
	 * 
	 * @param element A valid html element to go into the header.
	 */
	public void addToHeader (String element) {
		this.getHeaderElements().add(element);
	}
	/**
	 * This method adds an element to the ArrayList for the elements inside the body tag.
	 * 
	 * @param element A valid html element to go into the body.
	 */
	public void addToBody (String element) {
		this.getBodyElements().add(element);
	}
	
	/**
	 * Creates a given html tag with a given content.
	 * 
	 * @param name Tag name as a String.
	 * @param content Content as a String.
	 * @return String describing the html tag with the specified content.
	 */
	public static String generateTag (String name, String content) {
		return String.format("<%s>%s</%s>", name, content, name);
	}
	/**
	 * Creates a HTML table with the given row elements.
	 * 
	 * @param rows ArrayList of Strings containing the rows we want to put into the table.
	 * @return String describing the html table with the specified rows.
	 */
	public static String generateTable (ArrayList<String> rows) {
		String table = "<table>";
		for (String row : rows) {
			table += row;
		}
		table += "</table>";
		
		return table;
	}
	/**
	 * Creates a HTML header row with the given labels. 
	 * 
	 * @param labels Array of Strings containing the labels for each column of the table.
	 * @return String describing the html table row with the specified labels.
	 */
	public static String generateTableHeader (String[] labels) {
		String result = "<tr>";
		for (String label : labels) {
			result += Html.generateTag("th", label);
		}
		result += "</tr>";
		
		return result;
	}
	/**
	 * Creates a HTML row with the given cell elements.
	 * 
	 * @param elements Array of Strings containing the data for each cell of the row.
	 * @return String describing the html table row with the specified data.
	 */
	public static String generateTableRow (String[] elements) {
		String result = "<tr>";
		for (String cellElement : elements) {
			result += Html.generateTag("td", cellElement);
		}
		result += "</tr>";
		
		return result;
	}
	/**
	 * Creates a HTML image tag with a given source.
	 * 
	 * @param source Link to the picture to be displayed.
	 * @return String describing the html image tag with the specified image.
	 */
	public static String generateImage (String source) {
		return "<img src=\"" + source + "\" />";
	}
	/**
	 * Creates a HTML anchor tag with a given text and source.
	 * 
	 * @param label Text to go with the anchor.
	 * @param source Link to the file to go to when clicked.
	 * @return String describing the html anchor tag with the specified text and source.
	 */
	public static String generateLink (String label, String source) {
		return "<a href=\"" + source + "\">" + label + "</a>";
	}
	
	/**
	 * Creates a html file with a given name and populate the file
	 * with the object's getHtml.
	 * 
	 * @param fileName
	 */
	public void writeToFile (String fileName) {
		File file = new File(fileName + ".html");
		BufferedWriter bw = null;
		
		try {
			FileWriter f = new FileWriter(file);
			bw = new BufferedWriter(f);
			bw.write(this.getHtml());
		}
		catch (FileNotFoundException e) {
			
		}
		catch (IOException e) {
			
		}
		finally {
			try {
				bw.close();
			}
			catch (IOException e) {
				
			}
			catch (NullPointerException e) {
				
			}
		}
	}
	
	/**
	 * Run this to regenerate the 2 html pages (included in the zip file submission).
	 * 
	 * @param a Nothing to see here.
	 */
	public static void main (String[] a) {
		
		//let us give it some styling for presentation purpose.
		String style = "<style>";
		style += "table { border: 2px solid black; border-collapse: collapse; }"
			   + "th, td { border: 1px solid black; text-align: center; padding: 5px; }"
			   + "img { width: 60px; height: 60px; } "
			   + "";
		style += "</style>";
		
		
		//initialise the 2 pages.
		Html forSalePage = new Html();
		forSalePage.addToHeader(Html.generateTag("title", "List of Properties for Sale"));
		forSalePage.addToHeader(style);
		forSalePage.addToBody(Html.generateTag("h1", "Most Trustable Real Estates"));
		forSalePage.addToBody(Html.generateTag("h2", "Properties for Sale"));
				
		Html forRentPage = new Html();
		forRentPage.addToHeader(Html.generateTag("title", "List of Properties for Rent"));
		forRentPage.addToHeader(style);
		forRentPage.addToBody(Html.generateTag("h1", "Most Trustable Real Estates"));
		forRentPage.addToBody(Html.generateTag("h2", "Properties for Rent"));
		
		
		
		//create a sample list of properties.
		ArrayList<Property> allProperties = new ArrayList<Property>();
		
		House h1 = new House("Big House", "349 Big Street", 7, "h1.jpeg", "A big house for a big family.", 3, true);
		House h2 = new House("Small House", "349 Small Street", 1, "h2.jpeg", "A small house for the forever alone.", 2, true);
		House h3 = new House("House 3", "Some Street", 2, "h3.jpeg", "Some random house you can find anywhere.", 1, false);
		
		Apartment a1 = new Apartment("ApartmentA", "Nowhere", 3, "h4.jpeg", "A good apartment you wouldn't be able to find.", 4, true, 44);
		Apartment a2 = new Apartment("Flatflat", "Next to Tesco", 4, "h5.jpeg", "Apartment close to Tesco, very convenient.", 2, true, 8);
		Apartment a3 = new Apartment("Best Flat Ever", "Heaven", 27, "h6.jpeg", "A really big apartment for a really big family.", 33, false, 777);
		
		allProperties.add(h1);
		allProperties.add(h2);
		allProperties.add(h3);
		allProperties.add(a1);
		allProperties.add(a2);
		allProperties.add(a3);
		
		
		//separate them into 2 lists, one for sale, one for rent.
		ArrayList<Property> propertiesForSale = Property.extractForSale(allProperties);
		ArrayList<Property> propertiesForRent = Property.extractForRent(allProperties);
		
		//sort them and add a link on both pages to the other page.
		forSalePage.addToBody(Property.toHtmlTable(Property.sorted(propertiesForSale)));
		forSalePage.addToBody(Html.generateLink("List of properties for rent", "propertiesForRent.html"));
		
		forRentPage.addToBody(Property.toHtmlTable(Property.sorted(propertiesForRent)));
		forRentPage.addToBody(Html.generateLink("List of properties for sale", "propertiesForSale.html"));
		
		
		//create the file with the contents specified above in this main method.
		forSalePage.writeToFile("propertiesForSale");
		forRentPage.writeToFile("propertiesForRent");
		
	}
	
}