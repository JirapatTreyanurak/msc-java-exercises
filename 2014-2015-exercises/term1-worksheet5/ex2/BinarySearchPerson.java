package ex2;
import ex1.Person;

/** Worksheet 5 Exercise 2
 * 
 * This BinarySearchPerson class describes 
 * a binary tree of persons and contains a
 * method to insert the person into an appropriate
 * place inside the tree according to their
 * lexicographical order.
 * It also contains a method to look up the age of 
 * a person with the name specified among the persons 
 * inside the tree.
 * 
 * @author Jirapat Treyanurak (jxt163 1214663 MSc Computer Science)
 * @version 2014-12-02
 */
public class BinarySearchPerson {
	
	private Person value;
	private BinarySearchPerson left;
	private BinarySearchPerson right;
	private boolean empty;
	
	/**
	 * Constructor for the BinarySearchPerson class.
	 * 
	 * @param value Tree's value as a person.
	 * @param left Tree's left tree as a tree.
	 * @param right Tree's right tree as a tree.
	 */
	public BinarySearchPerson (Person value, BinarySearchPerson left, BinarySearchPerson right) {
		this.value = value;
		this.left = left;
		this.right = right;
		this.empty = false;
	}
	/**
	 * Constructor for an empty tree.
	 */
	public BinarySearchPerson () {
		this.value = null;
		this.left = null;
		this.right = null;
		this.empty = true;
	}
	/**
	 * Short constructor for BinarySearchPerson.
	 * Takes in an arbitrary number of persons and add them
	 * to the tree from left to right using the insert method.
	 * 
	 * @param values Persons that will go into the tree.
	 * @return Tree containing the specified persons.
	 */
	public static BinarySearchPerson cons (Person... values) {
		BinarySearchPerson t = empty();
		for (int i = 0; i < values.length; i++) {
			t = insert(values[i], t);
		}
		return t;
	}
	/**
	 * Short constructor for an empty BinarySearchPerson tree.
	 * 
	 * @return Empty tree.
	 */
	public static BinarySearchPerson empty () {
		return new BinarySearchPerson();
	}
	
	/**
	 * Method that inserts the person into an appropriate
	 * place inside the tree based on lexicographical order
	 * of their names.
	 * 
	 * @param person The person we want to insert into the tree.
	 */
	public static BinarySearchPerson insert (Person person, BinarySearchPerson tree) {
		if (tree.isEmpty()) {
			tree.setValue(person);
			tree.setLeft(new BinarySearchPerson());
			tree.setRight(new BinarySearchPerson());
			tree.setEmpty(false);
		} else if (person.getName().equals(tree.getValue().getName())) {
			return tree;
		} else if (person.getName().compareTo(tree.getValue().getName()) < 0) {
			insert(person, tree.getLeft());
		} else {
		insert(person, tree.getRight());
		}
		return tree;
	}
	
	/**
	 * Getter for the tree's value.
	 * 
	 * @return Tree's value as a person.
	 */
	public Person getValue () {
		return this.value;
	}
	/**
	 * Getter for the tree's left tree.
	 * 
	 * @return Tree's left tree as a tree.
	 */
	public BinarySearchPerson getLeft () {
		return this.left;
	}
	/**
	 * Getter for the tree's right tree.
	 * 
	 * @return Tree's right tree as a tree.
	 */
	public BinarySearchPerson getRight () {
		return this.right;
	}
	/**
	 * Getter for the tree's empty status.
	 * 
	 * @return Tree's empty status as a boolean.
	 */
	public boolean getEmpty () {
		return this.empty;
	}
	public boolean isEmpty () {
		return this.getEmpty();
	}
	/**
	 * Setter for the tree's value.
	 * 
	 * @param newValue Tree's new value as a person.
	 */
	public void setValue (Person newValue) {
		this.value = newValue;
	}
	/**
	 * Setter for the tree's left tree.
	 * 
	 * @param newLeft Tree's new left tree as a tree.
	 */
	public void setLeft (BinarySearchPerson newLeft) {
		this.left = newLeft;
	}
	/**
	 * Setter for the tree's right tree.
	 * 
	 * @param newRight Tree's new right tree as a tree.
	 */
	public void setRight (BinarySearchPerson newRight) {
		this.right = newRight;
	}
	/**
	 * Setter for the tree's empty status.
	 * 
	 * @param newEmpty Tree's new empty status as a boolean.
	 */
	public void setEmpty (boolean newEmpty) {
		this.empty = newEmpty;
	}
	
	/**
	 * toString method for the BinarySearchPerson class.
	 * Describes the tree as a list.
	 * 
	 * @return String describing the tree as a list.
	 */
	public String toString () {
		return "{" + this.helpToString() + "}";
	}
	/**
	 * Helper for the toString method.
	 * Prints the name of the person in the node,
	 * then recursively call the same method to
	 * the left and right tree.
	 * 
	 * @return String describing the tree as a list.
	 */
	public String helpToString () {
		String s = "";
		if (this.getValue() == null) {
			return s;
		}
		s += this.getValue().getName();
		if (!this.getLeft().isEmpty()) {
			s += ", " + this.getLeft().helpToString();
		}
		if (!this.getRight().isEmpty()) {
			s += ", " + this.getRight().helpToString();
		}
		return s;
	}
	
	/**
	 * This methods looks for the person
	 * with the specified name inside the tree
	 * and returns his/her age.
	 * If no such person is found, the method
	 * returns -1.
	 * 
	 * @param name The name of the person we want to find the age of inside the tree.
	 * @return The age of the person with the specified name.
	 */
	public int lookupAge (String name) {
		if (this.getEmpty()) {
			return -1;
		}
		if (this.getValue().getName().equals(name)) {
			return this.getValue().getAge();
		}
		if (name.compareTo(this.getValue().getName()) < 0) {
			return this.getLeft().lookupAge(name);
		}
		return this.getRight().lookupAge(name);
	}
	
	/**
	 * equals method for the BinarySearchPerson class.
	 * Two trees are the same when they contain the same persons
	 * in the same nodes.
	 * 
	 * @param that The tree that we want to compare to.
	 * @return Boolean stating whether or not the two trees are the same.
	 */
	public boolean equals (BinarySearchPerson that) {
		if (this.isEmpty() && that.isEmpty()) {
			return true;
		}
		if (this.isEmpty() || that.isEmpty()) {
			return false;
		}
		return this.getValue().equals(that.getValue())
			&& this.getLeft().equals(that.getLeft())
			&& this.getRight().equals(that.getRight());
	}
	
}