
public class DoubleLinkedList {
	public Node head; // 시작노드
	public Node tail; // 종결노드
	private int size;

	public DoubleLinkedList() {
		head = new Node(null);
		tail = new Node(null);
		size = 0;
	}
	// 삽입 메소드
	public void add(Object object) {
		Node newNode = new Node(object);
		newNode.next = head.next;
		if (head.next != null) {
			head.next.prev = newNode;
		} else {
			head.prev = newNode;
		}
		head.next = newNode;
		size++;
	}
	// 삭제메소드
	public void delete(int x) {
		int i = 0;
		int count = 0;
		Node p = head;
		Node q;

		while (i < size) {// 삭제할 노드를 검색
			if ((int) p.next.object == x) {
				q = p.next;
				p.next = p.next.next;
				p = p.next.prev;
				size--;
				count++;
				break;
			}
			i++;
			p = p.next;
		}

		if (count == 0) { // 삭제할 노드가 리스트에 없을 때
			System.out.println("Delete " + x + "   " + x + " is not in the list");
		}

		if (count == 1) {// 삭제할 노드가 리스트에 있을 때
			if (size == 0) {// 비어있을 경우
				System.out.println("Delete " + x + " | HEAD --> ");
			} else {
				System.out.print("Delete " + x + " | HEAD --> ");

			}
		}
	}

	// 버블정렬
	public void BubbleSort(int[] array) {
		Node p, q;

		for (p = head.prev; p != head.next;) {
			for (q = head.next; q != p;) {
				if ((int) q.object > (int) q.next.object) {
					Object value = q.next.object;
					q.next.object = q.object;
					q.object = value;
					q = q.next;
				} else
					q = q.next;
			}
			p = p.prev;
		}
	}

	// 삽입정렬
	public void InsertionSort(int[] array) {
		Node q = head;

		q = q.next.next;

		while (q.next != head) {
			if ((int) q.object < (int) q.prev.object) {
				Object value = q.prev.object;
				q.prev.object = q.object;
				q.object = value;
				q = q.prev;
			} else
				q = q.next;
		}
		if (q.next == head) {
			while ((int) q.object < (int) q.prev.object) {
				Object value = q.prev.object;
				q.prev.object = q.object;
				q.object = value;
				q = q.prev;
			}
		}

	}

	// 선택정렬
	public void SelectionSort(int[] array) {
		Node temp = head;
		Node q = head;
		Node ptr = head;
		temp = temp.next;
		ptr = ptr.next;
		while (ptr.next != head) {
			int minNum = (int) ptr.object;
			temp = ptr;
			while (temp.next != head) {
				if (minNum > (int) temp.next.object) {
					minNum = (int) temp.next.object;
				}
				temp = temp.next;
			}
			if (temp.next == head) {
				Object value = q.next.object;
				temp = temp.next.next;
				while (temp != head) {
					if ((int) temp.object == minNum) {
						temp.object = value;
					}
					temp = temp.next;
				}
				q.next.object = minNum;
			}
			q = q.next;
			ptr = ptr.next;
		}

		if (ptr.next == head) {
			while ((int) ptr.object < (int) q.prev.object) {
				Object value = q.prev.object;
				q.prev.object = q.object;
				q.object = value;
				q = q.prev;
			}
		}

	}

	// 전체데이터 출력함수
	public void print() {
		Node p = head;
		System.out.print(p.next.object);
		p = p.next;
		while (p.next != head) {
			System.out.print(" <-> " + p.next.object);
			p = p.next;
		}
		System.out.println("");
	}
}
