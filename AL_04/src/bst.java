import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.PrintStream;
import java.lang.reflect.Array;
import java.io.FileWriter;
import java.util.Arrays;

public class bst {
	Node root;

	int successor, predecessor;
	int[] data = new int[20];
	int count = 0;

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

	public void insert(int key) {
		root = insertRec(root, key);
	}

	public Node insertRec(Node root, int key) {

		if (root == null) {
			root = new Node(key);
			return root;
		}

		if (key < root.key)
			root.left = insertRec(root.left, key);
		else if (key > root.key)
			root.right = insertRec(root.right, key);

		return root;
	}

	public void inorder() {
		inorderRec(root);
	}

	public void inorderRec(Node root) {

		if (root != null) {
			inorderRec(root.left);

			System.out.println(root.key);

			inorderRec(root.right);

		}

	}

	public boolean Recursive_search(Node root, int key) {

		if (root == null)
			return false;
		if (key == root.key)
			return true;

		if (root.key > key)
			return Recursive_search(root.left, key);

		return Recursive_search(root.right, key);
	}

	public boolean Iterative_serarch(Node root, int key) {
		while (root != null && key != root.key) {
			if (key < root.key) {
				System.out.println(root.key);
				root = root.left;
			} else {
				System.out.println(root.key);
				root = root.right;
			}
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

		if (root == null)
			return root;

		if (key < root.key)
			root.left = deleteRec(root.left, key);
		else if (key > root.key)
			root.right = deleteRec(root.right, key);

		else {

			if (root.left == null)
				return root.right;
			else if (root.right == null)
				return root.left;

			Node x = minValue(root.right);
			root.key = x.key;

			root.right = deleteRec(root.right, root.key);
		}

		return root;
	}

	public void successor(Node root, int key) {
		if (root != null) {
			if (root.key == key) {

				if (root.right != null) {

					Node temp = root.right;
					while (temp.left != null) {
						temp = temp.left;
					}
					successor = temp.key;
				}
			} else if (root.key > key) {

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
					Node temp = root.left;
					while (temp.right != null) {
						temp = temp.right;
					}
					predecessor = temp.key;
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
		String fileName = "Inorder_output.txt";
		try {
			BufferedWriter fw = new BufferedWriter(new FileWriter(fileName, true));
			for (int i = 0; i < data.length; i++) {
				fw.write(Integer.toString(data[i]));
				fw.newLine();
				fw.flush();
			}
			fw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}