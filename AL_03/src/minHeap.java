
public class minHeap {
	// heapify메소드
	public void heapify(int[] arr, int n, int i) {
		int minValue = i;
		int leftChild = 2 * i + 1;
		int rightChild = 2 * i + 2;

		if (leftChild < n && arr[leftChild] < arr[minValue])
			minValue = leftChild;

		if (rightChild < n && arr[rightChild] < arr[minValue])
			minValue = rightChild;

		if (minValue != i) {
			swap(arr, i, minValue);
			heapify(arr, n, minValue);
		}
	}

	// build-heap 메소드
	public void build_min_heap(int[] arr, int n) {
		for (int i = n / 2 - 1; i >= 0; i--)
			heapify(arr, n, i);
	}

	// minheap sort메소드
	public void MinHeapSort(int arr[], int n) {
		build_min_heap(arr, n);
		for (int i = n - 1; i >= 0; i--) {
			swap(arr, 0, i);
			heapify(arr, i, 0);
		}
	}
	
	// swap 메소드
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
