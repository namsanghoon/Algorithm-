package al_02;

public class QuickSort {
	public void quickSort(int A[], int left, int right) {
		if (left < right) {
			int pivot = partition(A, left, right); // 분할
			quickSort(A, left, pivot - 1); // 왼쪽 부분배열 정렬
			quickSort(A, pivot + 1, right); // 오른쪽 부분배열 정렬
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

					swap(a, j, i + 1);
					i++;
				}
				j++;
			}
			swap(a, pivot, i + 1);
		}
		pivot = i + 1;

		return pivot;
	}

	public void quickSortRandom(int a[], int left, int right) {
		int L = left;
		int R = right;
		int pivot = a[100];
		// Pivot 기준으로 양쪽에 정렬
		// (왼쪽에 피봇보다 작은수, 오른쪽에 피봇보다 큰 수가 위치)
		do {
			while (a[L] < pivot)
				L++;
			while (a[R] > pivot)
				R--;
			if (L <= R) {
				swap(a,L,R);
				L++;
				R--;
			}
		} while (L <= R);
		// 0 부터 pivot 전까지
		if (left < R)
			quickSort(a, left, R);
		// pivot 후 부터 마지막까지
		if (right > L)
			quickSort(a, L, right);

	}

	private void swap(int[] a, int i, int j) {
		// TODO Auto-generated method stub
		int tmp;
		tmp = a[i];
		a[i] = a[j];
		a[j] = tmp;
	}

}
