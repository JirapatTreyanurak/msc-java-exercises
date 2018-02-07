/** 
 * 
 * @author Jirapat Treyanurak 1214663 jxt163 MSc Computer Science
 * @version 26-01-15
 * 
 * This class contains the solution for Worksheet 2.
 * 
 */
public class Worksheet2 {
	
	// This method returns the identity when the tree is empty
	// simply to reduce the number of casese in the isSearchTree method.
	// Also we cannot assume that the tree is already a binary search tree
	// since that is what we are trying to determine in the first place.
	/**
	 * This method finds the minimum value inside a binary tree.
	 * If the tree is empty, the method returns Integer.MAX_VALUE (identity).
	 * 
	 * @param a Argument tree.
	 * @return A minimum value inside the argument tree.
	 */
	public static int min (Tree a) {
		if (a.getEmpty()) {
			return Integer.MAX_VALUE;
		}
		return Math.min(a.getValue(), Math.min(min(a.getLeft()), min(a.getRight())));
	}
	// This method returns the identity when the tree is empty
	// simply to reduce the number of cases in the isSearchTree method.
	// Also we cannot assume that the tree is already a binary search tree
	// since that is what we are trying to determine in the first place.
	/**
	 * This method finds the maximum value inside a binary tree.
	 * If the tree is empty, the method returns Integer.MIN_VALUE (identity).
	 * 
	 * @param a Argument tree.
	 * @return A maximum value inside the argument tree.
	 */
	public static int max (Tree a) {
		if (a.getEmpty()) {
			return Integer.MIN_VALUE;
		}
		return Math.max(a.getValue(), Math.max(max(a.getLeft()), max(a.getRight())));
	}
	// Since AVL tree should not allow duplicates 
	// (E.g. insert 5,7,4,5,5 then the rotation after the last 5 
	// will leave the tree with a value in the right subtree of a node
	// = to the node itself)
	// we also disallow duplicates here for convenience.
	/**
	 * This method determines whether or not a given tree is a binary search tree.
	 * A binary tree is a binary search tree iff it is empty or for all nodes, we have:
	 *  - all of the nodes in the left subtree have values < the node
	 *  - all of the nodes in the right subtree have values > the node
	 * 
	 * @param a Argument tree.
	 * @return Boolean stating whether or not the argument tree is a binary search tree.
	 */
    public static boolean isSearchTree (Tree a) {
    	if (a.getEmpty()) {
    		return true;
    	}
    	return isSearchTree(a.getLeft())
    		&& isSearchTree(a.getRight())
    		&& max(a.getLeft()) </*=*/ a.getValue()
    		&& min(a.getRight()) > a.getValue();
    }
    /**
     * This method determines whether or not a given tree is a height-balanced tree.
     * A binary tree is a height-balanced tree iff it is empty or for all nodes, we have:
     *  - the height difference between the left and right subtree is no bigger than 1
     * 
     * @param a Argument tree.
     * @return Boolean stating whether or not the argument tree is a height-balanced tree.
     */
    public static boolean isHeightBalanced (Tree a) {
    	if (a.getEmpty()) {
    		return true;
    	}
    	return isHeightBalanced(a.getLeft())
    		&& isHeightBalanced(a.getRight())
    		&& Math.abs(a.getLeft().getHeight() - a.getRight().getHeight()) <= 1;
    }
    /**
     * This method rotates the argument tree to the left using AVL rotations (RL and RR).
     * This method assumes that the argument tree is "heavy on the right",
     * i.e. height(right) - height(left) > 1.
     * 
     * In particular, we note that this precondition is only possible if we have at least
     * 2 nodes in the right subtree of the argument tree. Hence a.getRight() is not empty,
     * and hence we have access to the left and right subtree of a.getRight().
     * 
     * Note further that if we are in the RL case, the left subtree of the right subtree
     * must be non-empty as well, hence we also have access to the left and right
     * subtree of a.getRight().getLeft() in this case.
     * 
     * Note also that this method is O(1).
     * 
     * @param a Argument tree that is "heavy on the right".
     * @return Argument tree rotated to the left using either RL or RR AVL rotation.
     */
    public static Tree rotateLeft (Tree a) {
    	if (a.getRight().getRight().getHeight() >= a.getRight().getLeft().getHeight()) {
    		return new Tree( // RR case
					a.getRight().getValue(),
					new Tree(a.getValue(), a.getLeft(), a.getRight().getLeft()),
					a.getRight().getRight()
				);
    	} else {
    		return new Tree( // RL case
					a.getRight().getLeft().getValue(),
					new Tree(a.getValue(), a.getLeft(), a.getRight().getLeft().getLeft()),
					new Tree(a.getRight().getValue(), a.getRight().getLeft().getRight(), a.getRight().getRight())
				);
    	}
    }
    /**
     * This method rotates the argument tree to the right using AVL rotations (LR and LL).
     * This method assumes that the argument tree is "heavy on the left",
     * i.e. height(left) - height(right) > 1.
     * 
     * In particular, we note that this precondition is only possible if we have at least
     * 2 nodes in the left subtree of the argument tree. Hence a.getLeft() is not empty,
     * and hence we have access to the left and right subtree of a.getLeft().
     * 
     * Note further that if we are in the LR case, the right subtree of the left subtree
     * must be non-empty as well, hence we also have access to the left and right
     * subtree of a.getLeft().getRight() in this case.
     * 
     * Note also that this method is O(1).
     * 
     * @param a Argument tree that is "heavy on the left".
     * @return Argument tree rotated to the right using either LR or LL AVL rotation.
     */
    public static Tree rotateRight (Tree a) {
    	if (a.getLeft().getLeft().getHeight() >= a.getLeft().getRight().getHeight()) {
    		return new Tree( // LL case
					a.getLeft().getValue(),
					a.getLeft().getLeft(),
					new Tree(a.getValue(), a.getLeft().getRight(), a.getRight())
				);
    	} else {
    		return new Tree( // LR case
					a.getLeft().getRight().getValue(),
					new Tree(a.getLeft().getValue(), a.getLeft().getLeft(), a.getLeft().getRight().getLeft()),
					new Tree(a.getValue(), a.getLeft().getRight().getRight(), a.getRight())
				);
    	}
    }
    /**
     * This method returns a new tree that attempts to re-balance the argument tree at the root node.
     * The method assumes that the argument tree is at worst "slightly imbalanced"
     * in the sense that the argument tree is any binary tree that can be obtained
     * immediately after ONE insertion/deletion from an AVL tree.
     * Hence this method assumes that one appropriate AVL rotation is sufficient to re-balance
     * the argument tree at the root node since everything below it will already be balanced
     * (this is not to say anything about the bigger tree that the argument tree may be a part of).
     * If the argument tree is empty, the method returns a copy of that tree.
     * 
     * This method works in O(1) since both methods rotateRight and rotateLeft are O(1).
     * 
     * @param a Argument tree that is at worst "slightly imbalanced".
     * @return A new AVL tree that results from applying a rotation on the argument tree.
     */
    public static Tree reBalanceNode (Tree a) {
    	if (Math.abs(a.getLeft().getHeight() - a.getRight().getHeight()) <= 1) {
    		return new Tree(a.getValue(), a.getLeft(), a.getRight());
    	}
    	if (a.getLeft().getHeight() > a.getRight().getHeight()) {
    		return rotateRight(a);
    	} else { //                 <
    		return rotateLeft(a);
    	}
    }
    // This method works in O(log n) since it is the same as binary search tree insertion
    // (O(log n)) but with a re-balancing from the bottom up after every insertion. However,
    // the reBalanceNode method is done in time O(1), hence the AVL insertion is still O(log n).
    /**
     * This method inserts the argument value x into the argument AVL tree a.
     * The method will return a new tree that is also an AVL tree after the insertion.
     * If the argument tree already has a node with the value x, then the method
     * will return a new tree that is a copy of the argument tree without inserting 
     * any values.
     * 
     * @param x Argument value to be inserted into the argument tree.
     * @param a Argument tree that is assumed to be an AVL tree.
     * @return A new AVL tree that is a copy of the argument tree with the argument value inserted and balanced.
     */
    public static Tree insertHB (int x, Tree a) {
    	if (a.getEmpty()) {
    		return new Tree(x);
    	}
    	if (x == a.getValue()) {
    		return new Tree(a.getValue(), a.getLeft(), a.getRight());
    	} // we don't need rebalancing in the first two cases here.
    	if (x < a.getValue()) {
    		return reBalanceNode(new Tree(a.getValue(), insertHB(x, a.getLeft()), a.getRight()));
    	}
    	return reBalanceNode(new Tree(a.getValue(), a.getLeft(), insertHB(x, a.getRight())));
    }
    // This method is to help deleteHB method in place of the max method defined above
    // since max takes time O(n) whereas this method will take time O(log n).
    /**
     * This method finds the maximum value inside a binary search tree.
     * If the tree is empty, the method returns Integer.MIN_VALUE (identity).
     * 
     * @param a Argument tree that is assumed to be a binary search tree.
     * @return A maximum value inside the argument tree.
     */
    public static int maxBST (Tree a) {
    	if (a.getEmpty()) {
    		return Integer.MIN_VALUE;
    	}
    	if (a.getRight().getEmpty()) {
    		return a.getValue();
    	}
    	return maxBST(a.getRight());
    }
    // This method works in O(log n) since it is the same as binary search tree deletion
    // (O(log n)) but with a re-balancing from the bottom up after every deletion. However,
    // the reBalanceNode method is done in time O(1), hence the AVL deletion is still O(log n).
    /**
     * This method attempts to delete the argument value x from the argument AVL tree a.
     * The method will return a new tree that is also an AVL tree after the deletion.
     * 
     * @param a Argument tree that is assumed to be an AVL tree.
     * @param x Argument value to be deleted from the argument tree.
     * @return A new AVL tree that is a copy of the argument tree with the argument value deleted and balanced.
     */
    public static Tree deleteHB (Tree a, int x) {
    	if (a.getEmpty()) {
    		return new Tree();
    	}
    	if (a.getValue() == x) {
    		if (a.getLeft().getEmpty() && a.getRight().getEmpty()) {
    			return new Tree();
    		}
    		if (a.getLeft().getEmpty()) {
    			return reBalanceNode(new Tree(a.getRight().getValue(), a.getRight().getLeft(), a.getRight().getRight()));
    		}
    		if (a.getRight().getEmpty()) {
    			return reBalanceNode(new Tree(a.getLeft().getValue(), a.getLeft().getLeft(), a.getLeft().getRight()));
    		}
    		return reBalanceNode(new Tree(maxBST(a.getLeft()), deleteHB(a.getLeft(), maxBST(a.getLeft())), a.getRight()));
    	}
    	if (x <= a.getValue()) {
    		return reBalanceNode(new Tree(a.getValue(), deleteHB(a.getLeft(), x), a.getRight()));
    	} else {
    		return reBalanceNode(new Tree(a.getValue(), a.getLeft(), deleteHB(a.getRight(), x)));
    	}
    }
    
}
