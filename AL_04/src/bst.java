import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.PrintStream;
import java.lang.reflect.Array;
import java.io.FileWriter;
import java.util.Arrays;

public class bst{
	Node root;
	/*File a = new File("e.txt");
	FileWriter b = new FileWriter(a);*/
	int successor, predecessor;
	int [] data = new int[10];
	int count=0;
	
	class Node {
		int key;
		Node left = null, right = null;

		Node(int key) {
			this.key = key;
		}
	}

	// Constructor
	void BinarySearchTree() {
		root = null;
	}

	public void median_insert(int[] arr) {
		Arrays.sort(arr);
		int x = arr.length;

		while (x != 0) {
			int median = x / 2;
			insert(arr[median]);
			for (int i = median; i < x - 1; i++) {
				arr[i] = arr[i + 1];
			}
			x = x - 1;
		}

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
	public void inorder()  {
		inorderRec(root);
	}

	// A utility function to do inorder traversal of BST
	public void inorderRec(Node root)  {
		
		if (root != null) {
			inorderRec(root.left);
			
			System.out.println(root.key);
			data[count] = root.key;
			count++;
			inorderRec(root.right);
			
		}
		
	}

	public boolean Recursive_search(Node root, int key) {
		// Base Cases: root is null or key is present at root
		if (root == null)
			return false;
		if (key == root.key)
			return true;
		// val is greater than root's key
		if (root.key > key)
			return Recursive_search(root.left, key);

		return Recursive_search(root.right, key);
	}

	public boolean Iterative_serarch(Node root, int key) {
		while (root != null && key != root.key) {
			if (key < root.key)
				root = root.left;
			else
				root = root.right;
		}
		
		if (root == null)
			return false;
		return true;
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
			Node x = minValue(root.right);
			root.key = x.key;

			// Delete the inorder successor
			root.right = deleteRec(root.right, root.key);
		}

		return root;
	}

	public void successor(Node root, int key) {
		if (root != null) {
			if (root.key == key) {
				// go to the right most element in the left subtree, it will the
				// predecessor.

				if (root.right != null) {
					// go to the left most element in the right subtree, it will
					// the successor.
					Node t = root.right;
					while (t.left != null) {
						t = t.left;
					}
					successor = t.key;
				}
			} else if (root.key > key) {
				// we make the root as successor because we might have a
				// situation when value matches with the root, it wont have
				// right subtree to find the successor, in that case we need
				// parent to be the successor
				successor = root.key;
				successor(root.left, key);
			}
		}
		System.out.println("Inorder Successor of" + key + " is : " + successor);
	}

	public void Predecessor(Node root, int key) {
		if (root != null) {
			if (root.key == key) {
				// go to the right most element in the left subtree, it will the
				// predecessor.
				if (root.left != null) {
					Node t = root.left;
					while (t.right != null) {
						t = t.right;
					}
					predecessor = t.key;
				}

			} else if (root.key < key) {
				// we make the root as predecessor because we might have a
				// situation when value matches with the root, it wont have
				// right subtree to find the predecessor, in that case we need
				// parent to be the predecessor.
				predecessor = root.key;
				Predecessor(root.right, key);
			}
		}
		System.out.println("Inorder predecessor of" + key + " is : " + predecessor);

	}

	public Node minValue(Node root) {
		while (root.left != null) {
			root = root.left;
		}
		return root;
	}
	public void wirteFile() {
		String fileName ="Inorder_output.txt";
		try {
			BufferedWriter fw = new BufferedWriter(new FileWriter(fileName,true));
			for(int i=0;i<data.length;i++) {
				fw.write(Integer.toString(data[i]));
				fw.newLine();
				fw.flush();
			}
			fw.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
}