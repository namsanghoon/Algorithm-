
public class RBTree {
	private final boolean RED = false;
	private final boolean BLACK = true;

	private class Node {

		int key;
		boolean color = BLACK;
		Node left = nil, right = nil, parent = nil;

		Node(int key) {
			this.key = key;
		}
	}

	private final Node nil = new Node(-1);
	private Node root = nil;

	private void insert(Node node) {
		Node temp = root;
		if (root == nil) {
			root = node;
			node.color = BLACK;
			node.parent = nil;
		} else {
			node.color = RED;
			while (true) {
				if (node.key < temp.key) {
					if (temp.left == nil) {
						temp.left = node;
						node.parent = temp;
						break;
					} else {
						temp = temp.left;
					}
				} else if (node.key >= temp.key) {
					if (temp.right == nil) {
						temp.right = node;
						node.parent = temp;
						break;
					} else {
						temp = temp.right;
					}
				}
			}
			fixTree(node);
		}
	}
	private void fixTree(Node node) {
		while (node.parent.color == RED) {
			Node uncle = nil;
			Node grand = node.parent.parent;
			if (node.parent == grand.left) {
				uncle = grand.right;
				//case 1
				if (uncle != nil && uncle.color == RED) {
					node.parent.color = BLACK;
					uncle.color = BLACK;
					grand.color = RED;
					node = grand;
					continue;
				}
				//case 2-1
				if (node == node.parent.right) {
					
					node = node.parent;
					rotateLeft(node);
				}
				node.parent.color = BLACK;
				grand.color = RED;
				//case 2-2
				rotateRight(grand);
			} else {
				uncle = grand.left;
				if (uncle != nil && uncle.color == RED) {
					node.parent.color = BLACK;
					uncle.color = BLACK;
					grand.color = RED;
					node = grand;
					continue;
				}
				if (node == node.parent.left) {
					
					node = node.parent;
					rotateRight(node);
				}
				node.parent.color = BLACK;
				grand.color = RED;
				rotateLeft(grand);
			}
		}
		root.color = BLACK;
	}

	void rotateLeft(Node node) {
		if (node.parent != nil) {
			if (node == node.parent.left) {
				node.parent.left = node.right;
			} else {
				node.parent.right = node.right;
			}
			node.right.parent = node.parent;
			node.parent = node.right;
			if (node.right.left != nil) {
				node.right.left.parent = node;
			}
			node.right = node.right.left;
			node.parent.left = node;
		} else {
			Node right = root.right;
			root.right = right.left;
			right.left.parent = root;
			root.parent = right;
			right.left = root;
			right.parent = nil;
			root = right;
		}
	}

	void rotateRight(Node node) {
		if (node.parent != nil) {
			if (node == node.parent.left) {
				node.parent.left = node.left;
			} else {
				node.parent.right = node.left;
			}
			node.left.parent = node.parent;
			node.parent = node.left;
			if (node.left.right != nil) {
				node.left.right.parent = node;
			}
			node.left = node.left.right;
			node.parent.right = node;
		} else {// Need to rotate root
			Node left = root.left;
			root.left = root.left.right;
			left.right.parent = root;
			root.parent = left;
			left.right = root;
			left.parent = nil;
			root = left;
		}
	}

	public void add(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			Node pt = new Node(arr[i]);
			// Do a normal BST insert
			insert(pt);

		}
		/* printTree(root); */
	}

	public void printTree(Node node) {
		if (node == nil) {
			return;
		}
		printTree(node.left);
		System.out.print(((node.color == RED) ? "Color: Red " : "Color: Black ") + "Key: " + node.key + " Parent: "
				+ node.parent.key + "\n");
		printTree(node.right);
	}

	public void searchNode(int a) {
		Node node = new Node(a);
		search(node, root);

	}

	private Node search(Node findNode, Node node) {
		if (root == nil) {
			return null;
		}

		if (findNode.key < node.key) {
			if (node.left != nil) {
				System.out.println(node.key);
				return search(findNode, node.left);
			}
		} else if (findNode.key > node.key) {
			if (node.right != nil) {
				System.out.println(node.key);
				return search(findNode, node.right);
			}
		} else if (findNode.key == node.key) {
			return node;
		}
		return null;
	}

}
