/** 
 * 
 * @author Jirapat Treyanurak 1214663 jxt163 MSc Computer Science
 * @version 19-01-15
 * 
 * This class contains the solution for Worksheet 1.
 * 
 */
public class Worksheet1 {
	
	/**
	 * This method checks whether or not all of the elements inside the argument list
	 * are non-negative integers.
	 * If the argument list is empty, the method returns true.
	 * 
	 * @param a Argument list that will be checked non-negativeness.
	 * @return A boolean stating whether or not all of the elements are non-negative.
	 */
	public static boolean allPositive (List a) {
		if (a.isEmpty()) {
			return true;
		}
		if (a.getTail().isEmpty()) {
			return a.getHead() >= 0;
		}
		return a.getHead() >= 0 && allPositive(a.getTail());
	}
	/**
	 * This method checks whether or not the elements inside the argument list are sorted
	 * in non-decreasing order.
	 * If the argument list is empty, the method returns true.
	 * 
	 * @param a Argument list that will be checked for sortedness.
	 * @return A boolean stating whether or not the argument list is sorted.
	 */
	public static boolean sorted (List a) {
		if (a.isEmpty() || a.getTail().isEmpty()) {
			return true;
		}
		return a.getHead() <= a.getTail().getHead() && sorted(a.getTail());
	}
	/**
	 * This method should be inside the List class but it is put here just to be sure
	 * that we have it.
	 * This method returns a new list that contains all of the elements inside the argument
	 * list listed in the same order.
	 * If the argument list is empty, the method returns a new empty list.
	 * 
	 * @param l Argument list that is to be copied.
	 * @return A copy of the argument list.
	 */
	public static List clone (List l) {
		if (l.isEmpty()) {
			return List.empty();
		}
		return List.cons(l.getHead(), clone(l.getTail()));
	}
	/**
	 * This method merge two sorted lists together to result in a new sorted list containing
	 * all of the elements (including any duplicate values) from both lists.
	 * If both argument lists are empty, the method returns a new empty list.
	 * If one of the argument list is empty, the method returns a copy of the other list.
	 * 
	 * @param a Argument list that is assumed to be sorted.
	 * @param b Argument list that is assumed to be sorted.
	 * @return A new sorted list that is the merge of the two argument lists.
	 */
	public static List merge (List a, List b) {
		if (a.isEmpty()) {
			return clone(b);
		}
		if (b.isEmpty()) {
			return clone(a);
		}
		if (a.getHead() < b.getHead()) {
			return List.cons(a.getHead(), merge(a.getTail(), b));
		}
		return List.cons(b.getHead(), merge(a, b.getTail()));
	}
	/**
	 * This method creates a new list based on the argument list but without duplicate values.
	 * The method assumes that the argument list is already sorted.
	 * If the argument list is empty, the method returns a new empty list.
	 * 
	 * @param a Argument list that is assumed to be sorted.
	 * @return A new list containing the elements from the argument list but without duplicate values.
	 */
	public static List removeDuplicates (List a) {
		if (a.isEmpty()) {
			return List.empty();
		}
		if (a.getTail().isEmpty()) {
			return List.cons(a.getHead(), List.empty());	
		}
		if (a.getHead() == a.getTail().getHead()) {
			return removeDuplicates(a.getTail());
		}
		return List.cons(a.getHead(), removeDuplicates(a.getTail()));
	}
	/**
	 * This method creates a new tree based on the argument tree but mirrored left to right.
	 * If the argument tree is empty, the method returns a new empty tree.
	 * 
	 * @param t Argument tree.
	 * @return A new tree containing the nodes from the argument tree but mirrored left to right.
	 */
	public static Tree mirror (Tree t) {
		if (t.getEmpty()) {
			return new Tree();
		}
		return new Tree(t.getValue(), mirror(t.getRight()), mirror(t.getLeft()));
	}
	/**
	 * This method returns a String listing the values inside the argument tree in descending order.
	 * The method assumes that the argument tree is a binary search tree.
	 * The values are separated by a single space and it does not have a trailing space at the end.
	 * If the argument tree is empty, an empty String is returned.
	 * 
	 * @param a Argument tree that is assumed to be a binary search tree.
	 * @return A String listing the values in the argument tree in descending order.
	 */
	public static String showDescending (Tree a) {
		if (a.getEmpty()) {
			return "";
		}
		if (a.getRight().getEmpty() && a.getLeft().getEmpty()) {
			return a.getValue() + "";
		}
		if (a.getRight().getEmpty()) {
			return a.getValue() + " " + showDescending(a.getLeft());
		}
		if (a.getLeft().getEmpty()) {
			return showDescending(a.getRight()) + " " + a.getValue();
		}
		return showDescending(a.getRight()) + " " + a.getValue() + " " + showDescending(a.getLeft());
	}
	/**
	 * This method returns a maximum value inside the argument tree.
	 * The method assumes that the argument tree is a binary search tree.
	 * If the argument tree is empty, an IllegalStateException is thrown.
	 * 
	 * @param a Argument tree that is assumed to be a binary search tree.
	 * @return An integer that is the maximum value inside the argument tree.
	 */
	public static int max (Tree a) {
		if (a.getEmpty()) {
			//or return Integer.MIN_VALUE
			throw new IllegalStateException("No maximum value in an empty tree.");
		}
		if (a.getRight().getEmpty()) {
			return a.getValue();
		}
		return max(a.getRight());
	}
	/**
	 * This method attempts to delete the argument value from the argument tree.
	 * The method assumes that the argument tree is a binary search tree.
	 * The method does not assume that the argument value is inside the tree.
	 * If the argument tree is empty, the method returns a new empty tree.
	 * If the argument value is not inside of the tree, the method returns a copy of the argument tree.
	 * If there are more than 1 node inside the argument tree that contains the argument value,
	 * the first instance (traversing from the root) will get deleted, but not the others.
	 * If the node being deleted is a leaf, the method returns a copy of the argument tree but without
	 * the node being deleted.
	 * If the node being deleted has exactly 1 child tree, the method returns a copy of the argument
	 * tree but without the node being deleted. The child tree of the deleted node replaces the deleted node.
	 * If the node being deleted has 2 children tree, the method returns a copy of the argument tree
	 * but without the node being deleted. The deleted node will get replaced by a node from the left subtree
	 * of the deleted node that has the maximum value (in that left subtree).
	 * In all cases, the tree being returned will be a binary search tree.
	 * 
	 * @param a Argument tree that is assumed to be a binary search tree.
	 * @param x Integer value that will be deleted from the tree.
	 * @return A new binary search tree based on the argument tree, but with one node containing the value x removed.
	 */
	public static Tree delete (Tree a, int x) {
		if (a.getEmpty()) {
			return new Tree();
		}
		if (a.getValue() == x) {
			if (a.getLeft().getEmpty() && a.getRight().getEmpty()) {
				return new Tree();
			}
			if (a.getLeft().getEmpty()) {
				return new Tree(a.getRight().getValue(), a.getRight().getLeft(), a.getRight().getRight());
			}
			if (a.getRight().getEmpty()) {
				return new Tree(a.getLeft().getValue(), a.getLeft().getLeft(), a.getLeft().getRight());
			}
			return new Tree(max(a.getLeft()), delete(a.getLeft(), max(a.getLeft())), a.getRight());
		}
		if (x < a.getValue()) {
			return new Tree(a.getValue(), delete(a.getLeft(), x), a.getRight());
		}
		return new Tree(a.getValue(), a.getLeft(), delete(a.getRight(), x));
	}
	/**
	 * This method states that XueShen loves MengShen :)
	 * It also states that MengShen loves XueShen :)
	 * It also states that MengShen has XueShen :)
	 * It returns a tree of love.
	 * 
	 * @return A good tree.
	 */
	public static Tree test () {
		return new Tree();
	}
	
	/*
	Person XueShen = new Person("XueShen");
	Person MengShen = new Person("MengShen");
	
	XueShen.loves(MengShen);
	MengShen.isCute() == true;
	XueShen.isCute() == true;
	MengShen.has(XueShen) == true;
	MengShen.loves(XueShen); // :)
	 */
}