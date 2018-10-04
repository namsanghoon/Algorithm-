package al_02;

public class QuickSort {
	public void quickSort(int A[], int left, int right) {
	    if(left<right) {
	        int pivot = partition(A, left, right);    // 분할
	        quickSort(A, left, pivot-1);    // 왼쪽 부분배열 정렬
	        quickSort(A, pivot+1, right);    // 오른쪽 부분배열 정렬
	    }
	}

	public int partition(int[] a, int left, int right) {
	
		// TODO Auto-generated method stub
		int pivot = right;
	    int i = left - 1;
	    int j = left;
	    int tmp;
	    
	    if (left < right) {
	        while (j < right) {
	            if (a[j] < a[pivot]) {
	                tmp = a[j];
	                a[j] = a[i + 1];
	                a[i + 1] = tmp;
	                i++;
	            }
	            j++;
	        }
	        tmp = a[pivot];
	        a[pivot] = a[i + 1];
	        a[i + 1] = tmp;
	    }
	    pivot = i + 1;

	    return pivot;
	}
	public void quickSortRandom(int A[], int left, int right) {
	    if(left<right) {
	        int pivot = partitionRandom(A, left, right);    // 분할
	        quickSortRandom(A, left, pivot-1);    // 왼쪽 부분배열 정렬
	        quickSortRandom(A, pivot+1, right);    // 오른쪽 부분배열 정렬
	    }
	}
	public int partitionRandom(int[] a, int left, int right) {
		
		// TODO Auto-generated method stub
		int pivot_index = 45;
		int pivot_value = a[pivot_index];
		swap(a, pivot_index, right);
		int store_index = left;
		for(int i =left;i<right;i++) {
			if(a[i]<pivot_value) {
				swap(a, i, store_index);
				store_index += 1;
			}
		}
		swap(a, right, store_index);
		return store_index;
	}

	private void swap(int[] a, int i, int j) {
		// TODO Auto-generated method stub
		int tmp;
		tmp = a[i];
		a[i] = a[j];
		a[j] = tmp;
	}




}
