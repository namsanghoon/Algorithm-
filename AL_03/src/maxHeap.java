
public class maxHeap {
	public void heapify(int[] arr, int n, int i) {
		int MaxValue = i; //���� index
		int leftChild = 2 * i + 1; // ���� index�� �����ڽ�
		int rightChild = 2 * i + 2; // ���� index�� �������ڽ�

		if (leftChild < n && arr[leftChild] > arr[MaxValue]) //�����ڽ� ���� �θ𺸴� ũ��
			MaxValue = leftChild;//�����ڽ� index�� MaxValue�� ����

		if (rightChild < n && arr[rightChild] > arr[MaxValue])//������ �ڽ� ���� �θ𺸴� ũ��
			MaxValue = rightChild;//�������ڽ� index�� MaxValue�� ����

		if (MaxValue != i) { // maxValue���� ���ߴٸ�
			swap(arr, i, MaxValue);//�� ��ȯ
			heapify(arr, n, MaxValue); //reculsive�ϰ� heap����
		}
	}

	// build-heap �޼ҵ�
	public void build_max_heap(int[] arr, int n) {
		for (int i = n / 2 - 1; i >= 0; i--)
			heapify(arr, n, i);
	}

	// max heap sort�޼ҵ�
	public void MaxHeapSort(int arr[], int n) {
		build_max_heap(arr, n);
		// �Ѱ��� ���� ����
		for (int i = n - 1; i >= 0; i--) {
			swap(arr, 0, i);//���� ���� �� ������ ����
			heapify(arr, i, 0);//������ �迭���� �ٽ� heapify
		}
	}

	// swap �޼ҵ�
	public void swap(int[] a, int i, int j) {
		// TODO Auto-generated method stub
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	public void print(int arr[], int n) {
		for (int i = 0; i < n; ++i)
			System.out.print(arr[i] + " ");
		System.out.println();
	}

}
