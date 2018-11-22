
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;

public class Union_Find {
	public class Node {
		public String key;
		public String id;
		public Node next;
		public Node parent;

		public Node(String id, String key) {
			this.id = id;
			this.key = key;
		}

		public Node(String id, String key, Node next) {
			this.id = id;
			this.key = key;
			this.next = null;
			parent = null;
		}
	}
	Node head;
	Node tail;
	Node root_1, root_2, root_3, root_4, root_5;
	private int size, size_1, size_2, size_3, size_4, size_5 = 0;
	

	public void Make_Set(String id, String key) {
		Node newNode = new Node(id, key);
		if (size == 0) {
			newNode.next = head;
			// ���� ���ο� ��带 �����մϴ�.
			head = newNode;
			size++;
			if (head.next == null) {
				tail = head;
			}
		} else {
			tail.next = newNode;
			// ������ ��带 �����մϴ�.
			tail = newNode;
			// ������Ʈ�� ������ 1 ���� ��ŵ�ϴ�.
			size++;
		}
		newNode.parent = newNode;
	}

	// ���ڸ� ��������
	public void Union_by_key() {
		Node p = head;
		while (p != null) {
			if (p.key.equals("1")) {
				if (size_1 == 0) {
					root_1 = new Node(p.id, p.key);
					root_1.parent = root_1;
					size_1++;
				} else {
					p.parent = root_1;
				}
			}
			if (p.key.equals("2")) {

				if (size_2 == 0) {
					root_2 = new Node(p.id, p.key);
					root_2.parent = root_2;
					size_2++;
				} else {
					p.parent = root_2;
				}
			}
			if (p.key.equals("3")) {

				if (size_3 == 0) {
					root_3 = new Node(p.id, p.key);
					root_3.parent = root_3;
					size_3++;
				} else {

					p.parent = root_3;

				}
			}
			if (p.key.equals("4")) {

				if (size_4 == 0) {
					root_4 = new Node(p.id, p.key);
					root_4.parent = root_4;
					size_4++;
				} else {

					p.parent = root_4;

				}
			}
			if (p.key.equals("5")) {

				if (size_5 == 0) {
					root_5 = new Node(p.id, p.key);
					root_5.parent = root_5;
					size_5++;
				} else {

					p.parent = root_5;

				}
			}
			p = p.next;
		}
	}
	//��ȣ ������� 
	public void Union(String x, String y) {
		Node p, q = head;

		for (p = head; p != null; p = p.next) {
			for (q = head; q != null; q = q.next) {
				if (p.key.equals(x) && q.key.equals(y)) {
					find(p).parent = find(q);
					break;
				}
			}
		}
	}

	public Node find(Node node) {
		if (node.parent == node)
			return node;
		else
			return find(node.parent);
	}

	public void print() {
		Node p = head;
		while (p != null) {
			System.out.println(p.id + "	" + p.parent.id);
			p = p.next;
		}
	}

	public void writeFile_output_1() {
		String fileName = "Output1.txt";
		try {
			BufferedWriter fw = new BufferedWriter(new FileWriter(fileName, true));
			Node p = head;
			while (p != null) {
				fw.write(p.id + "	" + p.parent.id);
				fw.newLine();
				p = p.next;
			}
			fw.flush();
			fw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void writeFile_output_2() {
		String fileName = "Output2.txt";
		try {
			BufferedWriter fw = new BufferedWriter(new FileWriter(fileName, true));
			Node p = head;
			while (p != null) {
				fw.write(p.id + "	" + p.parent.id);
				fw.newLine();
				p = p.next;
			}
			fw.flush();
			fw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
