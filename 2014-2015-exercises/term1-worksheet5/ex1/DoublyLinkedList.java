package ex1;

/** Worksheet 5 Exercise 1
 * 
 * This DoublyLinkedList class describes a
 * doubly-linked list of persons.
 * It contains a method to determine whether 
 * or not the person is next to person(s) of different gender(s).
 * 
 * @author Jirapat Treyanurak (jxt163 1214663 MSc Computer Science)
 * @version 2014-12-09
 */
public class DoublyLinkedList {
	
	private Person value;
	private DoublyLinkedList left;
	private DoublyLinkedList right;
	private boolean empty;
	
	/**
	 * Constructor for the DoublyLinkedList class.
	 * 
	 * @param value List's value as a person.
	 * @param left List's left list as a list.
	 * @param right List's right list as a list.
	 */
	public DoublyLinkedList (Person value, DoublyLinkedList left, DoublyLinkedList right) {
		this.value = value;
		this.setLeft(left.getRightMost());
		left.getRightMost().setRight(this);
		this.setRight(right.getLeftMost());
		right.getLeftMost().setLeft(this);
		this.empty = false;
	}
	/**
	 * Constructor for the DoublyLinkedList class where the left is initially empty.
	 * 
	 * @param value List's value as a person.
	 * @param right List's right list as a list.
	 */
	public DoublyLinkedList (Person value, DoublyLinkedList right) {
		this.value = value;
		DoublyLinkedList empty = new DoublyLinkedList();
		this.setLeft(empty);
		empty.setRight(this);
		this.setRight(right.getLeftMost());
		right.getLeftMost().setLeft(this);
		this.empty = false;
	}
	/**
	 * Constructor for an empty list.
	 */
	public DoublyLinkedList () {
		this.empty = true;
	}
	
	/**
	 * Short constructor taking in the value and the right list.
	 * 
	 * @param value List's value as a person.
	 * @param right List's right list as a list.
	 * @return New list with the given value and right list where the left list is set to empty.
	 */
	public static DoublyLinkedList cons (Person value, DoublyLinkedList right) {
		return new DoublyLinkedList(value, right);
	}
	/**
	 * Short constructor for the empty list.
	 * 
	 * @return New empty list.
	 */
	public static DoublyLinkedList empty () {
		return new DoublyLinkedList();
	}
	/**
	 * Short constructor taking in multiple values.
	 * 
	 * @param values Values to be put inside the lists.
	 * @return New list where the values are listed from left to right.
	 */
	public static DoublyLinkedList cons (Person... values) {
		DoublyLinkedList result = empty();
		for (int i = values.length - 1; i >= 0; i--) {
			result = cons(values[i], result);
		}
		return result;
	}
	
	/**
	 * Getter for the list's value.
	 * 
	 * @return List's value as a person.
	 */
	public Person getValue () {
		return this.value;
	}
	/**
	 * Getter for the list's left list.
	 * 
	 * @return List's left list as a list.
	 */
	public DoublyLinkedList getLeft () {
		return this.left;
	}
	/**
	 * Alternative getter for the list's left list.
	 * 
	 * @return List's left list as a list.
	 */
	public DoublyLinkedList left () {
		return this.getLeft();
	}
	/**
	 * Getter for the list's right list.
	 * 
	 * @return List's right list as a list.
	 */
	public DoublyLinkedList getRight () {
		return this.right;
	}
	/**
	 * Alternative getter for the list's right list.
	 * 
	 * @return List's right list as a list.
	 */
	public DoublyLinkedList right () {
		return this.getRight();
	}
	/**
	 * Getter for the list's emptiness status.
	 * 
	 * @return List's emptiness status as a boolean.
	 */
	public boolean getEmpty () {
		return this.empty;
	}
	/**
	 * Alternative getter for the list's emptiness status.
	 * 
	 * @return List's emptiness status as a boolean.
	 */
	public boolean isEmpty () {
		return this.getEmpty();
	}
	
	/**
	 * Getter for the list's left-most (non-empty) node.
	 * Note this method returns the list itself if the list
	 * is empty.
	 * 
	 * @return List's left-most list.
	 */
	public DoublyLinkedList getLeftMost () {
		if (this.isEmpty() || this.getLeft().isEmpty()) {
			return this;
		}
		return this.getLeft().getLeftMost();
	}
	/**
	 * Getter for the list's right-most (non-empty) node.
	 * Note this method returns the list itself if the list
	 * is empty.
	 * 
	 * @return List's right-most list.
	 */
	public DoublyLinkedList getRightMost () {
		if (this.isEmpty() || this.getRight().isEmpty()) {
			return this;
		}
		return this.getRight().getRightMost();
	}
	
	/**
	 * Setter for the list's value.
	 * 
	 * @param newValue List's new value as a person.
	 */
	public void setValue (Person newValue) {
		this.value = newValue;
		this.empty = false;
	}
	/**
	 * Setter for the list's left list.
	 * This method is set to private because
	 * it should be used in a specific way internally
	 * in order to ensure that the lists are
	 * doubly-linked.
	 * 
	 * @param newLeft List's left list as a list.
	 */
	private void setLeft (DoublyLinkedList newLeft) {
		this.left = newLeft;
	}
	/**
	 * Setter for the list's right list.
	 * This method is set to private because
	 * it should be used in a specific way internally
	 * in order to ensure that the lists are
	 * doubly-linked.
	 * 
	 * @param newRight List's right list as a list.
	 */
	private void setRight (DoublyLinkedList newRight) {
		this.right = newRight;
	}
	
	/**
	 * toString method for the DoublyLinkedList class.
	 * The String displays the left list, the head, and
	 * the right list respectively in separate lines.
	 * 
	 * @return String describing the list in a readable format.
	 */
	public String toString () {
		String s = "Left:\t";
		
		if (this.isEmpty() || this.getLeft().isEmpty()) {
			s += "empty\n";
		} else {
			s += this.getLeft().toStringListFromRight() + "\n";
		}
		
		s += "Head:\t";
		if (this.isEmpty()) {
			s += "empty\n";
		} else {
			s += this.getValue().getName() + "\n";
		}
		
		s += "Right:\t";
		if (this.isEmpty() || this.getRight().isEmpty()) {
			s += "empty\n";
		} else {
			s += this.getRight().toStringListFromLeft() + "\n";
		}
		return s;
	}
	/**
	 * Alternative toString method for the DoublyLinkedList class.
	 * If displayAsList is set to true, the list will be 
	 * displayed using the format:
	 * {Person1, Person2, ... , PersonN}
	 * If displayAsList is set to false, the list will be
	 * displayed as in the usual toString method.
	 * 
	 * @param displayAsList Boolean determining the display mode.
	 * @return String describing the list in a format depending on the boolean input.
	 */
	public String toString (boolean displayAsList) {
		if (displayAsList) {
			return "{" + this.getLeftMost().toStringListFromLeft() + "}";
		}
		return this.toString();
	}
	/**
	 * Helper method for the toString methods.
	 * This method lists each consecutive heads going
	 * from right to left.
	 * 
	 * @return String describing the list of heads starting from the right.
	 */
	public String toStringListFromRight () {
		if (this.isEmpty()) {
			return "empty";
		}
		if (this.getLeft().isEmpty()) {
			return this.getValue().getName();
		}
		return this.getLeft().toStringListFromRight() + ", " + this.getValue().getName();
	}
	/**
	 * Helper method for the toString methods.
	 * This method lists each consecutive heads going
	 * from left to right.
	 * 
	 * @return String describing the list of heads starting from the left.
	 */
	public String toStringListFromLeft () {
		if (this.isEmpty()) {
			return "empty";
		}
		if (this.getRight().isEmpty()) {
			return this.getValue().getName();
		}
		return this.getValue().getName() + ", " + this.getRight().toStringListFromLeft();
	}
	
	/**
	 * equals method for the DoublyLinkedList class.
	 * This method checks starting from the left-most
	 * list of both lists.
	 * The actual comparison is made inside a helper method.
	 * Two lists are equal when they both contain the same
	 * persons.
	 * 
	 * @param that The list that we want to compare to.
	 * @return Boolean stating whether or not the two lists are equal.
	 */
	public boolean equals (DoublyLinkedList that) {
		return this.getLeftMost().helpEquals(that.getLeftMost());
	}
	/**
	 * Helper for the equals method.
	 * 
	 * @param that The list that we want to compare to disregarding the left.
	 * @return Boolean stating whether or not the two lists are equal disregarding the left.
	 */
	public boolean helpEquals (DoublyLinkedList that) {
		if (this.isEmpty() && that.isEmpty()) {
			return true;
		}
		if (this.isEmpty() || that.isEmpty()) {
			return false;
		}
		if (!this.getValue().equals(that.getValue())) {
			return false;
		}
		return this.getRight().helpEquals(that.getRight());
	}
	
	/**
	 * This method checks whether the person is linked to persons of 
	 * opposite gender(s).
	 * If the left and right are both empty, then the person is not
	 * next to the same gender, so the method returns true.
	 * If the list is empty, we throw an illegal argument exception.
	 * 
	 * @param list List to test whether the person is linked to persons of opposite gender(s).
	 * @return Boolean stating whether the person is linked to persons of opposite gender(s).
	 */
	public static boolean check (DoublyLinkedList list) {
		if (list.isEmpty()) {
			throw new IllegalArgumentException("List is empty.");
		}
		if (list.getLeft().isEmpty() && list.getRight().isEmpty()) {
			return true;
		}
		if (list.getLeft().isEmpty()) {
			return !list.getValue().getGender().equals(list.getRight().getValue().getGender());
		}
		if (list.getRight().isEmpty()) {
			return !list.getValue().getGender().equals(list.getLeft().getValue().getGender());
		}
		return !list.getValue().getGender().equals(list.getRight().getValue().getGender())
			&& !list.getValue().getGender().equals(list.getLeft().getValue().getGender());
	}
	
}
