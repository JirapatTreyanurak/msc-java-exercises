package Ex3;

/** Worksheet 4 Exercise 3
 * 
 * This interface asks for the class to implement
 * a toHtml method that is similar to its toString 
 * method but instead of returning a String in a 
 * human-readable format, the toHtml method should return
 * a String that is a valid HTML element.
 * 
 * @author Jirapat Treyanurak (jxt163 1214663 MSc Computer Science)
 * @version 2014-11-30
 */
public interface HtmlElement {
	
	public String toHtml ();
	
}