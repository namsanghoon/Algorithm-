
public class maxHeap {
	public void heapify(int[] arr, int n, int i) {
		int MaxValue = i; //현재 index
		int leftChild = 2 * i + 1; // 현재 index의 왼쪽자식
		int rightChild = 2 * i + 2; // 현재 index의 오른쪽자식

		if (leftChild < n && arr[leftChild] > arr[MaxValue]) //왼쪽자식 값이 부모보다 크면
			MaxValue = leftChild;//왼쪽자식 index를 MaxValue에 저장

		if (rightChild < n && arr[rightChild] > arr[MaxValue])//오른쪽 자식 값이 부모보다 크면
			MaxValue = rightChild;//오른쪽자식 index를 MaxValue에 저장

		if (MaxValue != i) { // maxValue값이 변했다면
			swap(arr, i, MaxValue);//값 교환
			heapify(arr, n, MaxValue); //reculsive하게 heap구성
		}
	}

	// build-heap 메소드
	public void build_max_heap(int[] arr, int n) {
		for (int i = n / 2 - 1; i >= 0; i--)
			heapify(arr, n, i);
	}

	// max heap sort메소드
	public void MaxHeapSort(int arr[], int n) {
		build_max_heap(arr, n);
		// 한개씩 원소 추출
		for (int i = n - 1; i >= 0; i--) {
			swap(arr, 0, i);//현재 값을 맨 끝으로 보냄
			heapify(arr, i, 0);//나머지 배열들을 다시 heapify
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
