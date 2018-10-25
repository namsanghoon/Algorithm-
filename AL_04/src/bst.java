
public class bst {
	Node root;

	class Node {
		int key;
		Node left, right;

		public Node(int item) {
			key = item;
			left = right = null;
		}
	}

	// Constructor
	void BinarySearchTree() {  
        root = null;  
    }

	// This method mainly calls insertRec()
	public void insert(int key) {
		root = insertRec(root, key);
	}

	/* A recursive function to insert a new key in BST */
	public Node insertRec(Node root, int key) {

		/* If the tree is empty, return a new node */
		if (root == null) {
			root = new Node(key);
			return root;
		}

		/* Otherwise, recur down the tree */
		if (key < root.key)
			root.left = insertRec(root.left, key);
		else if (key > root.key)
			root.right = insertRec(root.right, key);

		/* return the (unchanged) node pointer */
		return root;
	}

	// This method mainly calls InorderRec()
	public void inorder() {
		inorderRec(root);
	}

	// A utility function to do inorder traversal of BST
	public void inorderRec(Node root) {
		if (root != null) {
			inorderRec(root.left);
			System.out.println(root.key);
			inorderRec(root.right);
		}
	}

	public Node Recursive_search(Node root, int key) {
		// Base Cases: root is null or key is present at root
		if (root == null || key == root.key)
			return root;

		// val is greater than root's key
		if (root.key > key)
			return Recursive_search(root.left, key);

		// val is less than root's key
		return Recursive_search(root.right, key);
	}

	public Node Iterative_serarch(Node root, int key) {
		while (root != null && key != root.key) {
			if (key < root.key)
				root = root.left;
			else
				root = root.right;
		}
		return root;
	}

	public void deleteKey(int key) {
		root = deleteRec(root, key);
	}

	/* A recursive function to insert a new key in BST */
	public Node deleteRec(Node root, int key) {
		/* Base Case: If the tree is empty */
		if (root == null)
			return root;

		/* Otherwise, recur down the tree */
		if (key < root.key)
			root.left = deleteRec(root.left, key);
		else if (key > root.key)
			root.right = deleteRec(root.right, key);

		// if key is same as root's key, then This is the node
		// to be deleted
		else {
			// node with only one child or no child
			if (root.left == null)
				return root.right;
			else if (root.right == null)
				return root.left;

			// node with two children: Get the inorder successor (smallest
			// in the right subtree)
			root.key = minValue(root.right);

			// Delete the inorder successor
			root.right = deleteRec(root.right, root.key);
		}

		return root;
	}

	public int minValue(Node root) {
		int minv = root.key;
		while (root.left != null) {
			minv = root.left.key;
			root = root.left;
		}
		return minv;
	}
}