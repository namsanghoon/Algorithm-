
public class maxHeap {
	public void heapify(int[] arr, int n, int i) { 
		int MaxValue = i;
		int leftChild = 2*i+1;
		int rightChild = 2*i+2;
		
		if(leftChild<n && arr[leftChild]>arr[MaxValue])
			MaxValue = leftChild;
		
		if(rightChild<n && arr[rightChild]>arr[MaxValue])
			MaxValue = rightChild;
		
		if(MaxValue != i) {
			swap(arr,i,MaxValue);
			heapify(arr,n,MaxValue);
		}
		}
	//build-heap 메소드
	public void build_max_heap(int[] arr, int n) {
		for (int i = n / 2 - 1; i >= 0; i--)
			heapify(arr, n, i);
	}
	// minheap sort메소드
	public void MaxHeapSort(int arr[], int n) {
		build_max_heap(arr,n);
		for(int i=n-1;i>=0;i--) {
			
			swap(arr,0,i);
			heapify(arr,i,0);
		}

	}
	//swap 메소드
	public void swap(int[] a, int i, int j) {
		// TODO Auto-generated method stub
		
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	static void print(int arr[], int n) 
    { 
        for (int i = 0; i < n; ++i) 
            System.out.print(arr[i] + " "); 
        System.out.println(); 
    } 

}
