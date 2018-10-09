package minHeap;

public class minHeap {
	private int array[];

	public minHeap(int[] array) { // minHeap�� ���� �迭 ������
		this.array = array;
	}

	public void heapify(int[] b, int index, int n) { // heapify�޼ҵ�

		System.out.print(index + " "); // heapify�� ȣ���� index ���

		int temp = b[index];
		while (index < n / 2) { // index���� ��尡 ������尡 �ƴ� ����

			int y = 2 * index + 1; // index��° �ڽ��� ���� �ڽ��� �ε����� y�� �Ѵ�

			if (y + 1 < n) { // index��° �ڽ��� ������ �ڽ��� �����ϴ� ���
				if (b[y] > b[y + 1]) { // �ΰ��� �ڽ��� �� ���� ���� �ε����� y�� �Ѵ�
					y++;
				}
			}
			if (temp <= b[y]) // �ڽ��� �� ū��� minHeap�� �����ϱ⶧���� break
				break;
			b[index] = b[y]; // index�ڸ��� y���� ���Ҹ� �ű��
			index = y; // index�� y�� �ִ´�
		}
		b[index] = temp; // index��° �ڸ��� temp�� ����
	}

	public void build_recu_min_heap(int[] b, int index, int n) {

		if (index >= n / 2) // index��° ��尡 �ڽ��� ���� ��� return
			return;
		build_recu_min_heap(b, 2 * index + 1, n); // ���� �ڽĿ� ���� �Լ� ȣ��
		build_recu_min_heap(b, 2 * index + 2, n); // ������ �ڽĿ� ���� �Լ� ȣ��
		heapify(b, index, n); // index��°�� ���ؼ� heapifyȣ��
	}

}
